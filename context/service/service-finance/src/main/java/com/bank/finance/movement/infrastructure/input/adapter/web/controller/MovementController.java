package com.bank.finance.movement.infrastructure.input.adapter.web.controller;

import static com.bank.common.utilities.ResponseBuilder.success;

import com.bank.common.adapter.input.web.dto.Response;
import com.bank.finance.movement.application.input.port.MovementInputPort;
import com.bank.finance.movement.infrastructure.input.adapter.web.dto.MovementDTO;
import com.bank.finance.movement.infrastructure.input.adapter.web.mapper.MapStructMovementWebMapper;
import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/movements")
public class MovementController {

  private final MovementInputPort inputPort;
  private final MapStructMovementWebMapper mapper;

  @GetMapping
  public Response<List<MovementDTO>> findAll() {
    return success(mapper.toDto(inputPort.findAll()));
  }

  @GetMapping("/{id}")
  public Response<MovementDTO> findById(@PathVariable Long id) {
    return success(mapper.toDto(inputPort.findById(id)));
  }

  @PostMapping
  public Response<MovementDTO> save(@RequestBody @Valid MovementDTO dto) {
    return success(mapper.toDto(inputPort.save(mapper.toDomain(dto))));
  }

  @DeleteMapping("/{id}")
  public Response<String> delete(@PathVariable Long id) {
    return success(() -> inputPort.deleteById(id));
  }
}
