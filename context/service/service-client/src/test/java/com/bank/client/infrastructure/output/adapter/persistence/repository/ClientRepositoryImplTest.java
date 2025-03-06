package com.bank.client.infrastructure.output.adapter.persistence.repository;

import com.bank.client.domain.model.ClientDomain;
import com.bank.client.infrastructure.output.adapter.persistence.entity.ClientDocument;
import com.bank.client.infrastructure.output.adapter.persistence.mapper.MapStructClientPersistenceMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Test suite for ClientRepositoryImpl.")
class ClientRepositoryImplTest {

  @Mock private ClientReactiveRepository repository;
  @Mock private MapStructClientPersistenceMapper mapper;
  @InjectMocks private ClientRepositoryImpl repositoryImpl;

  @Test
  @DisplayName("should return data successfully.")
  void shouldReturnDataSuccessfullyTest() {
      ClientDocument entity = mock(ClientDocument.class);
      ClientDomain domain = mock(ClientDomain.class);

      List<ClientDomain> domains = List.of(domain);
      List<ClientDocument> entities = List.of(entity);

      when(repository.findAll()).thenReturn(entities);
      when(mapper.toDomain(entities)).thenReturn(domains);

      assertNotNull(repositoryImpl.findAll());
      verify(repository, times(1)).findAll();
  }

  @Test
  @DisplayName("should return client by id successfully")
  void shouldReturnClientByIdSuccessfullyTest() {
      Long id = 1L;
      ClientDocument entity = mock(ClientDocument.class);
      ClientDomain domain = mock(ClientDomain.class);

      when(domain.getId()).thenReturn(id);
      when(repository.findById(id)).thenReturn(Optional.of(entity));
      when(mapper.toDomain(entity)).thenReturn(domain);

      Optional<ClientDomain> result = repositoryImpl.findById(id);

      assertTrue(result.isPresent());
      assertNotNull(result);
      assertEquals(id, result.get().getId());
      verify(repository, times(1)).findById(id);
  }

  @Test
  @DisplayName("should save client successfully")
  void shouldSaveClientSuccessfullyTest() {
      Long id = 1L;
      ClientDocument entity = mock(ClientDocument.class);
      ClientDomain domain = mock(ClientDomain.class);

      when(entity.getId()).thenReturn(id);
      when(domain.getId()).thenReturn(id);
      when(repository.save(entity)).thenReturn(entity);
      when(mapper.toEntity(domain)).thenReturn(entity);
      when(mapper.toDomain(entity)).thenReturn(domain);

      ClientDomain result = repositoryImpl.save(domain);

      assertNotNull(result);
      assertEquals(id, result.getId());
      verify(repository, times(1)).save(entity);
      verify(mapper, times(1)).toDomain(entity);
      verify(mapper, times(1)).toEntity(domain);
  }

  @Test
  @DisplayName("should delete a client successful")
  void shouldDeleteClientSuccessfullyTest() {
      Long id = 1L;

      doNothing().when(repository).deleteById(id);

      repositoryImpl.deleteById(id);

      verify(repository, times(1)).deleteById(id);
  }
}
