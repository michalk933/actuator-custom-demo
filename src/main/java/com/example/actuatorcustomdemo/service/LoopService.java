package com.example.actuatorcustomdemo.service;

import com.example.actuatorcustomdemo.dto.ActiveAccount;
import com.example.actuatorcustomdemo.dto.Counter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoopService {

    @Autowired
    Counter counter;

    public void processActiveAccount(ActiveAccount activeAccount) {
        log.info("Start method: " + activeAccount);
        counter.changeVaule(activeAccount);
        log.info("Stop method: " + activeAccount);
    }

}
