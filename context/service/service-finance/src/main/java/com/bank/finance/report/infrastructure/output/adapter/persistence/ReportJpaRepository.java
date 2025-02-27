package com.bank.finance.report.infrastructure.output.adapter.persistence;

import com.bank.finance.movement.infrastructure.output.adapter.persistence.entity.MovementEntity;
import com.bank.finance.report.domain.model.AccountStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReportJpaRepository extends JpaRepository<MovementEntity, Long> {

    @Query(value = """
        SELECT
        	M.DATE as date,
        	C.NAME as client,
        	A.ACCOUNT_NUMBER as accountNumber,
        	A.ACCOUNT_TYPE as typeAccount,
        	A.OPENING_BALANCE as openingBalance,
        	M.STATUS as status,
        	CONCAT(CASE WHEN M.MOVEMENT_TYPE = 'SUBTRACT' THEN '-' ELSE '' END, M.VALUE) as movement,
        	M.BALANCE as availableBalance
        FROM BANK.MOVEMENT M
        	INNER JOIN BANK.ACCOUNT A ON A.ID = M.ID_ACCOUNT
        	INNER JOIN BANK.CLIENT C ON C.ID = A.CLIENT_ID
            WHERE C.ID = :client
                AND TO_CHAR(M.DATE, 'YYYY-MM-DD') BETWEEN TO_CHAR(TO_DATE(:start, 'YYYY-MM-DD'), 'YYYY-MM-DD') AND TO_CHAR(TO_DATE(:end, 'YYYY-MM-DD'), 'YYYY-MM-DD')
    """, nativeQuery = true)
    List<AccountStatement> getAccountStatement(Long client, LocalDate start, LocalDate end);
}
