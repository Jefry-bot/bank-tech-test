package com.bank.finance.report.application.service;

import com.bank.finance.report.application.port.input.ReportInputPort;
import com.bank.finance.report.application.port.output.ReportOutputPort;
import com.bank.finance.report.domain.model.AccountStatement;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportInputPort {

    private final ReportOutputPort outputPort;

    @Override
    public List<AccountStatement> getAccountStatement(Long client, LocalDate start, LocalDate end) {
        return outputPort.getAccountStatement(client, start, end);
    }
}
