package kr.co.wanted.wantedpreonboardingbackend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import kr.co.wanted.wantedpreonboardingbackend.auth.JwtUtil;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

	private final JwtUtil jwtUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		String method = request.getMethod();

		if (HttpMethod.PUT.toString().equals(method) || HttpMethod.DELETE.toString().equals(method)) {
			final String authHeader = request.getHeader("Authorization");

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or Invalid Authorization header");
				return false;
			}

			final String token = authHeader.substring(7);

			try {
				if (!jwtUtil.validateToken(token)) {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or Expired token");
					return false;
				}
			} catch (SignatureException | ExpiredJwtException e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or Expired token");
				return false;
			}
			return true;
		}
		return true;
	}
}
