package com.atongbatechs.bankingapp.accountservice.entities;

import com.atongbatechs.bankingapp.accountservice.enums.AccountType;
import com.atongbatechs.bankingapp.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount {

    @Id
    private String bankAccountNumber;

    @Column(nullable = false)
    private double balance;

    private LocalDateTime creationAt;

    @Column(nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long customerId;

    @Transient
    private Customer customer;
}
