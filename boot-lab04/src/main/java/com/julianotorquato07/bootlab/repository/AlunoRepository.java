package com.julianotorquato07.bootlab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianotorquato07.bootlab.model.Aluno;


@SuppressWarnings("unused")
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	List<Aluno> findByNome(String nome);
	
}
