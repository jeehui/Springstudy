--계층형 게시판
/*
    나이키 팔아요
     ㄴ 줄 섭니다.
     ㄴ 불발되면 제가 삽니다.
    접시 팔아요
     ㄴ 택배가능?
*/
--자유 게시판

DROP TABLE FREE_BOARD;
CREATE TABLE FREE_BOARD
(
    /* 글번호 */      FREE_BOARD_NO NUMBER NOT NULL,
    /* 작성자 */      WRITER VARCHAR2(50 BYTE),
    /*  내용  */      CONTENT VARCHAR2(1000 BYTE),
    /*   IP   */      IP VARCHAR2(30 BYTE),
    /* 작성일 */      CREATED DATE,
    /* 수정일 */      MODIFIED DATE, 
    /* 삭제여부 */    STATE NUMBER, /* 정상: 1, 삭제: -1 */
    /* 게시글/댓글 */ DEPTH NUMBER, /* 게시글: 0, 댓글: 1 또는 1 이상 */
    /* 동일그룹 */    GROUP_NO NUMBER, /* 게시글: FREE_BOARD_NO, 댓글: 게시글의 FREE_BOARD_NO */
    /* 그룹내순서 */  GROUP_ORD NUMBER /* 동일그룹내 표시 순서 */
);

DROP SEQUENCE FREE_BOARD_SEQ;
CREATE SEQUENCE FREE_BOARD_SEQ NOCACHE; 