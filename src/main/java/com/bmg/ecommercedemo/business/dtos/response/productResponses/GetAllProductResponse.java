package com.bmg.ecommercedemo.business.dtos.response.productResponses;

import com.bmg.ecommercedemo.entity.Order;
import com.bmg.ecommercedemo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
    private long id;
    private String name;
    private int stock;
    private int cost;
    private List<Order> orders;
    private List<User> users;
}
