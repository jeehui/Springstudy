package com.goodee.movie.service;

import java.util.List;
import java.util.Map;

import com.goodee.movie.domain.MovieDTO;

public interface MovieService {
		//전체목록서비스
			public List<MovieDTO> findAllMovie();
			//검색서비스
			public List<MovieDTO> findMovieByQuery(Map<String, Object> map);
}
