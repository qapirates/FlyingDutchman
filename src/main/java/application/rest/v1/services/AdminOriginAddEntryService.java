package application.rest.v1.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AdminOriginAddEntryService {

	public static boolean contactInsertionApi(String GUID, String MAC_Id, String Device_Id, String Status, String country, String states, String area_city, String latitude, String longtitude, String owner) {

		final String POST_PARAMS = "{\n" + "\"GUID\": \""+GUID+"\"," +
				"    \"Mac_ID\": \""+MAC_Id+"\",\r\n" +
				"    \"Device_Name\": \""+Device_Id+"\",\r\n" +
				"    \"Country\": \""+country+"\",\r\n" +
				"    \"State\": \""+states+"\",\r\n" +
				"    \"Area\": \""+area_city+"\",\r\n" +
				"    \"Latitude\": \""+latitude+"\",\r\n" +
				"    \"Longitude\": \""+longtitude+"\",\r\n" +
				"    \"lastupdatedby\": \""+owner+"\",\r\n" +
				"    \"Status\": "+ Status + "\n}";
		System.out.println(POST_PARAMS);
		URL obj;
		boolean returnable = true;
		try {
			obj = new URL("https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/DeviceDetails");
		    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		    postConnection.setRequestMethod("POST");
//		    postConnection.setRequestProperty("userId", "a1bcdefgh");
		    postConnection.setRequestProperty("Content-Type", "application/json");
		    postConnection.setDoOutput(true);
		    OutputStream os = postConnection.getOutputStream();
		    os.write(POST_PARAMS.getBytes());
		    os.flush();
		    os.close();
		    int responseCode = postConnection.getResponseCode();
		    System.out.println("POST Response Code :  " + responseCode);
		    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
		    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
		        BufferedReader in = new BufferedReader(new InputStreamReader(
		            postConnection.getInputStream()));
		        String inputLine;
		        StringBuffer response = new StringBuffer();
		        while ((inputLine = in .readLine()) != null) {
		            response.append(inputLine);
		        } in .close();
		        // print result
		        System.out.println(response.toString());
		    } else {
		        System.out.println("POST NOT WORKED");
		        returnable = false;
		    }
		} catch (IOException e) {
			e.printStackTrace();
			returnable = false;
		}
		
		return returnable;
	}
	
	public static boolean contactUpdateApi(int id, String GUID, String MAC_Id, String Device_Id, String Status, String country, String states, String area_city, String latitude, String longtitude, String owner) {

		final String POST_PARAMS = "{\n" + "\"GUID\": \""+GUID+"\"," +
				"    \"ID\": "+id+",\r\n" +
				"    \"Mac_ID\": \""+MAC_Id+"\",\r\n" +
				"    \"Device_Name\": \""+Device_Id+"\",\r\n" +
				"    \"Country\": \""+country+"\",\r\n" +
				"    \"State\": \""+states+"\",\r\n" +
				"    \"Area\": \""+area_city+"\",\r\n" +
				"    \"Latitude\": \""+latitude+"\",\r\n" +
				"    \"Longitude\": \""+longtitude+"\",\r\n" +
				"    \"lastupdatedby\": \""+owner+"\",\r\n" +
				"    \"Status\": "+ Status + "\n}";
		System.out.println(POST_PARAMS);
		URL obj;
		boolean returnable = true;
		try {
			obj = new URL("https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/DeviceDetails/"+id);
		    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		    postConnection.setRequestMethod("PUT");
//		    postConnection.setRequestProperty("userId", "a1bcdefgh");
		    postConnection.setRequestProperty("Content-Type", "application/json");
		    postConnection.setDoOutput(true);
		    OutputStream os = postConnection.getOutputStream();
		    os.write(POST_PARAMS.getBytes());
		    os.flush();
		    os.close();
		    int responseCode = postConnection.getResponseCode();
		    System.out.println("POST Response Code :  " + responseCode);
		    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
		    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
		        BufferedReader in = new BufferedReader(new InputStreamReader(
		            postConnection.getInputStream()));
		        String inputLine;
		        StringBuffer response = new StringBuffer();
		        while ((inputLine = in .readLine()) != null) {
		            response.append(inputLine);
		        } in .close();
		        // print result
		        System.out.println(response.toString());
		    } else {
		        System.out.println("POST NOT WORKED");
		        returnable = false;
		    }
		} catch (IOException e) {
			e.printStackTrace();
			returnable = false;
		}
		
		return returnable;
	}
	
	public static boolean contactDeleteApi(int id) {

		URL obj;
		boolean returnable = true;
		try {
			obj = new URL("https://piratesbay-chipper-roan-rs.eu-gb.mybluemix.net/api/DeviceDetails/"+id);
		    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		    postConnection.setRequestMethod("DELETE");
//		    postConnection.setRequestProperty("userId", "a1bcdefgh");
		    postConnection.setRequestProperty("Content-Type", "application/json");
		    postConnection.setDoOutput(true);
		    
		    int responseCode = postConnection.getResponseCode();
		    System.out.println("POST Response Code :  " + responseCode);
		    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
		    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
		        BufferedReader in = new BufferedReader(new InputStreamReader(
		            postConnection.getInputStream()));
		        String inputLine;
		        StringBuffer response = new StringBuffer();
		        while ((inputLine = in .readLine()) != null) {
		            response.append(inputLine);
		        } in .close();
		        // print result
		        System.out.println(response.toString());
		        
		    } else {
		        System.out.println("POST NOT WORKED");
		        returnable = false;
		    }
		} catch (IOException e) {
			e.printStackTrace();
			returnable = false;
		}
		
		return returnable;
	}

}
