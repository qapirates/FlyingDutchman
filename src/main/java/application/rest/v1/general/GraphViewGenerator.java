package application.rest.v1.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.scheduling.annotation.EnableAsync;
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
import com.fasterxml.jackson.databind.node.ObjectNode;

import application.rest.v1.services.AdminOriginGetEntryService;

@RestController
@RequestMapping("/graph/view")
@EnableAsync
public class GraphViewGenerator {

	@GetMapping("/details/{deviceid}/{ParameterID}/{Type}")
	public @ResponseBody static void generateDetailData(@PathVariable("deviceid") String deviceid, @PathVariable("ParameterID") String ParameterID, @PathVariable("Type") String Type) {

		final String POST_PARAMS = "{\n" + "\"DeviceID\": "+1+",\r\n" +
				"    \"ParameterID\": "+1+",\r\n" +
				"    \"Type\": \""+Type+"\""
				+ "}";
		System.out.println(POST_PARAMS);
		URL obj;
		String counter;
		try {
			obj = new URL("https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/DeviceGrpahs");
			HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
			postConnection.setRequestMethod("POST");
			//				    postConnection.setRequestProperty("userId", "a1bcdefgh");
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setDoOutput(true);
			OutputStream os = postConnection.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			int responseCode = postConnection.getResponseCode();
			System.out.println("POST Response Code :  " + responseCode);
			System.out.println("POST Response Message : " + postConnection.getResponseMessage());
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						postConnection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in .readLine()) != null) {
					response.append(inputLine);
				} in .close();
				// print result
				counter = response.toString();
				final ObjectNode node = new ObjectMapper().readValue(counter, ObjectNode.class);
				if (node.has("parameterValues")) {
					System.out.println("parameterValues: " + node.get("parameterValues"));
				} 
			} else {
				System.out.println("POST NOT WORKED");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
