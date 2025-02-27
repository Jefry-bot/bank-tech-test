package com.bank.finance.report.infrastructure.input.adapter.web.mapper;

import com.bank.finance.report.domain.model.AccountStatement;
import com.bank.finance.report.infrastructure.input.adapter.web.dto.RecordDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructRecordWebMapper {
    List<RecordDTO> toDtos(List<AccountStatement> accountStatement);
}
