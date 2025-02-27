package com.bank.finance.report.infrastructure.input.adapter.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "init")
public class RecordDTO {
    private LocalDate date;
    private String client;
    private Double accountNumber;
    private String typeAccount;
    private Double openingBalance;
    private boolean status;
    private String movement;
    private Double availableBalance;
}
