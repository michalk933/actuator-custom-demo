package com.example.actuatorcustomdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActiveAccount {

    private String cis;

    private int priority;

}
