package application.rest.v1.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.rest.v1.general.staticParameterMap.ParamMap;
import application.rest.v1.models.DeviceModel;
import application.rest.v1.models.GraphValParameter;
import application.rest.v1.models.Parameters;
import application.rest.v1.models.Users;
import application.rest.v1.services.AdminOriginGetEntryService;

@RestController
@RequestMapping("/userorigin")
@EnableAsync
public class UserOrigin {

	// Fusion Chart Generator
	@GetMapping("/detailGraphData/{paramName}/{filterType}/{deviceId}")
	public @ResponseBody String generateGraphData(@PathVariable("paramName") String paramName, @PathVariable("filterType") String filterType, @PathVariable("deviceId") String deviceId) throws Exception {
		int paramId = ParamMap.returnParameterMap(paramName);
		String sendableJson = "";
		final String POST_PARAMS = "{\n" + "\"DeviceID\": "+deviceId+",\r\n" +
				"    \"ParameterID\": "+paramId+",\r\n" +
				"    \"Type\": \""+filterType+"\""
				+ "}";
		//System.out.println(POST_PARAMS);
		URL obj = new URL("https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/DeviceGrpahs");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		int responseCode = postConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in .readLine()) != null) {
				response.append(inputLine);
			} in .close();
			// print result
			String responseString = response.toString();
			LocalDateTime myObj = LocalDateTime.now();
			String jsonable = responseString.substring(responseString.indexOf("\"parameterValues\":")+18, responseString.length()-1);
//			System.err.println("json : " + jsonable);
			/*
			 * Parse The Fusion JSON here
			 * */
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			String labels = "";
			String values = "";
			List<GraphValParameter> graphloader = Arrays.asList(mapper.readValue(jsonable, GraphValParameter[].class));
			for (GraphValParameter g : graphloader) {
				labels += "{\"label\":\""+g.getDate()+"\"},";
				values += "{\"value\":\""+g.getValue()+"\"},";
			}
			String newLabel = labels.substring(0, labels.length()-1);
			String newValue = values.substring(0, values.length()-1);
			String unit = "";
			String hexcolor = "";
			if(paramId == 1) {
				unit = "\u00B0C";
				hexcolor = "#6A6A53";
			} else if (paramId == 2) {
				unit = "pH";
				hexcolor = "#0AACF7";
			} else if (paramId == 3) {
				unit = "mg/Lt";
				hexcolor = "#76196F";
			} else if (paramId == 4) {
				unit = "mg/Lt";
				hexcolor = "#05F891";
			} else if (paramId == 5){
				unit = "mg/Lt";
				hexcolor = "#EC11EC";
			}
			String chart = "\"chart\": {\r\n" + 
					"        \"theme\": \"fusion\",\r\n" + 
					"        \"caption\": \"\",\r\n" + 
					"        \"subCaption\": \"\",\r\n" + 
					"        \"xAxisName\": \"Date\",\r\n" + 
					"        \"yAxisName\": \""+unit+"\",\r\n" + 
					"        \"numberPrefix\": \"\",\r\n" + 
					"        \"lineThickness\": \"3\",\r\n" + 
					"        \"formatNumberScale\": \"0\",\r\n"+
					"        \"exportEnabled\": \"1\","+
					"         \"lineColor\":\""+hexcolor+"\",\r\n"+
					"        \"flatScrollBars\": \"1\",\r\n" + 
					"        \"exportFileName\":\""+paramName+" Report"+ myObj +"\","+
					"        \"scrollheight\": \"10\",\r\n" + 
					"        \"numVisiblePlot\": \"12\",\r\n" + 
					"        \"showHoverEffect\": \"1\"\r\n" + 
					"      },";

			// Fusion Json
			sendableJson = "{"+chart + "\"categories\": [{\"category\": ["+newLabel+"]}],"+"\"dataset\": [{\"data\": ["+newValue+"]}]}";
//			System.err.println("EPSD : " + sendableJson);

		} else {
			System.out.println("POST NOT WORKED");
		}
		//System.err.println("paramName : " + paramName + " type : " + filterType + " DeviceID : " + deviceId);
		return sendableJson;
	}

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

	@GetMapping("/parameterDetails/{deviceid}")
	public @ResponseBody JsonNode parameterCounter(@PathVariable("deviceid") String deviceid) throws IOException {
		String url = "https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/ValuesByDevice/"+deviceid;
		String jsonData =AdminOriginGetEntryService.getEntryElements(url);
		//		byte[] jsonData = Files.readAllBytes(Paths.get("E:\\Parameter.json"));
		JsonNode actualObj = null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		String actual = "";
		String holder = "";
		String importer = "";
		JsonFactory factory = mapper.getFactory();

		try {
			actualObj = mapper.readTree(jsonData);
			String parsedParameterList = actualObj.get("parameterNames").toString();

			JsonParser parser = factory.createParser(parsedParameterList);
			actualObj = mapper.readTree(parser);
			List<Parameters> parameters = Arrays.asList(mapper.readValue(actualObj.toString(), Parameters[].class));
			for (Parameters p : parameters) {
				holder += "\""+ p.getName() +"\"" + ",";
			}
			importer = holder.substring(0, holder.length()-1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String s = "["+importer+"]";
		JsonParser parser1 = factory.createParser(s);
		actualObj = mapper.readTree(parser1);
		return actualObj;
	}

	
}
