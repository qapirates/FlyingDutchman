package application.rest.v1.general.renderhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.rest.v1.models.DeviceModel;
import application.rest.v1.models.Parameters;
import application.rest.v1.models.Users;
import application.rest.v1.services.AdminOriginGetEntryService;

@Controller
@RequestMapping("/dutchman")
public class GeneralViewRenderHelper {
	
	@GetMapping("/dashboard")
	public static String getTableDetails(Model model) {

		String url = "https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/UserView/1";
		String jsondata =AdminOriginGetEntryService.getEntryElements(url);
		List<DeviceModel> devicemodelHolder = new ArrayList<DeviceModel>();
		List<Parameters> parametermodelHolder = new ArrayList<Parameters>();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		try {
			List<Users> ppl2 = Arrays.asList(mapper.readValue(jsondata, Users[].class));
			for (Users users : ppl2) {
				DeviceModel[] devs = users.getDeviceDetail();
				for (DeviceModel devselement : devs) {
					// frontend device details
					devicemodelHolder.add(new DeviceModel(devselement.getId(), devselement.getDevice_Name(), devselement.getCountry(), devselement.getState(), devselement.getArea(), devselement.getColor(),
							devselement.getLastupdatedon()));
					
					Parameters[] params = devselement.getParameterValues();
					for (Parameters params2 : params) {
//						System.err.println(params2.getName());
						parametermodelHolder.add(new Parameters(params2.getName(), params2.getLastValue(), params2.getInputTime(), params2.getColor(), params2.getAction(), params2.getCorrectiveAction()));
					}
				}
				
			}
			System.err.println(devicemodelHolder);
			System.err.println(parametermodelHolder);
			model.addAttribute("eachdevicedetails", devicemodelHolder);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "userDashboard";
	}
	
}
