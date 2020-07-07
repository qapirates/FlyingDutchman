package application.rest.v1.admin.renderHelper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.rest.v1.models.DeviceModel;
import application.rest.v1.services.AdminOriginGetEntryService;

@Controller
@RequestMapping("/admin")
public class RenderViews {

	@GetMapping("/addNew")
	public static String getView() {
		return "deviceDetails";
	}

	@GetMapping("/details")
	public static String getTableDetails(Model model) {

		String url = "https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/DeviceDetails";
		String jsondata =AdminOriginGetEntryService.getEntryElements(url);
		//System.err.println("JSON " + jsondata);
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<DeviceModel> ppl2 = Arrays.asList(mapper.readValue(jsondata, DeviceModel[].class));
			model.addAttribute("devicedata", ppl2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		

		return "showDetails";


	}
}
