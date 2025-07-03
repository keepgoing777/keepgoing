package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBConnectionTest1 {

	public static void main(String[] args) {
		
		// JDBC (Java Database Connectivity) 
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩...!");
			
			// 2. 데이터베이스 연결
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "qwer1234");
			System.out.println("2. 데이터베이스 연결...!");
			
			// 3. PreparedStatement 객체 생성 -> 쿼리 : SELECT문 사용해서 film 
			ps = connect.prepareStatement("SELECT * FROM film");
			
			// 4. 쿼리 실행
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int filmId = rs.getInt("film_id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				LocalDate update = rs.getDate("last_update").toLocalDate();
				double cost = rs.getDouble("replacement_cost");
				System.out.println(filmId + " / " + title + " / " + desc + " / " + update + " / " + cost);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 자원 반납 
				rs.close();
				ps.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
