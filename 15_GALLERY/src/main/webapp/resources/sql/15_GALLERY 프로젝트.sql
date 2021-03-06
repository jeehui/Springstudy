--첨부 게시판

--1. 단일 첨부
/*
    게시글1 - 첨부1
    
    게시판 : 제목, 내용, 작성자, 첨부파일명, 경로
*/

--2. 다중 첨부 
/*
    게시글 - 첨부1
           - 첨부2
    게시판 : 번호, 제목, 내용, 작성자
            ----
    첨부   : 첨부번호, 게시글번호(FK), 첨부파일명, 경로
*/
--둘의 차이는 데이터SQL기준에선 테이블의 개수가 달라진다.

DROP TABLE FILE_ATTACH;
CREATE TABLE FILE_ATTACH
(
    FILE_ATTACH_NO NUMBER NOT NULL, --PK
    PATH VARCHAR2(300 BYTE),
    ORIGIN VARCHAR2(300 BYTE),
    SAVED VARCHAR2(40 BYTE),
    GALLERY_NO NUMBER  ---FK
);



DROP TABLE GALLERY;
CREATE TABLE GALLERY
(
    GALLERY_NO NUMBER NOT NULL PRIMARY KEY, --PK
    GA_WRITER VARCHAR2(50 BYTE),
    TITLE VARCHAR2(100 BYTE),
    CONTENT VARCHAR2(100 BYTE),
    IP VARCHAR2(30 BYTE),
    HIT NUMBER,
    CREATED DATE,
    MODIFIED DATE

);
    
--기본키
ALTER TABLE FILE_ATTACH
    ADD CONSTRAINT FILE_ATTACH_PK
        PRIMARY KEY(FILE_ATTACH_NO);
ALTER TABLE GALLERY
    ADD CONSTRAINT GALLERY_PK
        PRIMARY KEY(GALLERY_NO);
        
--외래키
ALTER TABLE FILE_ATTACH
    ADD CONSTRAINT FILE_ATTACH_GALLERY_FK
        FOREIGN KEY(GALLERY_NO) REFERENCES GALLERY(GALLERY_NO)
            ON DELETE CASCADE; --게시글 삭제하면 첨부 내역이 함께 삭제

-- 시퀀스
DROP SEQUENCE GALLERY_SEQ;
CREATE SEQUENCE GALLERY_SEQ NOCACHE;
DROP SEQUENCE FILE_ATTACH_SEQ;
CREATE SEQUENCE FILE_ATTACH_SEQ NOCACHE;






