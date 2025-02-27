package com.bank.finance.account.infrastructure.input.adapter.web.controller;

import static com.bank.common.utilities.ResponseBuilder.success;

import com.bank.common.adapter.input.web.dto.Response;
import com.bank.finance.account.application.input.port.AccountInputPort;
import com.bank.finance.account.infrastructure.input.adapter.web.dto.AccountDTO;
import com.bank.finance.account.infrastructure.input.adapter.web.mapper.MapStructAccountWebMapper;
import com.bank.finance.account.infrastructure.input.adapter.web.validation.IsValidAccount;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

  private final AccountInputPort inputPort;
  private final MapStructAccountWebMapper mapper;

  @GetMapping
  public Response<List<AccountDTO>> findAll() {
    return success(mapper.toDto(inputPort.findAll()));
  }

  @GetMapping("/{id}")
  public Response<AccountDTO> findById(@PathVariable Long id) {
    return success(mapper.toDto(inputPort.findById(id)));
  }

  @PostMapping
  public Response<AccountDTO> save(@RequestBody @Valid AccountDTO accountDTO) {
    return success(mapper.toDto(inputPort.save(mapper.toDomain(accountDTO))));
  }

  @DeleteMapping("/{id}")
  public Response<String> delete(@PathVariable @IsValidAccount Long id) {
    return success(() -> inputPort.deleteById(id));
  }
}
