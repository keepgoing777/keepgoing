package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.model.vo.Board;

@Service
public class BoardService implements BoardMapper{
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void insert(Board vo) {
		mapper.insert(vo);
	}

	@Override
	public List<Board> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public Board select(int no) {
		return mapper.select(no);
	}

	@Override
	public void update(Board vo) {
		mapper.update(vo);
	}

	@Override
	public void delete(int no) {
		mapper.delete(no);
	}
	
}
