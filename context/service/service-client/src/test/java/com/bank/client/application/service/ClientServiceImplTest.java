package com.bank.client.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.bank.client.application.output.port.ClientOutputPort;
import com.bank.client.domain.model.ClientDomain;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Test suite for ClientServiceImpl.")
class ClientServiceImplTest {

  @Mock private ClientOutputPort outputPort;
  @InjectMocks private ClientServiceImpl service;

  @Test
  @DisplayName("should return data successfully.")
  void shouldReturnDataSuccessfullyTest() {
    ClientDomain domain = mock(ClientDomain.class);

    List<ClientDomain> domains = List.of(domain);

    when(outputPort.findAll()).thenReturn(domains);

    assertNotNull(service.findAll());
    verify(outputPort, times(1)).findAll();
  }
}
