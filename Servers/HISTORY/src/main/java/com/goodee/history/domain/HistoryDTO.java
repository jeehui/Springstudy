package com.goodee.history.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDTO {
	private Long historyNo;
	private String userId;
	private String keyword;
	private Date actionDay;
}
