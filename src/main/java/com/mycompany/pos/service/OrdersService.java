package com.mycompany.pos.service;

import com.mycompany.pos.entity.Orders;
import com.mycompany.pos.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findAll() {return ordersRepository.findAll();}

    public void delete(Orders orders) {
        ordersRepository.delete(orders);}

    public Orders save(Orders orders) {
        return ordersRepository.save(orders);}
}
