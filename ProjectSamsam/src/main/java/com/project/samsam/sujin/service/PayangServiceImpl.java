package com.project.samsam.sujin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.samsam.sujin.dto.Payang;
import com.project.samsam.sujin.mapper.PayangMapper;


@Service
public class PayangServiceImpl implements PayangService {

	@Autowired
	private PayangMapper mapper;
	
	@Override
	public List<Payang> list() throws Exception {
		return mapper.list();
	}

	@Override
	public void register(Payang payang) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payang read(Integer p_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Payang payang) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer p_no) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
