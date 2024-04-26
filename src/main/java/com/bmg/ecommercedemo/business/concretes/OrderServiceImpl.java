package com.bmg.ecommercedemo.business.concretes;

import com.bmg.ecommercedemo.business.abstracts.OrderService;
import com.bmg.ecommercedemo.business.dtos.request.orderRequests.CreateOrderRequest;
import com.bmg.ecommercedemo.business.dtos.request.orderRequests.UpdateOrderRequest;
import com.bmg.ecommercedemo.business.dtos.response.orderResponses.GetAllOrderResponse;
import com.bmg.ecommercedemo.business.mappers.ModelMapperService;
import com.bmg.ecommercedemo.dataaccess.abstracts.OrderDao;
import com.bmg.ecommercedemo.dataaccess.abstracts.UserDao;
import com.bmg.ecommercedemo.entity.Order;
import com.bmg.ecommercedemo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private ModelMapperService modelMapperService;
    private OrderDao orderDao;
    private UserDao userDao;

    @Override
    public List<GetAllOrderResponse> getAll() {

        List<Order> orders = this.orderDao.findAll();

        List<GetAllOrderResponse> getAllOrderResponses = orders.stream()
                .map(order -> this.modelMapperService.forResponse().
                        map(order, GetAllOrderResponse.class))
                .collect(Collectors.toList());

        return getAllOrderResponses;
    }

    @Override
    public List<GetAllOrderResponse> getOrderByUser(User user) {

        List<Order> orders = this.orderDao.findByUser(user);

        List<GetAllOrderResponse> getAllOrderResponses = orders.stream()
                .map(order -> this.modelMapperService.forResponse()
                        .map(order, GetAllOrderResponse.class))
                .collect(Collectors.toList());

        return getAllOrderResponses;
    }

    @Override
    public List<GetAllOrderResponse> getOrderByDate(LocalDateTime localDateTime) {

        List<Order> orders = this.orderDao.findByOrderDate(localDateTime);

        List<GetAllOrderResponse> getAllOrderResponses = orders.stream()
                .map(order -> this.modelMapperService.forResponse()
                        .map(order, GetAllOrderResponse.class))
                .collect(Collectors.toList());

        return getAllOrderResponses;
    }

    @Override
    public Order getOrderById(long id) {

        Order order = this.orderDao.getOrderById(id);
        return order;
    }

    @Override
    public void addOrders(CreateOrderRequest createOrderRequest) {

        Order order = this.modelMapperService.forRequest()
                .map(createOrderRequest, Order.class);

        this.orderDao.save(order);
    }

    @Override
    public void updateOrders(UpdateOrderRequest updateOrderRequest) {

        Order order = this.modelMapperService.forRequest()
                .map(updateOrderRequest, Order.class);

        this.orderDao.save(order);
    }

    @Override
    public void deleteOrders(long id) throws Exception {
        User user = this.userDao.findByOrdersId(id);
        if (user == null) {
            throw new Exception("Order not found with id: " + id);
        }
        user.getOrders().removeIf(order -> order.getId() == id); //her bir order için idler eşleşiyorsa, kaldırır.

        this.userDao.save(user);
    }
}
