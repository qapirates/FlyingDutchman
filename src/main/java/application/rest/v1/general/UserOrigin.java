package application.rest.v1.general;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.rest.v1.services.AdminOriginGetEntryService;

@RestController
@RequestMapping("/userorigin")
public class UserOrigin {

	@GetMapping("/detailDeviceData/{deviceid}")
	public @ResponseBody JsonNode generateDetailData(@PathVariable("deviceid") String deviceid) {
		String url = "https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/ValuesByDevice/"+deviceid;
		JsonNode actualObj = null;
		String jsondata =AdminOriginGetEntryService.getEntryElements(url);
		String generatabletablejson = jsondata.substring(jsondata.indexOf('['), jsondata.lastIndexOf('}'));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		try {
			JsonFactory factory = mapper.getFactory();
		    JsonParser parser = factory.createParser(generatabletablejson);
		    actualObj = mapper.readTree(parser);		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return actualObj;
	}

}
