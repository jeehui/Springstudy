package com.goodee.ex15.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.ex15.domain.FileAttachDTO;
import com.goodee.ex15.domain.GalleryDTO;

@Mapper
public interface GalleryMapper {
	public int insertGallery(GalleryDTO gallery);
	public int insertFileAttach(FileAttachDTO fileAttach);
	public int selectGalleryCount();
	public List<FileAttachDTO> selectGalleryList(Map<String, Object> map);
	public FileAttachDTO selectFileAttachByNo();
}
