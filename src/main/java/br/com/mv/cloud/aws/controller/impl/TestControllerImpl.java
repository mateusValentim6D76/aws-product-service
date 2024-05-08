package br.com.mv.cloud.aws.controller.impl;

import br.com.mv.cloud.aws.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestControllerImpl implements TestController{

    private static final Logger LOG = LoggerFactory.getLogger(TestControllerImpl.class);
    @GetMapping("/dog/{name}")
    public ResponseEntity<?> getTest(@PathVariable String name){
        LOG.info("Test Controller - Name: {} ", name);
        return ResponseEntity.ok("Name: " + name);
    }
}
