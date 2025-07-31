package com.kh.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService implements UserMapper {

	@Autowired
	private UserMapper mapper;
	
	//Security 방법
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	

	@Override
	public void register(User vo) {
		
	}


	@Override
	public User login(String id) {
		return null;
	}

	
}
