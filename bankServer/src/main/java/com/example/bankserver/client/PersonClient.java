package com.example.bankserver.client;

import com.example.bankserver.controller.remotecontroller.PersonController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PROXY")
public interface PersonClient extends PersonController {
}
