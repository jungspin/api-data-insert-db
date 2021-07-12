package com.example.test.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestApiToJson {

	
	public static void main(String[] args) {

		try {
			// 인증키값
			String serialKey = "rKyzRRphHPRl6e3E9COq4s88P1oHyXxniotNKn%2BmOvZryqw0m3ElKZSzP3HQwBXDB7eBtylBImIlOzRsv16X4Q%3D%3D";

			String urlStr = "http://apis.data.go.kr/6260000/FoodService/getFoodKr";
			urlStr += "?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serialKey;
			urlStr += "&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + 5;
			urlStr += "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + 1;
			urlStr += "&" + URLEncoder.encode("resultType", "UTF-8") + "=" + "json";

			URL url = new URL(urlStr);

			String line = "";
			String result = "";

			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = br.readLine()) != null) {
				result = result.concat(line);
				// System.out.println("line = " + line);
				// System.out.println("result = " + result);
			}
			
			// JSON parser 만들어 문자열 데이터를 객체화한다.
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(result); // map 형태
		
           
          
            System.out.println(obj.get("getFoodKr"));
            JSONObject obj2 = (JSONObject)obj.get("getFoodKr"); 
            JSONArray jsonArr = (JSONArray)obj2.get("item");
            System.out.println(jsonArr);
            
            for (int i=0; i < jsonArr.size(); i++) {
            	JSONObject obj3 = (JSONObject) jsonArr.get(i);
            	String title = (String) obj3.get("MAIN_TITLE");
            	System.out.println(title);
            }
            
		
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
