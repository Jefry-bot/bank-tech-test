SELECT *
FROM BANK.ACCOUNT;

INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (478758,
        'SAVINGS_ACCOUNT',
        2000,
        '67c9bf1b449d6009fad64a84');

INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (225487,
        'CHECKING_ACCOUNT',
        100,
        '67c9bf1b449d6009fad64a84');

INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (496825,
        'SAVINGS_ACCOUNT',
        540,
        '67c9bf1b449d6009fad64a84');

INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (495878,
        'SAVINGS_ACCOUNT',
        0,
        '67c9bf1b449d6009fad64a84');

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('ADD',
        2000,
        2000,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 478758));

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('ADD',
        100,
        100,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 225487));

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('ADD',
        540,
        540,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 496825));

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('ADD',
        0,
        0,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 495878));

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('SUBTRACT',
        575,
        1425,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 478758));

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('ADD',
        600,
        700,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 225487));

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('ADD',
        150,
        150,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 495878));

INSERT INTO BANK.MOVEMENT(MOVEMENT_TYPE,
                          VALUE,
                          BALANCE,
                          DATE,
                          ID_ACCOUNT)
VALUES ('SUBTRACT',
        540,
        0,
        NOW(),
        (SELECT A.ID FROM BANK.ACCOUNT A WHERE A.ACCOUNT_NUMBER = 496825));