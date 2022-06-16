package com.goodee.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

public class ApiSearchBook {

	public static void main(String[] args) throws IOException {
		String clientId = "gO15KVU9H9Xk6Cl2Eorw"; 
	      String clientSecret = "YQOS7NPGFV";
		
	      String text = JOptionPane.showInputDialog("책 관련 검색어를 입력하세요.");
	      try {
	            text = URLEncoder.encode(text, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("검색어 인코딩 실패",e);
	        }
	      
	      String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;
	
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
	    	  
	    	  InputStream body = null;
	    	  int responseCode = con.getResponseCode();
				if(responseCode == HttpURLConnection.HTTP_OK) {
				body = con.getInputStream(); 
				} else {
				body = con.getErrorStream(); 
			   }
				
				InputStreamReader streamReader = new InputStreamReader(body);
	
				StringBuilder responseBody = new StringBuilder();

	          	try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	          		String line;
	          		while ((line = lineReader.readLine()) != null) {
	                  responseBody.append(line);
	              }
	          	
	          	}catch(Exception e) {
	  	    	  e.printStackTrace();
	  	      }	
				
	          	File dir = new File("C:\\download");
		        if(dir.exists() == false) {
		        	dir.mkdirs(); //storage파일이 없으면 만들어라
		        }
		        File file = new File(dir, "자바.html");
		        PrintWriter out = new PrintWriter(new FileWriter(file));
		        
		        out.println("<!DOCTYPE html>");
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<meta charset=\"UTF-8\">");
		        out.println("<title>");
		        out.println("책검색결과");
		        out.println("</title>");
		        out.println("</head>");
		        out.println("<body>");
		        
		        JSONObject result = new JSONObject(responseBody.toString());
		        JSONArray items = result.getJSONArray("items");
		        for(int i = 0; i < items.length(); i++) {
		        	JSONObject item = items.getJSONObject(i);
		        	String title = item.getString("title");
		        	String link = item.getString("link");
		        	String image = item.getString("image");
		        	out.println("<div>");
		        	out.println("<a href=\"" + link +  "\">" +  title + "</a><br>");
		        	out.println("<img src=\"" + image +  "\" width=\"500px\"><br>");
		        	out.println("</div>");
		        }
		        
		        out.println("</body>");
		        out.println("</html>");
		        out.flush();
		        out.close();
		        System.out.println("자바.html 파일이 생성되었습니다.");
	      		
	      		}catch(IOException e) { //오류파일을 만들고 싶으면 여기서 작업하면 됨 위에 File응용
	      			
	      			File dir1 = new File("C:\\download\\log");
			        if(dir1.exists() == false) {
			        	dir1.mkdirs(); //storage파일이 없으면 만들어라
			        }
			        File error = new File(dir1, "error_log.txt");
			        PrintWriter out1 = new PrintWriter(new FileWriter(error));
			        out1.println("<!DOCTYPE html>");
			        out1.println("<html>");
			        out1.println("<head>");
			        out1.println("<meta charset=\"UTF-8\">");
			        out1.println("<script>");
			        out1.println("e.getMessage();");
			        out1.println("</script>");
			        out1.flush();
			        out1.close();
			        e.printStackTrace();
			        
	      	}
	      }

	}



