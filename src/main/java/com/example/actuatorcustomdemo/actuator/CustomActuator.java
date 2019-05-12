package com.example.actuatorcustomdemo.actuator;


import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "custom-endpoint")
public class CustomActuator {

    private final Map<String, String> users = new HashMap<>();

    CustomActuator() {
        this.users.put("Michal", LocalDateTime.now().toString());
        this.users.put("Elzbieta", LocalDateTime.now().toString());
        this.users.put("Tomasz", LocalDateTime.now().toString());
        this.users.put("Aleksander", LocalDateTime.now().toString());
    }


    @ReadOperation
    public Map<String, String> readOperator() {
        return this.users;
    }

    @ReadOperation
    public String getRecord(@Selector String name) {
        return this.users.get(name);
    }


    @WriteOperation
    public void writeOperator(@Selector String name, String localDateTime) {
        this.users.put(name, localDateTime);
    }

    @DeleteOperation
    public void deleteOperatorion(@Selector String name) {
        this.users.remove(name);
    }
}
