package com.example.bankserver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("citydatabase")
public interface PersonClient {

    @RequestMapping("/persons")
    ResponseEntity<String> getPerson(Long personId);
}
