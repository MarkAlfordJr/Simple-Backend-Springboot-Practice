package com.example.SimpleProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

// 2 MAKE API RESPONSE DTO RECORD (NOT CLASS; RECORD)
// this DTO just collects api information and modify/return it
@JsonInclude(JsonInclude.Include.NON_NULL) // ignores fields if they are empty in json
public record ApiResponse<T>(
        int statusCode,
        String message,
        T data) {}

/*
    DTO - whatever resquest comes in, this DTO returns the response for EVERY
    single api request
 */