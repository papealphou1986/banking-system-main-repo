package com.atongbatechs.bankingapp.accountservice.clients;


import com.atongbatechs.bankingapp.accountservice.dtos.CustomerDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{customerId}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId);

    @GetMapping("/api/customers/allCustomers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    ResponseEntity<List<CustomerDto>> getAllCustomers();

    default ResponseEntity<CustomerDto> getDefaultCustomer(Long customerId, Exception exception) {
        return ResponseEntity.ok(
                CustomerDto.builder()
                        .customerId(customerId)
                        .firstName("Not valid")
                        .lastName("Not valid")
                        .email("Not valid")
                        .build()
        );
    }


    default ResponseEntity<List<CustomerDto>> getAllCustomers(Exception exception) {
        return ResponseEntity.ok(List.of());
    }
}