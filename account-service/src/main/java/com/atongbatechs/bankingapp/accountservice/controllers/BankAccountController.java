package com.atongbatechs.bankingapp.accountservice.controllers;

import com.atongbatechs.bankingapp.accountservice.dtos.BankAccountDto;
import com.atongbatechs.bankingapp.accountservice.services.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bankAccounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/{bankAccountNumber}")
    public ResponseEntity<BankAccountDto> getBankAccountById(@PathVariable String bankAccountNumber) {
        return bankAccountService.getBankAccountById(bankAccountNumber);
    }

    @GetMapping("/allAccounts")
    public ResponseEntity<List<BankAccountDto>> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @PostMapping
    public ResponseEntity<BankAccountDto> createBankAccount(@Valid @RequestBody BankAccountDto bankAccountDto) {
        return bankAccountService.saveBankAccount(bankAccountDto);
    }

    @PutMapping("/{bankAccountNumber}")
    public ResponseEntity<BankAccountDto> updateBankAccount(@PathVariable String bankAccountNumber, @Valid @RequestBody BankAccountDto bankAccountDto) {
        bankAccountDto.setBankAccountNumber(bankAccountNumber);  // Set the ID to update the existing bank account
        return bankAccountService.saveBankAccount(bankAccountDto);
    }

    @DeleteMapping("/{bankAccountNumber}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable String bankAccountNumber) {
        bankAccountService.deleteBankAccount(bankAccountNumber);
        return ResponseEntity.noContent().build();
    }
}
