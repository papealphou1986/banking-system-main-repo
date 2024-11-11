package com.atongbatechs.bankingapp.accountservice.services;

import com.atongbatechs.bankingapp.accountservice.clients.CustomerRestClient;
import com.atongbatechs.bankingapp.accountservice.dtos.BankAccountDto;
import com.atongbatechs.bankingapp.accountservice.dtos.CustomerDto;
import com.atongbatechs.bankingapp.accountservice.entities.BankAccount;
import com.atongbatechs.bankingapp.accountservice.exceptions.ResourceNotFoundException;
import com.atongbatechs.bankingapp.accountservice.mappers.BankAccountMapper;
import com.atongbatechs.bankingapp.accountservice.mappers.CustomerMapper;
import com.atongbatechs.bankingapp.accountservice.models.Customer;
import com.atongbatechs.bankingapp.accountservice.repositories.BankAccountRepository;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;
    private final CustomerRestClient customerRestClient;
    private final CustomerMapper customerMapper;

    public BankAccountService(BankAccountRepository bankAccountRepository,
                              BankAccountMapper bankAccountMapper,
                              CustomerRestClient customerRestClient,
                              CustomerMapper customerMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
        this.customerRestClient = customerRestClient;
        this.customerMapper = customerMapper;
    }

    public ResponseEntity<BankAccountDto> getBankAccountById(String bankAccountNumber) {
        // Fetch the bank account
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Bank Account not found with id: " + bankAccountNumber));
        try {
            ResponseEntity<CustomerDto> response = customerRestClient.getCustomerById(Long.valueOf(bankAccount.getCustomerId()));
            System.out.println("response.getBody().getFirstName() :"+response.getBody().getFirstName());
            Customer customer = customerMapper.toCustomer(response.getBody());
            bankAccount.setCustomer(customer);
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Customer not found with id: " + Long.valueOf(bankAccount.getCustomerId()));
        }
        return ResponseEntity.ok(this.bankAccountMapper.toBankAccountDto(bankAccount));
    }


    public ResponseEntity<List<BankAccountDto>> getAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        if (bankAccounts.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<BankAccountDto> bankAccountDtos = bankAccounts.stream()
                    .map(BankAccountMapper::toBankAccountDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(bankAccountDtos);
        }
    }

    public ResponseEntity<BankAccountDto> saveBankAccount(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = bankAccountMapper.toBankAccount(bankAccountDto);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return ResponseEntity.ok(bankAccountMapper.toBankAccountDto(savedBankAccount));
    }

    public void deleteBankAccount(String bankAccountNumber) {
        if (!bankAccountRepository.existsById(bankAccountNumber)) {
            throw new ResourceNotFoundException("Bank Account not found with id: " + bankAccountNumber);
        }
        bankAccountRepository.deleteById(bankAccountNumber);
    }
}
