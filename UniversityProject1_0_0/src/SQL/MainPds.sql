CREATE TABLE MAIN_PDS(
    PDS_SEQ NUMBER(8) PRIMARY KEY,
    REF NUMBER(8) NOT NULL,
    STEP NUMBER(8) NOT NULL,
    DEPTH NUMBER(8) NOT NULL,
    USER_ID VARCHAR2(50) NOT NULL,
    TITLE VARCHAR2(200) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    READCOUNT NUMBER(8) NOT NULL,
    FILENAME VARCHAR2(200) NOT NULL,
    ORG_FILENAME VARCHAR2(200) NOT NULL,
    STATUS NUMBER(8) NOT NULL,
    WDATE DATE NOT NULL
);
CREATE SEQUENCE PDS_SEQ
START WITH 1 INCREMENT BY 1;

ALTER TABLE MAIN_PDS
ADD CONSTRAINT FK_MAIN_PDS_ID FOREIGN KEY(USER_ID)
REFERENCES USERS(USER_ID);

--조회용
SELECT * FROM MAIN_PDS;