package com.bank.finance.report.infrastructure.input.adapter.web.impl;

import static com.bank.common.utilities.ResponseBuilder.success;

import com.bank.common.adapter.input.web.dto.Response;
import com.bank.finance.report.application.port.input.ReportInputPort;
import java.time.LocalDate;
import java.util.List;

import com.bank.finance.report.infrastructure.input.adapter.web.dto.RecordDTO;
import com.bank.finance.report.infrastructure.input.adapter.web.mapper.MapStructRecordWebMapper;
import com.bank.finance.shared.infrastructure.output.adapter.validation.IsValidClient;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportInputPort inputPort;

    private final MapStructRecordWebMapper mapper;

    @GetMapping
    public Response<List<RecordDTO>> getAccountStatement(
            @RequestParam @IsValidClient Long client,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        return success(
            this.mapper.toDtos(inputPort
                .getAccountStatement(client, start, end))
        );
    }
}

