package kr.co.wanted.wantedpreonboardingbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.wanted.wantedpreonboardingbackend.interceptor.LoginInterceptor;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
			.addPathPatterns("/article/**");
	}
}

