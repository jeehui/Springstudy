package com.goodee.ex10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.ex10.domain.NoticeDTO;
import com.goodee.ex10.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public List<NoticeDTO> findNotices() {
		return noticeRepository.selectNoticeList();
	}

	@Override
	public NoticeDTO findNoticeByNo(Long noticeNo) {
		noticeRepository.updateHit(noticeNo);				//조회수를 늘리고
		return noticeRepository.selectNoticeByNo(noticeNo); //정보를 조회한다. 는 순서로 접근! return하면 돌아올수 없기에 그 전에 쓰기
	}

	@Override
	public int save(NoticeDTO notice) {
		return noticeRepository.insertNotice(notice);
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