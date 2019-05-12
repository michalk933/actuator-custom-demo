package com.example.actuatorcustomdemo.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class Counter {

    private final AtomicInteger value = new AtomicInteger(0);
    private final AtomicReference<ActiveAccount> stringAtomicReference = new AtomicReference<>();

    public void changeVaule(ActiveAccount activeAccount) {
        value.incrementAndGet();
        stringAtomicReference.getAndSet(activeAccount);
    }

    public Map<Integer, ActiveAccount> getCurrentValue() {
        Map<Integer, ActiveAccount> result = new HashMap<>();
        result.put(value.get(), stringAtomicReference.get());
        return result;
    }
}