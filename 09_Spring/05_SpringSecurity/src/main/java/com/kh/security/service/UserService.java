package com.kh.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserMapper mapper;
	
	//Security 방법
	//private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	@Autowired
    private PasswordEncoder bcpe;
	
	public void register(User vo) {
		//System.out.println("암호화 전 : " + vo.getPwd());
		vo.setPwd(bcpe.encode(vo.getPwd()));
		//System.out.println("암호화 후 :" + bcpe.encode(vo.getPwd()));
		
		if(vo.getId().equals("admin")) {
			vo.setRole("ROLE_ADMIN");
		} else {
			vo.setRole("ROLE_USER");
		}
		mapper.register(vo);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = mapper.login(username);
		return user;
	} 

/* Userdetail 쓰면서 삭제(session 방법)
	@Override
	public User login(String id) {
		return null;
	}
*/
	
}
