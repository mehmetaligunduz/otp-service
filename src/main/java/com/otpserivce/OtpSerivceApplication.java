package com.otpserivce;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@RequiredArgsConstructor
@SpringBootApplication
public class OtpSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpSerivceApplication.class, args);
	}
}
