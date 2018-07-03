package com.julianotorquato07.disciplinaservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.julianotorquato07.disciplinaservice.dto.DisciplinaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
public class DisciplinaController {

    private final Logger log = LoggerFactory.getLogger(DisciplinaController.class);


    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    ObjectMapper objectMapper;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/disciplinas")
    public ResponseEntity<List<DisciplinaDTO>> getAllDisciplinas() {
        log.debug("REST request to get Disciplinas ");

        DisciplinaDTO disciplinaDTO = new DisciplinaDTO("Workshop Microservices", 40, new Date(2018, 07, 02), getAlunos());

        return new ResponseEntity(disciplinaDTO, HttpStatus.OK);
    }

    private List<String> getAlunos() {

        List<ServiceInstance> instances =
                this.discoveryClient.getInstances("aluno-service");
        ServiceInstance firstOne = instances.get(0);

        String url = firstOne.getUri().toString().concat("/alunos");

        ResponseEntity<JsonNode> alunos = restTemplate.getForEntity(url, JsonNode.class);

        return alunos.getBody().findValuesAsText("nome");
    }

}
