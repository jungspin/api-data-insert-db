package com.example.test.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.TestApi;
import com.example.test.repository.TestApiRepository;

@Service
public class TestApiService {
	
	@Autowired
	private TestApiRepository testApiRepository;

	public void dataParse() {
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
			JSONObject obj = (JSONObject) parser.parse(result); // map 형태

			System.out.println(obj.get("getFoodKr"));
			JSONObject obj2 = (JSONObject) obj.get("getFoodKr");
			JSONArray jsonArr = (JSONArray) obj2.get("item");
			System.out.println(jsonArr);

			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject obj3 = (JSONObject) jsonArr.get(i);

				String addr1 = (String) obj3.get("ADDR1");
				String cntctTel = (String) obj3.get("CNTCT_TEL");
				String itemcntnts = (String) obj3.get("ITEMCNTNTS");
				Double lat = (Double) obj3.get("LAT");
				Double lng = (Double) obj3.get("LNG");
				String mainImgNormal = (String) obj3.get("MAIN_IMG_NORMAL");
				String mainImgThumb = (String) obj3.get("MAIN_IMG_THUMB");
				String mainTitle = (String) obj3.get("MAIN_TITLE");
				String rprsntvMenu = (String) obj3.get("RPRSNTV_MENU");
				String usageDayWeekAndTime = (String) obj3.get("USAGE_DAY_WEEK_AND_TIME");

				TestApi testApi = new TestApi(null, addr1, cntctTel, itemcntnts, lat, lng, mainImgNormal, mainImgThumb,
						mainTitle, rprsntvMenu, usageDayWeekAndTime);
				System.out.println(testApi);
				testApiRepository.save(testApi);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
