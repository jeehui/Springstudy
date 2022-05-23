package com.goodee.ex10.service;

import java.util.List;

import com.goodee.ex10.domain.NoticeDTO;

public interface NoticeService {
	public List<NoticeDTO> findNotices();
	public NoticeDTO findNoticeByNo(Long noticeNo);
	public int save(NoticeDTO notice);
	public int change(NoticeDTO notice);
	public int remove(Long noticeNo);
}