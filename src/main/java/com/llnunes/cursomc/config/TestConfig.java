package com.llnunes.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.llnunes.cursomc.resources.DBService;
import com.llnunes.cursomc.services.EmailService;
import com.llnunes.cursomc.services.SmtpEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService service;

	@Bean
	public boolean createTestDatabase() throws ParseException {
		return service.createTestDatabase();
	}
	
//	@Bean
//	public EmailService emailService() {
//		return new MockEmailService();
//	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
