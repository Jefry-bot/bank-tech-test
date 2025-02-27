package com.bank.client.infrastructure.input.adapter.web.controller;

import com.bank.client.application.input.port.ClientInputPort;
import com.bank.client.domain.model.ClientDomain;
import com.bank.client.domain.model.Gender;
import com.bank.client.infrastructure.input.adapter.web.dto.ClientDTO;
import com.bank.client.infrastructure.input.adapter.web.mapper.MapStructClientWebMapper;
import com.bank.common.utilities.JsonUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
class ClientControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ClientController controller;

    @Mock
    private ClientInputPort inputPort;

    @Mock
    private MapStructClientWebMapper mapper;

    private LocalDateTime now;

    @BeforeEach
    void init() {
        Validator mockValidator = mock(Validator.class);
        now = LocalDateTime.now();

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setValidator(mockValidator)
                .build();
    }

    @Test
    void findAll() throws Exception {
        ClientDomain client = createClientDomain(1L);
        List<ClientDomain> clients = List.of(client);

        ClientDTO clientDTO = createClientDTO(1L);
        List<ClientDTO> clientDTOs = List.of(clientDTO);

        when(inputPort.findAll()).thenReturn(clients);
        when(mapper.toDto(clients)).thenReturn(clientDTOs);

        mockMvc.perform(get("/client"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data[0].id").value(1))
                .andExpect(jsonPath("$.data[0].name").value("John Doe"))
                .andExpect(jsonPath("$.data[0].email").value("john@example.com"))
                .andExpect(jsonPath("$.data[0].identification").value("123456789"))
                .andExpect(jsonPath("$.data[0].age").value(30))
                .andExpect(jsonPath("$.data[0].gender").value("MALE"))
                .andExpect(jsonPath("$.data[0].status").value(true))
                .andExpect(jsonPath("$.data[0].password").value("secret123"));

        verify(inputPort, times(1)).findAll();
        verifyNoMoreInteractions(inputPort);
    }

    @Test
    void findById() throws Exception {
        Long id = 1L;
        ClientDomain client = createClientDomain(id);
        ClientDTO clientDTO = createClientDTO(id);

        when(inputPort.findById(id)).thenReturn(client);
        when(mapper.toDto(client)).thenReturn(clientDTO);

        mockMvc.perform(get("/client/{id}", id))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.name").value("John Doe"))
                .andExpect(jsonPath("$.data.email").value("john@example.com"))
                .andExpect(jsonPath("$.data.identification").value("123456789"))
                .andExpect(jsonPath("$.data.address").value("123 Main St"))
                .andExpect(jsonPath("$.data.phone").value("555-1234"))
                .andExpect(jsonPath("$.data.password").value("secret123"));

        verify(inputPort, times(1)).findById(id);
        verifyNoMoreInteractions(inputPort);
    }

    @Test
    void save() throws Exception {
        ClientDTO clientDTO = createClientDTO(null);
        ClientDomain clientDomain = createClientDomain(null);
        ClientDomain savedClientDomain = createClientDomain(1L);
        ClientDTO savedClientDTO = createClientDTO(1L);

        when(mapper.toDomain(clientDTO)).thenReturn(clientDomain);
        when(inputPort.save(clientDomain)).thenReturn(savedClientDomain);
        when(mapper.toDto(savedClientDomain)).thenReturn(savedClientDTO);

        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requireNonNull(JsonUtility.toStringFormat(clientDTO))))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.name").value("John Doe"))
                .andExpect(jsonPath("$.data.email").value("john@example.com"))
                .andExpect(jsonPath("$.data.password").value("secret123"));

        verify(mapper, times(1)).toDomain(clientDTO);
        verify(inputPort, times(1)).save(clientDomain);
        verify(mapper, times(1)).toDto(savedClientDomain);
        verifyNoMoreInteractions(inputPort);
    }

    @Test
    void deleteById() throws Exception {
        Long id = 1L;

        doNothing().when(inputPort).deleteById(id);

        mockMvc.perform(delete("/client/{id}", id))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").value("OK"));

        verify(inputPort, times(1)).deleteById(id);
        verifyNoMoreInteractions(inputPort);
    }

    private ClientDomain createClientDomain(Long id) {
        return ClientDomain.init()
                .id(id)
                .name("John Doe")
                .identification("123456789")
                .age(30)
                .phone("555-1234")
                .gender(Gender.MALE)
                .address("123 Main St")
                .password("secret123")
                .createdAt(now)
                .updatedAt(now)
                .status(true)
                .build();
    }

    private ClientDTO createClientDTO(Long id) {
        return ClientDTO.init()
                .id(id)
                .name("John Doe")
                .identification("123456789")
                .age(30)
                .phone("555-1234")
                .gender(Gender.MALE)
                .address("123 Main St")
                .password("secret123")
                .createdAt(now)
                .updatedAt(now)
                .status(true)
                .build();
    }
}