package com.bank.finance.account.infrastructure.output.adapter.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.account.infrastructure.output.adapter.persistence.entity.AccountEntity;
import com.bank.finance.account.infrastructure.output.adapter.persistence.mapper.MapStructAccountPersistenceMapper;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Test suite for AccountRepositoryImpl.")
class AccountRepositoryImplTest {
    @Mock private AccountJpaRepository repository;
    @Mock private MapStructAccountPersistenceMapper mapper;

    @InjectMocks private AccountRepositoryImpl repositoryImpl;

    @Test
    @DisplayName("should return data successfully.")
    void shouldReturnDataSuccessfullyTest() {
        AccountDomain accountDomain = mock(AccountDomain.class);
        AccountEntity accountEntity = mock(AccountEntity.class);

        List<AccountDomain> domains = List.of(accountDomain);
        List<AccountEntity> entities = List.of(accountEntity);

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDomain(entities)).thenReturn(domains);

        assertNotNull(repositoryImpl.findAll());
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("should return account by id successfully.")
    void shouldReturnAccountByIdSuccessfullyTest() {
        Long id = 1L;
        AccountDomain accountDomain = mock(AccountDomain.class);
        AccountEntity accountEntity = mock(AccountEntity.class);

        when(accountDomain.getId()).thenReturn(id);
        when(repository.findById(id)).thenReturn(Optional.of(accountEntity));
        when(mapper.toDomain(accountEntity)).thenReturn(accountDomain);

        Optional<AccountDomain> account = repositoryImpl.findById(id);

        assertTrue(account.isPresent());
        assertNotNull(account);
        assertEquals(id, account.get().getId());

        verify(repository, times(1)).findById(id);
    }

    @Test
    @DisplayName("should save account successfully.")
    void shouldSaveAccountSuccessfullyTest() {
        Long id = 1L;
        AccountDomain accountDomain = mock(AccountDomain.class);
        AccountEntity accountEntity = mock(AccountEntity.class);

        when(accountDomain.getId()).thenReturn(id);
        when(mapper.toDomain(accountEntity)).thenReturn(accountDomain);
        when(repository.save(accountEntity)).thenReturn(accountEntity);
        when(mapper.toEntity(accountDomain)).thenReturn(accountEntity);

        AccountDomain result = repositoryImpl.save(accountDomain);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(repository, times(1)).save(accountEntity);
        verify(mapper, times(1)).toDomain(accountEntity);
        verify(mapper, times(1)).toEntity(accountDomain);
    }

    @Test
    @DisplayName("should delete a account successfully")
    void shouldDeleteAccountSuccessfully() {
        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        repositoryImpl.deleteById(id);

        verify(repository, times(1)).deleteById(id);
    }
}
