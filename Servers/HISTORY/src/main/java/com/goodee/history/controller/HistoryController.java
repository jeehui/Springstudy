package com.goodee.history.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.history.domain.HistoryDTO;
import com.goodee.history.service.HistoryService;

@Controller
public class HistoryController {

	@Autowired
	private HistoryService historyService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping(value="/history/searchAll", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchAll() {
		
		Map<String, Object> map = new HashMap<>();
		
		List<HistoryDTO> histories = historyService.findAllHistories();
		
		if(histories.size() == 0) {
			map.put("msg", "목록이 존재하지 않습니다.");
			map.put("histories", null);
			map.put("status", 0);
		} else {
			map.put("msg",  histories.size() + "개의 목록이 있습니다.");
			map.put("histories", histories);
			map.put("status", 1);
		}
		
		return map;
		
	}
	
	@ResponseBody
	@PostMapping(value="/history/search", produces="application/json; charset=UTF-8")
	public Map<String, Object> search(@RequestBody Map<String, Object> map){
		
		Map<String, Object> result = new HashMap<>();
		
		List<HistoryDTO> histories = historyService.findHistoryByQuery(map);
		
		if(histories.size() == 0) {
			result.put("msg", map.get("searchText").toString() + " 검색 결과가 없습니다.");
			result.put("histories", null);
			result.put("status", 0);
		} else {
			result.put("msg", histories.size() + "개의 목록을 가져왔습니다.");
			result.put("histories", histories);
			result.put("status", 1);
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
