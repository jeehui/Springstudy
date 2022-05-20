DROP TABLE NOTICE;
CREATE TABLE NOTICE
(
    NOTICE_NO NUMBER NOT NULL PRIMARY KEY,
    TITLE VARCHAR2(100 BYTE) NOT NULL,
    CONTENT VARCHAR2(1000 BYTE),
    HIT HUMBER,
    CREATED TIMESTAMP,
    LASTMODIFIED TIMESTAMP
);
DROP SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE NOTICE_SEQ NOCACHE;