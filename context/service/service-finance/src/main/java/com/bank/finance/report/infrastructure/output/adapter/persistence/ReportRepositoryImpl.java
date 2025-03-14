package com.bank.finance.report.infrastructure.output.adapter.persistence;

import com.bank.finance.client.domain.model.ClientDomain;
import com.bank.finance.report.application.port.output.ReportOutputPort;
import com.bank.finance.report.domain.model.AccountStatement;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryImpl implements ReportOutputPort {

    private final ReportJpaRepository repository;

    @Override
    public List<AccountStatement> getAccountStatement(String clientName, LocalDate start, LocalDate end) {
        return repository.getAccountStatement(clientName, start, end);
    }
}
