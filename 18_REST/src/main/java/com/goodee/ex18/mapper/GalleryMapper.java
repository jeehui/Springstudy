package com.goodee.ex18.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.ex18.domain.FileAttachDTO;
import com.goodee.ex18.domain.GalleryDTO;

@Mapper
public interface GalleryMapper {
	public int insertGallery(GalleryDTO gallery);
	public int insertFileAttach(FileAttachDTO fileAttach);
}
