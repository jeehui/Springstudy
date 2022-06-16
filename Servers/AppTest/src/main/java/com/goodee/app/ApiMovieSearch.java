package com.goodee.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMovieSearch {

	public static void main(String[] args) {
		
		  String clientId = "3jDHfO6Nj5Hk3MsXcvI3"; //애플리케이션 클라이언트 아이디값"
	      String clientSecret = "zp1b_UjtoV"; //애플리케이션 클라이언트 시크릿값" 내 애플리케이션에서 구하기
		
	      String text = JOptionPane.showInputDialog("영화 관련 검색어를 입력하세요.");
	      try {
	            text = URLEncoder.encode(text, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("검색어 인코딩 실패",e);
	        }
	      
	      String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;    // json 결과
	      
	      Map<String, String> requestHeaders = new HashMap<>();
	      requestHeaders.put("X-Naver-Client-Id", clientId);
	      requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	      
	      try {
	    	  URL url = new URL(apiURL);
	    	  HttpURLConnection con = (HttpURLConnection)url.openConnection();
	    	  con.setRequestMethod("GET");
	          for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	              con.setRequestProperty(header.getKey(), header.getValue());
	          		}
	       //위에 Map, requestHeaders부분과 for문을 합친게 아래. 주고받을때 쓸 수 있음
	       //  con.setRequestProperty("X-Naver-Client-Id", clientId);
	       //  con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	          					/*여기까지가 요청*/
	          
	          InputStream body = null;
	          
	          int responseCode = con.getResponseCode();
	          									//HTTP_OK: 200 정상코드
	          if(responseCode == HttpURLConnection.HTTP_OK) {
	        	  body = con.getInputStream(); //200뜨면 정상스트림 가져오기
	          } else {
	        	  body = con.getErrorStream(); //200이 아니면 에러스트림 가져오기
	          }
	          
	          InputStreamReader streamReader = new InputStreamReader(body);

	          	//Reader는 Char타입으로 바꿔주는 기능 byte받는 글,그림을 char바꿔주는것
	          	//buffered는 속도 올리기
	          	//데이터를 문자로 바꾸고 속도를 내고 StringBuilder가 받음.
	          	//BufferedReader lineReader = new BufferedReader(streamReader) = br.close 안쓰려고 만듦.
		          
	          	StringBuilder responseBody = new StringBuilder();

	          	try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	          		String line;
	          		while ((line = lineReader.readLine()) != null) {
	                  responseBody.append(line);
	              }
	        	  
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	        
	        File dir = new File("C:\\storage");
	        if(dir.exists() == false) {
	        	dir.mkdirs(); //storage파일이 없으면 만들어라
	        }
	        File file = new File(dir, "movie.html");
	        PrintWriter out = new PrintWriter(new FileWriter(file));
	        
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title>");
	        out.println("영화검색결과");
	        out.println("</title>");
	        out.println("</head>");
	        out.println("<body>");
	        
	      	JSONObject result = new JSONObject(responseBody.toString());
	      	
	      	JSONArray items = result.getJSONArray("items");
	        for(int i = 0; i < items.length(); i++) {
	        	//items[i](x)
	        	//items.get(i) (o) 배열과 다른 점!
	        	JSONObject item = items.getJSONObject(i);
	        	String title = item.getString("title");
	        	String link = item.getString("link");
	        	String image = item.getString("image");
	        	String userRating = item.getString("userRating");
	        	out.println("<div>");
	        	out.println("<a href=\"" + link +  "\">" + title + "</a><br>");
	        	out.println("<img src=\"" + image +  "\" width=\"300px\"><br>");
	        	out.println("<span>평점 " + userRating + "</span>");
	        	out.println("</div>");
	        }
	        
	        out.println("</body>");
	        out.println("</html>");
	        out.flush();
	        out.close();
	        System.out.println("movie.html 파일이 생성되었습니다.");
	      	
	      	}catch(Exception e) { //오류파일을 만들고 싶으면 여기서 작업하면 됨 위에 File응용
	      		e.printStackTrace();
	      	}

	}
}
