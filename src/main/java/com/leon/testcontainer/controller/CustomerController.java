package com.leon.testcontainer.controller;

import com.leon.testcontainer.Repository.CustomerRepository;
import com.leon.testcontainer.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class CustomerController {

    private final CustomerRepository repo;

    CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/customers")
    List<Customer> getAll() {
        return repo.findAll();
    }
}
