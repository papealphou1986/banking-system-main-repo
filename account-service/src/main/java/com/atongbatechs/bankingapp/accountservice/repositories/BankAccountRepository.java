package com.atongbatechs.bankingapp.accountservice.repositories;

import com.atongbatechs.bankingapp.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    boolean existsByBankAccountNumber(String bankAccountNumber);

    // Find all bank accounts for a specific customer ID
    List<BankAccount> findByCustomerId(Long customerId);

    // Find a bank account by its unique bank account number
    Optional<BankAccount> findByBankAccountNumber(String bankAccountNumber);

    // Find all accounts with a balance above a certain threshold
    List<BankAccount> findByBalanceGreaterThan(double balance);
}
