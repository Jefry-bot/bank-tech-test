package com.bank.finance.movement.infrastructure.output.adapter.persistence.repository;

import com.bank.finance.movement.domain.model.LastMovementDomain;
import com.bank.finance.movement.infrastructure.output.adapter.persistence.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovementJpaRepository extends JpaRepository<MovementEntity, Long> {
    @Query(value = """
        SELECT
            M.BALANCE as value
            FROM BANK.MOVEMENT M
                WHERE M.ID_ACCOUNT = :account
                    AND M.ID = (
                        SELECT MAX(ID) FROM BANK.MOVEMENT WHERE ID_ACCOUNT = :account
                   )
    """, nativeQuery = true)
    LastMovementDomain getLastBalance(Long account);
}
