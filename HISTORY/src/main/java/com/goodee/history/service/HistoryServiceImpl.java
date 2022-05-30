package com.goodee.history.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.history.domain.HistoryDTO;
import com.goodee.history.mapper.HistoryMapper;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryMapper historyMapper;
	
	@Override
	public List<HistoryDTO> findAllHistories() {
		return historyMapper.selectHistories();
	}

	@Override
	public List<HistoryDTO> findHistoryByQuery(Map<String, Object> map) {
		return historyMapper.selectHistoryByQuery(map);
	}

}
