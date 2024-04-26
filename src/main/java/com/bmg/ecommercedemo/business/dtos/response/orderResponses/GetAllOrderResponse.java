package com.bmg.ecommercedemo.business.dtos.response.orderResponses;

import com.bmg.ecommercedemo.entity.Product;
import com.bmg.ecommercedemo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderResponse {

    private long id;
    private BigDecimal amount;
    private LocalDateTime localDateTime;
    private List<Product> products;
    private List<User> users;

}
