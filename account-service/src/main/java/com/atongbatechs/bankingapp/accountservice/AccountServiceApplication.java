package com.atongbatechs.bankingapp.accountservice;

import com.atongbatechs.bankingapp.accountservice.entities.BankAccount;
import com.atongbatechs.bankingapp.accountservice.enums.AccountType;
import com.atongbatechs.bankingapp.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
/*
    @Bean
    CommandLineRunner init(BankAccountRepository bankAccountRepository) {
        return args -> {
            List<BankAccount> bankAccounts = List.of(
                    BankAccount.builder()
                            .bankAccountNumber("AM0002024")
                            .accountType(AccountType.CURRENT_ACCOUNT)
                            .balance(500000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(1L)
                            .build(),
                    BankAccount.builder()
                            .bankAccountNumber("SA0002024")
                            .accountType(AccountType.SAVINGS_ACCOUNT)
                            .balance(250000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(2L)
                            .build(),
                    BankAccount.builder()
                            .bankAccountNumber("NM0002024")
                            .accountType(AccountType.CURRENT_ACCOUNT)
                            .balance(125000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(3L)
                            .build(),
                    BankAccount.builder()
                            .bankAccountNumber("AS0002024")
                            .accountType(AccountType.CURRENT_ACCOUNT)
                            .balance(5000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(4L)
                            .build(),
                    BankAccount.builder()
                            .bankAccountNumber("AF0002024")
                            .accountType(AccountType.SAVINGS_ACCOUNT)
                            .balance(250000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(5L)
                            .build(),
                    BankAccount.builder()
                            .bankAccountNumber("SG0002024")
                            .accountType(AccountType.SAVINGS_ACCOUNT)
                            .balance(200000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(6L)
                            .build(),
                    BankAccount.builder()
                            .bankAccountNumber("BM002024")
                            .accountType(AccountType.SAVINGS_ACCOUNT)
                            .balance(450000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(7L)
                            .build(),
                    BankAccount.builder()
                            .bankAccountNumber("GB0002024")
                            .accountType(AccountType.SAVINGS_ACCOUNT)
                            .balance(450000D)
                            .currency("XOF")
                            .creationAt(LocalDateTime.now())
                            .customerId(8L)
                            .build()
            );
            bankAccountRepository.saveAllAndFlush(bankAccounts);
        };
    }*/
}
