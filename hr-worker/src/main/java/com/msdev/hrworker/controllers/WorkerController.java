package com.msdev.hrworker.controllers;

import com.msdev.hrworker.entities.Worker;
import com.msdev.hrworker.repositories.WorkerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RefreshScope
public class WorkerController {

  private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

//  @Value("${test.config}")
  private String testConfig;

  @Autowired
  private Environment env;

  @Autowired
  private WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = repository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findbyId(@PathVariable Long id) {
    logger.info("PORT = " + env.getProperty("local.server.port"));
    Worker worker = repository.findById(id).orElse(null);
    return ResponseEntity.ok(worker);
  }

  @GetMapping(value = "/configs")
  public ResponseEntity<Void> getConfigs() {
    logger.info("CONFIG = " + testConfig);
    return ResponseEntity.noContent().build();
  }
}
