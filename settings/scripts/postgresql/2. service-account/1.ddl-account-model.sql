DROP SCHEMA IF EXISTS BANK CASCADE;
CREATE SCHEMA BANK;

SET
SEARCH_PATH = "BANK";

DROP TABLE IF EXISTS BANK.MOVEMENT;
DROP TABLE IF EXISTS BANK.ACCOUNT;

CREATE TABLE BANK.ACCOUNT
(
    ID              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    ACCOUNT_NUMBER  BIGINT                                  NOT NULL,
    ACCOUNT_TYPE    VARCHAR(20)                             NOT NULL,
    OPENING_BALANCE NUMERIC                                 NOT NULL,
    CLIENT_ID       VARCHAR                                 NOT NULL,

    CONSTRAINT ACCOUNT_PK PRIMARY KEY (ID)
) INHERITS (PUBLIC.ENTITY_BASE);


CREATE TABLE BANK.MOVEMENT
(
    ID            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    MOVEMENT_TYPE VARCHAR(10)                             NOT NULL,
    BALANCE       NUMERIC NULL,
    VALUE         NUMERIC                                 NOT NULL,
    DATE          TIMESTAMP                               NOT NULL,
    ID_ACCOUNT    BIGINT                                  NOT NULL,

    CONSTRAINT MOVEMENT_PK PRIMARY KEY (ID),
    CONSTRAINT MOVEMENT_ACCOUNT_FK FOREIGN KEY (ID_ACCOUNT) REFERENCES BANK.ACCOUNT (ID)
) INHERITS (PUBLIC.ENTITY_BASE);

SELECT *
FROM BANK.ACCOUNT;