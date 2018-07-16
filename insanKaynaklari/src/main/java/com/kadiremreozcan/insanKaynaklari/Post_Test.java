package com.kadiremreozcan.insanKaynaklari;





import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import com.kadiremreozcan.entity.Adays;


public class Post_Test {
	
	
	
	// HTTP POST request
	public Adays sendPost(String code, String redirect_url, String client_id, String client_secret ) throws Exception {

		String url = "https://www.linkedin.com/oauth/v2/accessToken";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "www.linkedin.com");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri="+redirect_url+"&client_id="+client_id+"&client_secret="+client_secret+"";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'POST' request to URL : " + url);
		//System.out.println("Post parameters : " + urlParameters);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		//System.out.println(response.toString());
		
		JSONObject jsonObj = new JSONObject(response.toString());
		String access_token = jsonObj.getString("access_token");
		//System.out.println(access_token);
		
		Adays obj_aday = new Adays();
		obj_aday = sendGet(access_token);
		
		return obj_aday;

	}
	
	
	
	public Adays sendGet(String access_token) throws Exception {
		

		Adays obj_aday = new Adays();
		

		String url = "https://api.linkedin.com/v1/people/~?format=json";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("Host", "api.linkedin.com");
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Authorization", "Bearer "+	access_token);
		
		

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		//System.out.println(response.toString());
		
		JSONObject jsonObj = new JSONObject(response.toString());
		
		obj_aday.setName(jsonObj.getString("firstName"));
		obj_aday.setSurname(jsonObj.getString("lastName"));
		obj_aday.setHeadline(jsonObj.getString("headline"));
		obj_aday.setLinkedin_id(jsonObj.getString("id"));
		
		//System.out.println(access_token);

		return obj_aday;
	}
	

}
