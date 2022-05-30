package com.goodee.history.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.history.domain.HistoryDTO;

@Mapper
public interface HistoryMapper {
	public List<HistoryDTO> selectHistories();
	public List<HistoryDTO> selectHistoryByQuery(Map<String, Object> map);
}
