package com.goodee.ex11.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.ex11.domain.NoticeDTO;

// @Mapper
// 안녕 난 mapper야.
// 내 메소드를 호출하면 notice.xml의 쿼리문이 실행되지.


@Mapper
public interface NoticeMapper {
	
	// notice.xml에 등록된 쿼리문의 id를 추상메소드로 작성
	public List<NoticeDTO> selectNoticeList();
	// public int insertNotice(NoticeDTO notice);
	public int insertNotice(NoticeDTO notice);
	public NoticeDTO selectNoticeByNo(Long noticeNo);
	public int updateHit(Long noticeNo);
	public int updateNotice(NoticeDTO notice);
	public int deleteNotice(Long noticeNo);
	public int deleteNoticeList(List<Long> list);
}
