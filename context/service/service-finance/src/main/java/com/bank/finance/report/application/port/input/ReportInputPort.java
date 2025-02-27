package com.bank.finance.report.application.port.input;

import com.bank.finance.report.domain.model.AccountStatement;

import java.time.LocalDate;
import java.util.List;

public interface ReportInputPort {

    List<AccountStatement> getAccountStatement(Long client, LocalDate start, LocalDate end);
}
