DROP TABLE MOVIE;
CREATE TABLE MOVIE
(
    NO          NUMBER PRIMARY KEY,
    TITLE       VARCHAR2(100 BYTE) NOT NULL,
    GENRE       VARCHAR2(100 BYTE) NOT NULL,
    DESCRIPTION VARCHAR2(500 BYTE) NOT NULL,
    STAR        NUMBER NOT NULL
);
DROP SEQUENCE MOVIE_SEQ;
CREATE SEQUENCE MOVIE_SEQ NOCYCLE NOCACHE;

INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '터미네이터', 'SF', '인간과 기게의 대전쟁', 5.0);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '아바타', 'SF', '판도라 행성으로 향한 인류', 5.0);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '에일리언', 'SF', '에일리언과의 사투', 4.5);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '엑소시스트','공포', '악마의 말은 듣지 말게', 3.5);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '쇼생트탈출', '드라마', '희망은 너를 자유롭게 하리라', 1.0);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '집으로', '드라마', '할머니 저 왔어요', 2.5);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '월-E', '애니메이션', '월-E와 매력적인 이브', 1.5);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '센과 치히로의 행방불명', '애니메이션', '금지된 신들의 세계로 온 치히로', 2.0);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '과속스캔들', '코미디', '스물두살 딸 여섯살 손자', 3.0);
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '엽기적인 그녀', '코미디', '견우야 미안해', 4.0);


COMMIT;