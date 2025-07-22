package com.kh.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.mapper.MemberMapper;
import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

/*@Autowired
* 스프링 프레임워크에서 의존성 주입(DI : Dependency Injection)을 자동화하는 어노테이션
* 스프링 컨테이너가 관리하는 빈(Bean) 중에서 타입이 일치하는 빈을 자동으로 찾아 주입해줌
* (개발자가 직접 객체 생성, 설정하는 대신 스프링이 알아서 객체 연결)
* 
* 주요 특징 :
*  1) 의존성 주입 : 객체 간 의존관계를 코드 외부에서 설정해주는 디자인 패턴
*  2) 자동 주입 : 스프링 컨테이너가 자동으로 의존성 해결
*  3) 다양한 주입방식 : 생성자, setter 메소드, 필드 등 
*  4) 자동으로 빈 찾기 : 빈의 타입(class)을 기준으로 필요한 빈 값 찾음 
*
* 주의 사항 : 빈들이 반드시 스프링 컨테이너에 등록되어 있어야 함
* 타입으로 구분 어려울 경우, @Qualifier 어노테이션 함께 사용해서 구체적인 빈 지정
*
*/

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper; 
	
	public void register(Member member) {
		mapper.register(member);
	}
	
	public Member login(Member member) {
	 return	mapper.login(member);
	}
	
	public List<Member> allMember(){
		return mapper.allMember();
	}
	
	public void update(Member member){
		mapper.update(member);
		
	}
	
	public void delete(String id) {
		mapper.delete(id);
	}
	
	public List<Member> search(SearchDTO dto) {
		return mapper.search(dto);
	}
	
	public void selectDelete(List<String> idList) {
		mapper.selectDelete(idList);
	}

}
