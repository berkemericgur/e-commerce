package com.bmg.ecommercedemo.business.dtos.request.orderRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {

    private long userId;
    private BigDecimal amount;
    private LocalDateTime localDateTime;
}
