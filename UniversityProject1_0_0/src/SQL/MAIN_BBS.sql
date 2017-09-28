--테이블 삭제
DROP TABLE MAIN_BBS
CASCADE CONSTRAINT;

DROP SEQUENCE MAIN_BBS_SEQ;

--테이블 생성
CREATE TABLE MAIN_BBS(
	BOARD_URL VARCHAR2(50) NOT NULL,
    BBS_REF NUMBER(8) NOT NULL,
    BBS_REPLY VARCHAR2(10) DEFAULT '0' NOT NULL,
    BBS_SEQ NUMBER(8) PRIMARY KEY,
    USER_ID VARCHAR2(50) NOT NULL,
    BBS_TITLE VARCHAR2(200) NOT NULL,
    BBS_CONTENT VARCHAR2(4000) NOT NULL,
    BBS_READCOUNT NUMBER(8) DEFAULT 0 NOT NULL,
    BBS_STORED_FILENAME VARCHAR2(200) DEFAULT '-1' NOT NULL,
    BBS_ORG_FILENAME VARCHAR2(200) DEFAULT '-1' NOT NULL,
    BBS_STATUS NUMBER DEFAULT 1 NOT NULL,
    BBS_WDATE DATE DEFAULT SYSDATE NOT NULL
);

--외래키 생성
ALTER TABLE MAIN_BBS
ADD CONSTRAINT FK_MAIN_BBS_ID FOREIGN KEY(USER_ID)
REFERENCES USERS(USER_ID);

--시퀀스 생성
CREATE SEQUENCE MAIN_BBS_SEQ
START WITH 1 INCREMENT BY 1;

--테이블 조회
SELECT * FROM MAIN_BBS

SELECT 
			BBS_REF as bbsRef, 
			BBS_REPLY as bbsReply, 
			BBS_SEQ as bbsSeq, 
			USER_ID as userId, 
			BBS_TITLE as bbsTitle, 
			BBS_CONTENT as bbsContent, 
			BBS_READCOUNT as bbsReadCount, 
			BBS_STORED_FILENAME as bbsStoredFileName, 
			BBS_ORG_FILENAME as bbsOrgFileName, 
			BBS_STATUS as bbsStatus, 
			BBS_WDATE as bbsWdate
		FROM (
				SELECT BBS_REF, BBS_REPLY, BBS_SEQ, USER_ID, BBS_TITLE, BBS_CONTENT, BBS_READCOUNT, BBS_STORED_FILENAME, BBS_ORG_FILENAME, BBS_STATUS, BBS_WDATE, 
				ROW_NUMBER() OVER (ORDER BY BBS_REF desc, BBS_REPLY ASC) R
				FROM MAIN_BBS
				WHERE BOARD_NAME = '대문공지'
				AND BBS_STATUS = 1
		)
		WHERE R BETWEEN #{startArticle} and #{endArticle}
		
--더미데이터 넣기
INSERT INTO MAIN_BBS(
	BOARD_NAME, BBS_REF, BBS_SEQ, USER_ID, BBS_TITLE, 
	BBS_CONTENT, BBS_STORED_FILENAME, BBS_ORG_FILENAME
)
VALUES(
	#{boardName}, MAIN_BBS_SEQ.NEXTVAL, MAIN_BBS_SEQ.NEXTVAL, #{userId}, #{bbsTitle}, 
	#{bbsContent}, #{bbsStoredFileName}, #{bbsOrgFileName}
)