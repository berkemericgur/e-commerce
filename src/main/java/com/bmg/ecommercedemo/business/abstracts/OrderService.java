package com.bmg.ecommercedemo.business.abstracts;

import com.bmg.ecommercedemo.business.dtos.request.orderRequests.CreateOrderRequest;
import com.bmg.ecommercedemo.business.dtos.request.orderRequests.UpdateOrderRequest;
import com.bmg.ecommercedemo.business.dtos.response.orderResponses.GetAllOrderResponse;
import com.bmg.ecommercedemo.entity.Order;
import com.bmg.ecommercedemo.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    List<GetAllOrderResponse> getAll();
    List<GetAllOrderResponse> getOrderByDate(LocalDateTime localDateTime);
    List<GetAllOrderResponse> getOrderByUser(User user);
    Order getOrderById(long id);
    void addOrders(CreateOrderRequest createOrderRequest);
    void updateOrders(UpdateOrderRequest updateOrderRequest);
    void deleteOrders(long id) throws Exception;

}

