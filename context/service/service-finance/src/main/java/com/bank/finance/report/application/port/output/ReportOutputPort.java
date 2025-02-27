package com.bank.finance.report.application.port.output;

import com.bank.finance.report.domain.model.AccountStatement;

import java.time.LocalDate;
import java.util.List;

public interface ReportOutputPort {

    List<AccountStatement> getAccountStatement(Long client, LocalDate start, LocalDate end);
}
