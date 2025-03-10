package com.bank.finance.report.application.port.output;

import com.bank.finance.client.domain.model.ClientDomain;
import com.bank.finance.report.domain.model.AccountStatement;
import java.time.LocalDate;
import java.util.List;

public interface ReportOutputPort {

    List<AccountStatement> getAccountStatement(String clientName, LocalDate start, LocalDate end);
}
