package com.mycompany.pos.service;

import com.mycompany.pos.entity.Order;
import com.mycompany.pos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {return orderRepository.findAll();}

    public void delete(Order order) {orderRepository.delete(order);}

    public void save(Order order) {orderRepository.save(order);}
}
