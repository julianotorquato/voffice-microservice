package com.julianotorquato07.bootlab01.config;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class ConfigProperty {

	private Logger logger = LogManager.getLogger(ConfigProperty.class);

	@Value("${app.config.value.boolean}")
	private String valueBoolean;
	
	@Value("${app.config.value.number}")
	private Long valueNumber;
	
	@Value("${app.config.value.random}")
	private Long randomValue;
	
	@Autowired
	private Environment env;
	
	@PostConstruct
	public void print() {
		logger.info("app.config.value.boolean = {}", valueBoolean);
		logger.info("app.config.value.number = {}", valueNumber);
		logger.info("app.config.value.random = {}", randomValue);
		logger.info("app.config.property.env = {}", env.getProperty("app.config.value.env"));
	}
	
}
