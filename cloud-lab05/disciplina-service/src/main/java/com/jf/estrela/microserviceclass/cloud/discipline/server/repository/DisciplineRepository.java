package com.jf.estrela.microserviceclass.cloud.discipline.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.jf.estrela.microserviceclass.cloud.discipline.server.entity.Discipline;


@Repository
@RepositoryRestResource(path="discipline")
public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}
