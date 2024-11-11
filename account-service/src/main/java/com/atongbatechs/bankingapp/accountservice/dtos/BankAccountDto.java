package com.atongbatechs.bankingapp.accountservice.dtos;

import com.atongbatechs.bankingapp.accountservice.enums.AccountType;
import com.atongbatechs.bankingapp.accountservice.models.Customer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {

    @NotNull(message = "Bank Account Number cannot be null")
    @Size(min = 10, max = 20, message = "Bank Account Number must be between 10 and 20 characters")
    private String bankAccountNumber;

    @Positive(message = "Balance must be a positive value")
    private double balance;

    private LocalDateTime creationAt;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long customerId;

    @Transient
    private Customer customer;
}
