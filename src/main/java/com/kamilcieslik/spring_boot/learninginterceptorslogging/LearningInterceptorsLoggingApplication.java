package com.kamilcieslik.spring_boot.learninginterceptorslogging;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.logging.LoggerInterceptor;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEncryptableProperties
public class LearningInterceptorsLoggingApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(LearningInterceptorsLoggingApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
	}
}
