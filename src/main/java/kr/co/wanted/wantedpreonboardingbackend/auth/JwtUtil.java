package kr.co.wanted.wantedpreonboardingbackend.auth;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtil {

	private static final long EXPIRATION_TIME = 86400000L;
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public String generateToken(Long memberId, String email) {
		return Jwts.builder()
			.claim("memberId", memberId)
			.claim("email", email)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS512, secretKey)
			.compact();
	}

	public boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser()
				.setSigningKey(secretKey) // 주의: 인코딩된 secretKey를 사용
				.parseClaimsJws(token);

			log.info("[claims = {}]", claims);

			return !claims.getBody().getExpiration().before(new Date());

		} catch (JwtException | IllegalArgumentException exception) {
			log.error("Token validation failed", exception);
			return false;
		}
	}

	public String getMemberEmailFromToken(HttpServletRequest request) {
		final String authHeader = request.getHeader("Authorization");
		final String token = authHeader.substring(7);
		return getEmailFromToken(token);
	}

	private String getEmailFromToken(String token) {
		Claims claims = Jwts.parser()
			.setSigningKey(secretKey)
			.parseClaimsJws(token)
			.getBody();
		return claims.get("email", String.class);
	}
}
