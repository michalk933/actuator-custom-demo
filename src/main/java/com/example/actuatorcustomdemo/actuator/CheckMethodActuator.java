package com.example.actuatorcustomdemo.actuator;

import com.example.actuatorcustomdemo.dto.ActiveAccount;
import com.example.actuatorcustomdemo.dto.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "check-method")
public class CheckMethodActuator {

    @Autowired
    Counter counter;

    @ReadOperation
    public Map<Integer, ActiveAccount> readOperation() {
        return counter.getCurrentValue();
    }

}
