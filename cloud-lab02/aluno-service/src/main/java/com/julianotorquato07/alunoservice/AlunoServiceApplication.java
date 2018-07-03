package com.julianotorquato07.alunoservice;

import com.julianotorquato07.alunoservice.domain.Aluno;
import com.julianotorquato07.alunoservice.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableDiscoveryClient
public class AlunoServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AlunoServiceApplication.class, args);
	}

	@Autowired private AlunoRepository alunoRepository;

	@Value("${var}")
	private Integer var;

	@Override
	public void run(String... args) throws Exception {
		alunoRepository.save(new Aluno("juju", 1111, "juju@email.com"));
		alunoRepository.save(new Aluno("estrela", 222, "estrela@email.com"));


		System.out.println("#####################");
		System.out.println(var);
	}
}
