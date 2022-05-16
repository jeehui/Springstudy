package com.goodee.ex05.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenapiServiceImpl implements OpenapiService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//인증키
		String servicekey = "a9339e91cdf3436f1af3e77716623388";
		
		//API 주소
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json");
			sb.append("?servicekey=").append(URLEncoder.encode(servicekey, "UTF-8"));
			sb.append()
		}
				
		
	}

}
