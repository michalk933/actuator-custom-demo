package com.example.actuatorcustomdemo.controller;

import com.example.actuatorcustomdemo.dto.ActiveAccount;
import com.example.actuatorcustomdemo.service.LoopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class LoopController {

    private final LoopService loopService;

    @GetMapping("/loop")
    public void runLoop() {
        Flux
                .interval(Duration.ofSeconds(1))
                .map(value -> ActiveAccount.builder()
                        .cis("CIS" + value.intValue())
                        .priority(value.intValue())
                        .build())
                .subscribe(loopService::processActiveAccount);
    }


}
