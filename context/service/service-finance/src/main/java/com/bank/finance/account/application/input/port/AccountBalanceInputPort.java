package com.bank.finance.account.application.input.port;

public interface AccountBalanceInputPort {
    void updateBalance(Long accountNumber, Double newBalance);
} 