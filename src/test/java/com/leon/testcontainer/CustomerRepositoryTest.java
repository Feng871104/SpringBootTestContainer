package com.leon.testcontainer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leon.testcontainer.Repository.CustomerRepository;
import com.leon.testcontainer.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Import(TestcontainersConfiguration.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 設定測試順序
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void addCustomer() {
        Customer customer = new Customer();
        customer.setName("Leon");
        customer.setEmail("leon@example.com");
        customerRepository.save(customer);
        assertThat(customer.getId()).isNotNull();
    }

    @Test
    @Order(2)
    void findAllCustomers() throws JsonProcessingException {
        List<Customer> customers = customerRepository.findAll();
        log.info("findData: {}", objectMapper.writeValueAsString(customers));
        assertThat(customers).hasSize(1);
        assertThat(customers.getFirst().getName()).isEqualTo("Leon");
        assertThat(customers.getFirst().getEmail()).isEqualTo("leon@example.com");
    }

}
