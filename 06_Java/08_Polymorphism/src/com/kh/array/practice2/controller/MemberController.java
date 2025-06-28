package com.kh.array.practice2.controller;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	private Member[] members = new Member[3];
    public int count = 0;
	// 메서드 분리!
	// 아이디 체크 <- 등록 할 때도 필요, 수정할때도 필요, 여기저기 필요하기때문에

    //members - getter
    public Member[] getMembers() {
    	return members;
    }
    
	// 아이디 체크
	public int idCheck(String id) {
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].getId().equals(id)) {
				return i;
			}
		}
		return -1; // 아이디가 없는 경우 리턴값
	}

	// 추가 로직
	public void addInfo(Member m) {
       members[count++] = m;
	}

	// 2번 정보 수정
	public void updateInfo(String id, String name, String email, String pwd) {
		int index = idCheck(id);
		if (members[index] != null && members[index].getId().equals(id)) {
			members[index].setName(name);
			members[index].setEmail(email);
			members[index].setPwd(pwd);
		}
	}

}