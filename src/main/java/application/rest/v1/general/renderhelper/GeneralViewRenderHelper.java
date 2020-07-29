package application.rest.v1.general.renderhelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.rest.v1.models.DeviceModel;
import application.rest.v1.models.IndevidualDeviceHolder;
import application.rest.v1.models.IndevidualDeviceMain;
import application.rest.v1.models.IndevidualDeviceParams;
import application.rest.v1.models.Parameters;
import application.rest.v1.models.Users;
import application.rest.v1.services.AdminOriginGetEntryService;

@Controller
@RequestMapping("/dutchman")
public class GeneralViewRenderHelper {
	/*
	 * Hard Coaded For user 1 
	 * */
	
	@GetMapping("/dashboard")
	public static String getTableDetails(Model model) {

		String url = "https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/UserView/1";
		String jsondata =AdminOriginGetEntryService.getEntryElements(url);
		List<DeviceModel> devicemodelHolder = new ArrayList<DeviceModel>();
			
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		try {
			//System.err.println(jsondata);
			List<Users> ppl2 = Arrays.asList(mapper.readValue(jsondata, Users[].class));
			for (Users users : ppl2) {
				DeviceModel[] devs = users.getDeviceDetail();
				for (DeviceModel devselement : devs) {
					// front end device details
					//List<Parameters> parameterModelHolder =Arrays.asList(devselement.getParameterValues());
					System.err.println();
					devicemodelHolder.add(new DeviceModel(devselement.getId(), devselement.getDevice_Name(), devselement.getCountry(), devselement.getState(), devselement.getArea(), devselement.getColor(),
							devselement.getLastupdatedon()));
				}
			}
			
			model.addAttribute("eachdevicedetails", devicemodelHolder);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "userDashboard";
	}
	
	@GetMapping("/details")
	public static String getIndevidualDeviceDetails(@RequestParam(name = "device") String device,  ModelMap model) {
		String url = "https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/ValuesByDevice/"+device;
		String jsondata =AdminOriginGetEntryService.getEntryElements(url);
		
		List<IndevidualDeviceHolder> indevidualAnalysis = new ArrayList<IndevidualDeviceHolder>();
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectMapper mapper1 = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper1.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		try {
			JsonNode actualObj = mapper.readTree(jsondata);
			String entries = actualObj.get("entries").toString();
			String parsedParameterList = actualObj.get("parameterNames").toString().substring(1, actualObj.get("parameterNames").toString().length()-1);
			String headWithOutQuot = parsedParameterList.replace("\"", " ");
			/*
			 * Create Header
			 * */
			List<String> TABLEHEADER = Arrays.asList(headWithOutQuot);
			/*
			 * Create Rows
			 * */
			List<Map<String, String>> rows = new ArrayList<>();
			System.err.println(TABLEHEADER);
			String parsed = mapper1.readTree(entries).toString();
			List<IndevidualDeviceMain> analysis = Arrays.asList(mapper.readValue(parsed, IndevidualDeviceMain[].class));
			for (IndevidualDeviceMain im : analysis) {				
				IndevidualDeviceParams[] idp = im.getParams();
				String parameter ="";
				for (IndevidualDeviceParams indpam : idp) {
					parameter += indpam.getValue()+",";
				}
				parameter = parameter.substring(0, parameter.length()-1);
				
				indevidualAnalysis.add(new IndevidualDeviceHolder(im.getDatetime(), parameter));
			}

			//model.addAttribute("header", TABLEHEADER);
			model.addAttribute("indevidual", indevidualAnalysis);
					
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return "indevidualDeviceDetails";
	}
	
}
