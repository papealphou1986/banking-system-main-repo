package com.atongbatechs.bankingapp.accountservice.mappers;

import com.atongbatechs.bankingapp.accountservice.dtos.BankAccountDto;
import com.atongbatechs.bankingapp.accountservice.entities.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public static BankAccountDto toBankAccountDto(BankAccount bankAccount) {
        if (bankAccount == null) {
            return null;
        }
        return BankAccountDto.builder()
                .bankAccountNumber(bankAccount.getBankAccountNumber())
                .balance(bankAccount.getBalance())
                .creationAt(bankAccount.getCreationAt())
                .currency(bankAccount.getCurrency())
                .accountType(bankAccount.getAccountType())
                .customerId(bankAccount.getCustomerId())
                .customer(bankAccount.getCustomer()) // Ensure customer is populated correctly
                .build();
    }

    public static BankAccount toBankAccount(BankAccountDto bankAccountDto) {
        if (bankAccountDto == null) {
            return null;
        }
        return BankAccount.builder()
                .bankAccountNumber(bankAccountDto.getBankAccountNumber())
                .balance(bankAccountDto.getBalance())
                .creationAt(bankAccountDto.getCreationAt())
                .currency(bankAccountDto.getCurrency())
                .accountType(bankAccountDto.getAccountType())
                .customerId(bankAccountDto.getCustomerId())
                .customer(bankAccountDto.getCustomer())
                .build();
    }
}
