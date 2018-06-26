package com.julianotorquato07.bootlab.repository;

import com.julianotorquato07.bootlab.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRespository extends JpaRepository<Disciplina, Long> {

    //TODO: JULIANO - TERMINAR
    public List<Disciplina> listNext();
}
