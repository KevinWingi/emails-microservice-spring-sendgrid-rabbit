package com.kwingi.emailsmicroservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperConfig {

    @Bean
    ObjectMapper getObjectMapper() {
    	ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}
	
	
}
