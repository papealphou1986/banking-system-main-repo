package com.atongbatechs.bankingapp.customerservice.services;

import com.atongbatechs.bankingapp.customerservice.dtos.CustomerDto;
import com.atongbatechs.bankingapp.customerservice.entities.Customer;
import com.atongbatechs.bankingapp.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final com.atongbatechs.bankingapp.customerservice.mapper.CustomerMapper customerMapper;

    // Create a new customer
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(customerMapper.toCustomerDto(savedCustomer));
    }

    // Get a customer by ID
    public ResponseEntity<CustomerDto> getCustomerById(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return ResponseEntity.ok(this.customerMapper.toCustomerDto(customer.get()));
        }
        return ResponseEntity.notFound().build();
    }

    // Get all customers
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<CustomerDto> customerDtos = customers.stream()
                    .map(customerMapper::toCustomerDto)  // Convertit chaque Customer en CustomerDtoResponse
                    .collect(Collectors.toList());
            return ResponseEntity.ok(customerDtos);
        }
    }

    // Update a customer
    public ResponseEntity<CustomerDto> updateCustomer(Long customerId, CustomerDto customerDto) {
        Optional<CustomerDto> optionalCustomerDto = customerRepository.findById(customerId).map(existingCustomer -> {
            existingCustomer.setFirstName(customerDto.getFirstName());
            existingCustomer.setLastName(customerDto.getLastName());
            existingCustomer.setEmail(customerDto.getEmail());
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return customerMapper.toCustomerDto(updatedCustomer);
        });
        if (optionalCustomerDto.isPresent()) {
            return ResponseEntity.ok(optionalCustomerDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a customer by ID
    public boolean deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }
}
