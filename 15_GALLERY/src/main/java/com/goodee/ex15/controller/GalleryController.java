package com.goodee.ex15.controller;

import java.io.File;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodee.ex15.domain.FileAttachDTO;
import com.goodee.ex15.service.GalleryService;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/gallery/list")
	public String list() {
		return "gallery/list";
	}
	
	@GetMapping("/gallery/savePage")
	public String savePage() {
		return "gallery/save";
	}
	
	@PostMapping("/gallery/save")
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) { 
		galleryService.save(multipartRequest, response);
	}
	
	/*
	  /gallery/disply?type=thmb    썸네일 보여주기
	  
	  /gallery/display 			   원본이미지 보내주기
	  /gallery/display?type=image  
	*/
	
	@ResponseBody
	@GetMapping("/gallery/display")
	//사진은 byte로 쪼개가지고 배열에 보낸다는 의미
	public ResponseEntity<byte[]> display(Long fileAttachNo, @RequestParam(value="type", required = false, defaultValue="image") String type){
		//ResponseEntity는 절대경로 읽을 때 쓰였음 5장 ajax확인
		// 보내줘야 할 이미지 정보(path, saved) 읽기
		FileAttachDTO fileAttach = galleryService.findFileAttachByNo(fileAttachNo);
		
		//보내줘야 할 이미지 파일 연결함.
		File file = null;
		switch(type) {
		case "thumb":
			file = new File(fileAttach.getPath(), "s_" + fileAttach.getSaved());
			break;
		case "image":
			file = new File(fileAttach.getPath(), fileAttach.getSaved());
			break;
		}
		
		//ResponseEntity(응답객체)
		ResponseEntity<byte[]> entity = null;
		try {
			//framework에 있는 HttpHeaders
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
																							// 200 도 가능
			entity = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
}
