package com.goodee.ex05.controller;

import java.io.File;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.ex05.domain.ReservationDTO;
import com.goodee.ex05.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired //필드 주입은 별로 선호되지 않음.
	private ReservationService reservationService;
	
	// produces는 ResponseEntity 내부에 포함된다. (application/json; charset=UTF-8)
	// @ResponseBody는 작성하지 않아도 된다.
	//ResponseEntity<전달할 데이터>
	@GetMapping(value="/reservation/detail1")
	public ResponseEntity<ReservationDTO>detail1(HttpServletRequest request){
		return reservationService.detail1(request);
	}
	
	@GetMapping(value="/reservation/detail2")
	public ResponseEntity<ReservationDTO>detail2(@RequestParam Long no){
			return reservationService.detail2(no);
		}
	
	@PostMapping(value="/reservation/detail3")
	public ResponseEntity<ReservationDTO>detail3(@RequestBody ReservationDTO reservation){
		return reservationService.detail3(reservation); //no만 보내서 name이 없다
	}
	
	@GetMapping(value="/reservation/image")
	public ResponseEntity<byte[]> image(){
		return reservationService.image();
	}
	
}
	

