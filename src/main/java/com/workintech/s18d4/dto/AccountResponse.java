package com.workintech.s18d4.dto;

public record AccountResponse(
        String accountName,
        Double moneyAmount,
        String customerName
) {}
