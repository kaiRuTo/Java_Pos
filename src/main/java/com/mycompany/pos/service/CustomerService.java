package com.mycompany.pos.service;

import com.mycompany.pos.entity.Customer;
import com.mycompany.pos.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {return customerRepository.findAll();}

    public void delete(Customer customer) {customerRepository.delete(customer);}

    public Customer save(Customer customer) {return customerRepository.save(customer);}
}
