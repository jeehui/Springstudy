package com.goodee.ex15.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodee.ex15.domain.FileAttachDTO;
import com.goodee.ex15.domain.GalleryDTO;

public interface GalleryService {
	public void findGalleries(HttpServletRequest request, Model model);
	public GalleryDTO findGalleryByNo(Long galleryNo);
	public FileAttachDTO findFileAttachByNo(Long fileAttachNo);
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void change(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void remove(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	
}