package com.workintech.s18d4.dto;

public record CustomerResponse(
        String firstName,
        String lastName,
        String email,
        Double salary
) {}
