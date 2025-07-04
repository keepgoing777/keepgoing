package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.MemberDAO;
import vo.Member;

class MemberDAOTest {

	private MemberDAO dao;

	// BeforeEach : 각 테스트 메서드가 실행되기 전에 무조건 실행
	// 보통 DAO나 Service 객체 초기화하는 역할
	@BeforeEach
	void setUp() {
		dao = MemberDAO.getInstance();
	}

	// AfterEach : 각 테스트 메서드가 실행된 후에 무조건 실행
	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM MEMBER").executeUpdate();
	}

	@Test
	void testRegister() throws SQLException {
		Member member = new Member("test01", "테스트01", "pass01", 1);
		dao.register(member);
	}
	@Test 
	void testLogin() throws SQLException {
		Member member = new Member("test02", "테스트01", "pass01", 1);
		dao.register(member);
		
		member = dao.login("test02", "pass01");  // null인지 아닌지 모름 
		//assertNotnull() : 해당값이 null이 인지 아닌지 확인 메서드 
		assertNotnull(member);// 해당 값이 null이 아니라면 테스트 통과!
	}

	private void assertNotnull(Member member) {
	}

	@Test 
	void testDelete() throws SQLException {
		Member member = new Member("test03", "테스트01", "pass01", 1);
		dao.register(member);
		
		dao.delete("test03");

		//탈퇴했다며 가입된 test01는 없다는 것 = null 값
		
		member = dao.login("test03", "pass01");
		assertNull(member);
	}

}// 최종종료
