package com.julianotorquato07.alunoservice.repository;

import com.julianotorquato07.alunoservice.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/alunos", path = "alunos")
public interface AlunoRepository extends JpaRepository<Aluno, Long> { }
