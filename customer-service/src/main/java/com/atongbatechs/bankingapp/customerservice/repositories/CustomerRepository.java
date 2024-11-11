package com.atongbatechs.bankingapp.customerservice.repositories;

import com.atongbatechs.bankingapp.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
