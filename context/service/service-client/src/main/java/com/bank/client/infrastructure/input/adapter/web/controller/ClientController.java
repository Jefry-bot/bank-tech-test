package com.bank.client.infrastructure.input.adapter.web.controller;

import static com.bank.common.utilities.ResponseBuilder.success;

import com.bank.client.application.input.port.ClientInputPort;
import com.bank.client.infrastructure.input.adapter.web.dto.ClientDTO;
import com.bank.client.infrastructure.input.adapter.web.mapper.MapStructClientWebMapper;
import com.bank.client.infrastructure.input.adapter.web.validation.IsValidClient;
import com.bank.common.adapter.input.web.dto.Response;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

  private final ClientInputPort inputPort;
  private final MapStructClientWebMapper mapper;

  @GetMapping
  public Response<List<ClientDTO>> findAll() {
    return success(mapper.toDto(inputPort.findAll()));
  }

  @GetMapping("/{id}")
  public Response<ClientDTO> findById(@PathVariable Long id) {
    return success(mapper.toDto(inputPort.findById(id)));
  }

  @PostMapping
  public Response<ClientDTO> save(@RequestBody @Valid ClientDTO clientDTO) {
    return success(mapper.toDto(inputPort.save(mapper.toDomain(clientDTO))));
  }

  @DeleteMapping("/{id}")
  public Response<String> deleteById(@PathVariable @IsValidClient Long id) {
    return success(() -> inputPort.deleteById(id));
  }
}
