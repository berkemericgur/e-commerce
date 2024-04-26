package com.bmg.ecommercedemo.business.dtos.response.userResponses;

import com.bmg.ecommercedemo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {

    private long id;
    private String username;
    private String email;
    private List<Order> orderList;
}
