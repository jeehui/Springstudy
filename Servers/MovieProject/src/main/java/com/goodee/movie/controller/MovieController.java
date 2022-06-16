package com.goodee.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.movie.domain.MovieDTO;
import com.goodee.movie.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//전체목록
	@ResponseBody
	@GetMapping(value="/movie/searchAllMovies", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchAllMovies(){
		Map<String, Object> map = new HashMap<>();
		
		List<MovieDTO> list = movieService.findAllMovie();
		
		if(list.size() == 0) {
			map.put("msg", "목록이 존재하지 않습니다.");
			map.put("movies", null);
			map.put("status", 500);
		} else {
			map.put("msg", "전체" + list.size() + "개의 목록을 가져왔습니다.");
			map.put("movies", list);
			map.put("stauts", 200);
		}
		
		return map;
	}
	
	@ResponseBody
	@PostMapping(value="/movie/searchMovie", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchMovie(@RequestBody Map<String, Object> map){
		
		Map<String, Object> result = new HashMap<>();
		
		List<MovieDTO> list = movieService.findMovieByQuery(map);
		
		if(list.size() == 0) {
			result.put("msg", map.get("searchText").toString() + "검색 결과가 없습니다.");
			result.put("movie", null);
			result.put("status", 500);
		} else {
			result.put("msg", list.size() + "개의 검색 결과가 있습니다.");
			result.put("movie", list);
			result.put("status", 200);
		}
		
		return result;
	}
}
