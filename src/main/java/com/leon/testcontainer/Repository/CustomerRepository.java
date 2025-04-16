package com.leon.testcontainer.Repository;

import com.leon.testcontainer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
