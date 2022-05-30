package com.goodee.movie.util;

public class SecurityUtils {
	
	public static String XSS(String s) {
		s = s.replaceAll("<", "&lt;");
		s = s.replaceAll(">", "&gt;");
		s = s.replaceAll("\"", "&quot;");
		s = s.replaceAll("\'",  "&#x27");
		return s;
	}
	
}
