package com.project.samsam.sujin.service;

import java.util.List;

import com.project.samsam.sujin.dto.Payang;

public interface PayangService {

	
	// 게시글 목록 조회
	public List<Payang> list() throws Exception;
	
	// 게시글 쓰기
	public void register(Payang payang) throws Exception;
	
	// 게시글 읽기
	public Payang read(Integer p_no) throws Exception;
	
	// 게시글 수정
	public void modify(Payang payang) throws Exception;
	
	// 게시글 삭제
	public void remove(Integer p_no) throws Exception;
	
	
}
