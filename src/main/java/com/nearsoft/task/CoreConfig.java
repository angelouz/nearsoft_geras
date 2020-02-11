package com.nearsoft.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;

import com.nearsoft.task.socialnetwork.PersonRepository;

@Configuration
public class CoreConfig {

	@Bean
	public PersonRepository personRepositoryCustomImpl() {
		return new PersonRepository();
	}
	
	@Bean 
    public HibernateExceptionTranslator hibernateExceptionTranslator(){ 
      return new HibernateExceptionTranslator(); 
    }
}
