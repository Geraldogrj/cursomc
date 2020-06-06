package com.nelioalves.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelioalves.cursomc.services.DBService;
import com.nelioalves.cursomc.services.EmailService;
import com.nelioalves.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	public DBService dbService;
	
	//Pega o valor da chave para decidir se cria ou não o banco de dados
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy; //estratégia de geração do banco de dados
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
