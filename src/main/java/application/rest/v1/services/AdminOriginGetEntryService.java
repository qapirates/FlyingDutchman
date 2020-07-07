package application.rest.v1.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AdminOriginGetEntryService {
	
	public static String getEntryElements(String urls) {
		
		URL urlForGetRequest;
		String jsonResponse = "";
		try {
			urlForGetRequest = new URL(urls);
			String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    try {
				conection.setRequestMethod("GET");
				//conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
			    int responseCode = conection.getResponseCode();
			    if (responseCode == HttpURLConnection.HTTP_OK) {
			        BufferedReader in = new BufferedReader(
			            new InputStreamReader(conection.getInputStream()));
			        StringBuffer response = new StringBuffer();
			        while ((readLine = in .readLine()) != null) {
			            response.append(readLine);
			        } in .close();
			        // print result
			         jsonResponse = response.toString();
			        //GetAndPost.POSTRequest(response.toString());
			    } else {
			        System.err.println("GET NOT WORKED");
			    }
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    
	    return jsonResponse;
		
	}

}
