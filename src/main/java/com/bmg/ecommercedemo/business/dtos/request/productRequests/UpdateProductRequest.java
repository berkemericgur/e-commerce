package com.bmg.ecommercedemo.business.dtos.request.productRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    @NotNull
    private long id;
    @NotNull
    private String name;
    private int stock;
    private int cost;
}
