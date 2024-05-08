package br.com.mv.cloud.aws.controller;

import org.springframework.http.ResponseEntity;

public interface TestController {

    ResponseEntity<?> getTest(String name);
}
