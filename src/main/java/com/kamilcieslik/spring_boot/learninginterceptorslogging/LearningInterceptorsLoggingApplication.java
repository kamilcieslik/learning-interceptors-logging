package com.kamilcieslik.spring_boot.learninginterceptorslogging;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class LearningInterceptorsLoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningInterceptorsLoggingApplication.class, args);
	}
}
