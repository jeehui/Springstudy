package com.goodee.ex09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.ex09.domain.NoticeDTO;
import com.goodee.ex09.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public List<NoticeDTO> findNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeDTO findNoticeByNo(Long noticeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(NoticeDTO notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int change(NoticeDTO notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Long noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
