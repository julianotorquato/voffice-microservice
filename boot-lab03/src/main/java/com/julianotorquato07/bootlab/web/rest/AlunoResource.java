package com.julianotorquato07.bootlab.web.rest;


import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianotorquato07.bootlab.model.Aluno;

@RestController
@RequestMapping("/api/v1")
public class AlunoResource {

	private final Logger log = LoggerFactory.getLogger(AlunoResource.class);

	@PostMapping("/alunos")
	public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) throws Exception {
		log.debug("REST request to save Aluno : {}", aluno);
		if (aluno.getId() != null) {

			HttpHeaders headers = new HttpHeaders();
			headers.add("error", "A new Aluno cannot already have an ID");
			return ResponseEntity.badRequest().headers(headers).body(null);
		}

		log.debug("persistindo o aluno {}", aluno.toString());
		return ResponseEntity.ok().body(aluno);
	}
	
	@PutMapping("/alunos")
	public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno aluno) throws Exception {
		log.debug("REST request to save Aluno : {}", aluno);
		if (aluno.getId() == null) {
			return createAluno(aluno);
		}

		log.debug("atualizando o aluno {}", aluno.toString());
		return ResponseEntity.ok().body(aluno);
	}

	@GetMapping("/alunos")
	public ResponseEntity<List<Aluno>> getAllAnexoArquivos() {
		log.debug("REST request to get Alunos ");
		return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
	}
	
	@DeleteMapping("/alunos")
    public ResponseEntity<Void> deleteAnexoArquivo(@PathVariable Long id) {
        log.debug("REST request to delete Alunos : {}", id);
        
        Aluno aluno = new Aluno();
        aluno.setId(id);
        return ResponseEntity.ok().build();
    }

}
