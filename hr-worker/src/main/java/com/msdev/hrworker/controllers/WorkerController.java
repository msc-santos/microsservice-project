package com.msdev.hrworker.controllers;

import com.msdev.hrworker.entities.Worker;
import com.msdev.hrworker.repositories.WorkerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

  private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

  @Autowired
  private Environment env;

  @Autowired
  private WorkerRepository respository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = respository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findbyId(@PathVariable Long id) {

      /*
      Código caso queira testar o circuit breaker com a api de hr-worker ativada

      try {
          Thread.sleep(3000L);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
      */

      logger.info("PORT = " + env.getProperty("local.server.port"));

    Worker worker = respository.findById(id).get();
    return ResponseEntity.ok(worker);
  }
}
