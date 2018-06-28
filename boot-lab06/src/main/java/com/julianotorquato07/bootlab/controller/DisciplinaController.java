package com.julianotorquato07.bootlab.controller;

import com.julianotorquato07.bootlab.model.Aluno;
import com.julianotorquato07.bootlab.model.Disciplina;
import com.julianotorquato07.bootlab.repository.AlunoRepository;
import com.julianotorquato07.bootlab.repository.DisciplinaRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Secured("MANAGER")
@RestController
@RequestMapping("/api/v1")
public class DisciplinaController {

	private final Logger log = LoggerFactory.getLogger(DisciplinaController.class);

	private final DisciplinaRespository disciplinaRespository;

	public DisciplinaController(DisciplinaRespository disciplinaRespository) {
		this.disciplinaRespository = disciplinaRespository;
	}

	@PostMapping("/disciplinas")
	public ResponseEntity<Disciplina> createAluno(@RequestBody Disciplina aluno) throws Exception {
		log.debug("REST request to save Aluno : {}", aluno);
		if (aluno.getId() != null) {

			HttpHeaders headers = new HttpHeaders();
			headers.add("error", "A new Aluno cannot already have an ID");
			return ResponseEntity.badRequest().headers(headers).body(null);
		}

		log.debug("persistindo o aluno {}", aluno.toString());
		return ResponseEntity.ok().body(aluno);
	}
	
	@PutMapping("/disciplinas")
	public ResponseEntity<Disciplina> updateAluno(@RequestBody Disciplina aluno) throws Exception {
		log.debug("REST request to save Aluno : {}", aluno);
		if (aluno.getId() == null) {
			return createAluno(aluno);
		}

		log.debug("atualizando o aluno {}", aluno.toString());
		return ResponseEntity.ok().body(aluno);
	}

	@GetMapping("/disciplinas")
	public ResponseEntity<List<Disciplina>> getAllAlunos() {
		log.debug("REST request to get Alunos ");
		return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
	}
	
	@DeleteMapping("/disciplinas")
    public ResponseEntity<Void> deleteAnexoAluno(@PathVariable Long id) {
        log.debug("REST request to delete Alunos : {}", id);
        
        Aluno aluno = new Aluno();
        aluno.setId(id);
        return ResponseEntity.ok().build();
    }
	
}
