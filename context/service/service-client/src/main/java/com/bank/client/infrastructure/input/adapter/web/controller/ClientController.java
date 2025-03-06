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
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

  private final ClientInputPort inputPort;
  private final MapStructClientWebMapper mapper;

  @GetMapping
  public Mono<Response<List<ClientDTO>>> findAll() {
    return inputPort.findAll().collectList().map(list -> success(mapper.toDto(list)));
  }

  @GetMapping("/{id}")
  public Mono<Response<ClientDTO>> findById(@PathVariable String id) {
    return inputPort.findById(id).map(client -> success(mapper.toDto(client)));
  }

  @PostMapping
  public Mono<Response<ClientDTO>> save(@RequestBody @Valid ClientDTO clientDTO) {
    return inputPort
        .save(mapper.toDomain(clientDTO))
        .map(clientSave -> success(mapper.toDto(clientSave)));
  }

  @DeleteMapping("/{id}")
  public Mono<Response<String>> deleteById(@PathVariable @IsValidClient String id) {
    return inputPort.deleteById(id).thenReturn(success(() -> {}));
  }
}
