package com.julianotorquato07.alunoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableDiscoveryClient
public class AlunoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoServiceApplication.class, args);
	}
}
