package com.goodee.ex18.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface GalleryService {
	public Map<String, Object> save(MultipartHttpServletRequest multipartRequest);
}
