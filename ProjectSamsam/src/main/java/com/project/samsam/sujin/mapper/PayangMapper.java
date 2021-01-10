package com.project.samsam.sujin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.samsam.sujin.dto.Payang;

@Mapper
public interface PayangMapper {
	
	// 게시글 목록 조회
	public List<Payang> list() throws Exception;
	
	
}
