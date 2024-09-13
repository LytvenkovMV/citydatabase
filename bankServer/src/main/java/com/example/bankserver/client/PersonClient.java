package com.example.bankserver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "PROXY")
public interface PersonClient {

    @RequestMapping("/city/api/persons/{id}")
    ResponseEntity<String> getPerson(@PathVariable("id") Long personId);
}
