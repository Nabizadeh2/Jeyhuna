package com.example.springatldma.model.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorDto {
    int errorCode;
    String massage;
    LocalDateTime localDateTime;

}
