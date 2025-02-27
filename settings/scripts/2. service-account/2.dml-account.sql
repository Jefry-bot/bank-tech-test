SET SEARCH_PATH = 'ACCOUNT';

INSERT INTO BANK.CLIENT (NAME,
                         GENDER,
                         AGE,
                         IDENTIFICATION,
                         ADDRESS,
                         PHONE,
                         PASSWORD)
VALUES ('Jose Lema',
        'MALE',
        25,
        '97090127806',
        'Otavalo sn y principal',
        '098254785',
        '1234');

INSERT INTO BANK.CLIENT (NAME,
                         GENDER,
                         AGE,
                         IDENTIFICATION,
                         ADDRESS,
                         PHONE,
                         PASSWORD)
VALUES ('Marianela Montalvo',
        'FEMALE',
        25,
        '97090127806',
        'Amazonas y NNUU',
        '097548965',
        '5678');

INSERT INTO BANK.CLIENT (NAME,
                         GENDER,
                         AGE,
                         IDENTIFICATION,
                         ADDRESS,
                         PHONE,
                         PASSWORD)
VALUES ('Juan Osorio',
        'MALE',
        25,
        '97090127806',
        '13 junio y Equinoccial',
        '098874587',
        '1245');


INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (478758,
        'SAVINGS_ACCOUNT',
        2000,
        (SELECT ID FROM BANK.CLIENT C WHERE C.NAME = 'Jose Lema'));

INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (225487,
        'CHECKING_ACCOUNT',
        100,
        (SELECT ID FROM BANK.CLIENT C WHERE C.NAME = 'Marianela Montalvo'));

INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (496825,
        'SAVINGS_ACCOUNT',
        540,
        (SELECT ID FROM BANK.CLIENT C WHERE C.NAME = 'Marianela Montalvo'));

INSERT INTO BANK.ACCOUNT (ACCOUNT_NUMBER,
                          ACCOUNT_TYPE,
                          OPENING_BALANCE,
                          CLIENT_ID)
VALUES (495878,
        'SAVINGS_ACCOUNT',
        0,
        (SELECT ID FROM BANK.CLIENT C WHERE C.NAME = 'Juan Osorio'));

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