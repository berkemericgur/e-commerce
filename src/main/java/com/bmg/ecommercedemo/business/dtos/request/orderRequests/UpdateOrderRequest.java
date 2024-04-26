package com.bmg.ecommercedemo.business.dtos.request.orderRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {

    @NotNull
    private long id;
    private BigDecimal amount;
    private LocalDateTime localDateTime;

}
