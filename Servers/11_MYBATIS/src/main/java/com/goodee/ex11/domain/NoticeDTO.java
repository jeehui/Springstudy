package com.goodee.ex11.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
	private Long noticeNo; 
	private String title;
	private String content;
	private Integer hit;
	private Timestamp created;
	private Timestamp lastModified;
}
