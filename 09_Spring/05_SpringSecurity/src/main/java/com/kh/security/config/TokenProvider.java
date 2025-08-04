package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.model.vo.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Service
public class TokenProvider {
	private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    
/*jwt decode (홈페이지 참조)
 * {
  "alg": "HS256",
  "typ": "JWT"
  }
 
  jwt  필요값 
  {
  "sub": "1234567890",
  "name": "John Doe",
  "admin": true,
  "iat": 1516239022
}
*/
	public String create(User user) {
		return Jwts.builder()
				.signWith(secretKey, SignatureAlgorithm.HS512) //secretKey 알고리즘 사용 명시적 지정
				.setClaims(Map.of(
						"id", user.getId(),
						"name", user.getName(),
						"role", user.getRole()
				))
				.setIssuedAt(new Date()) //토큰 생성일
				.setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS))) //토큰 유효일
				.compact();
    }
	
	// token에서 user 정보 building 해서 유효화
	public User validate(String token) {
		Claims claims = Jwts
				.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token)
				.getBody();
		return User.builder()
				.id((String)claims.get("id"))
				.name((String)claims.get("name"))
				.role((String)claims.get("role"))
				.build();
	}
	
}
