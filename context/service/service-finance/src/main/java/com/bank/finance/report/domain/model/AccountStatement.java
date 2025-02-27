package com.bank.finance.report.domain.model;

import java.time.LocalDate;

public interface AccountStatement {
    LocalDate getDate();
    String getClient();
    Double getAccountNumber();
    String getTypeAccount();
    Double getOpeningBalance();
    boolean getStatus();
    String getMovement();
    Double getAvailableBalance();
}
