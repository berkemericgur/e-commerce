package com.bmg.ecommercedemo.controller;

import com.bmg.ecommercedemo.business.abstracts.OrderService;
import com.bmg.ecommercedemo.business.dtos.request.orderRequests.CreateOrderRequest;
import com.bmg.ecommercedemo.business.dtos.request.orderRequests.UpdateOrderRequest;
import com.bmg.ecommercedemo.business.dtos.response.orderResponses.GetAllOrderResponse;
import com.bmg.ecommercedemo.entity.Order;
import com.bmg.ecommercedemo.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping(value = "/getAll")
    @Operation(summary = "Get All")
    public ResponseEntity<List<GetAllOrderResponse>> getAll(){

        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping(value = "/getByUser/{userId}")
    public ResponseEntity<List<GetAllOrderResponse>> getByUser(@PathVariable  User userId){

        return ResponseEntity.ok(this.orderService.getOrderByUser(userId));
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id){

        return ResponseEntity.ok(this.orderService.getOrderById(id));
    }

    @GetMapping(value = "/getByDate")
    public ResponseEntity<List<GetAllOrderResponse>> getByDate(
            @RequestParam("orderDate")LocalDateTime localDateTime){

        return ResponseEntity.ok(this.orderService.getOrderByDate(localDateTime));
    }

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Add")
    public void add(@RequestBody CreateOrderRequest request){

        this.orderService.addOrders(request);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @Operation(summary = "Update")
    public void update(@RequestBody UpdateOrderRequest request){

        this.orderService.updateOrders(request);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @Operation(summary = "Delete")
    public void delete(@PathVariable long id){

        try {
            this.orderService.deleteOrders(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
