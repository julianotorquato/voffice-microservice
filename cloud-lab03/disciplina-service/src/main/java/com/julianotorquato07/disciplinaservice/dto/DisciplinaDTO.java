package com.julianotorquato07.disciplinaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class DisciplinaDTO {

    String nome;
    Integer cargaHoraria;
    Date dataInicio;
    List<String> alunosMatriculados;

    public DisciplinaDTO(String nome, Integer cargaHoraria, Date dataInicio, List<String> alunosMatriculados) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataInicio = dataInicio;
        this.alunosMatriculados = alunosMatriculados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<String> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<String> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
}
