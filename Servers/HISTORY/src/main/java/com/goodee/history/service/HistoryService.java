package com.goodee.history.service;

import java.util.List;
import java.util.Map;

import com.goodee.history.domain.HistoryDTO;

public interface HistoryService {
	//전체목록서비스
	public List<HistoryDTO> findAllHistories();
	//검색서비스
	public List<HistoryDTO> findHistoryByQuery(Map<String, Object> map);
}
