DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM NUMBER(5) PRIMARY KEY, -- 글번호
    WRITER VARCHAR2(30) NOT NULL, -- 작성자
    SUBJECT VARCHAR2(100) NOT NULL, -- 글제목
    CONTENT VARCHAR2(1000) NOT NULL, -- 글본문
    EMAIL VARCHAR2(30),              -- 작성자 메일주소
    HIT   NUMBER(5) DEFAULT 0,
    PW    VARCHAR2(30) NOT NULL,     -- 글삭제 시 쓸 비밀번호
    REF   NUMBER(5)    NOT NULL,     -- 글그룹
    RE_STEP NUMBER(5)  NOT NULL,     -- 같은 글 그룹끼리 출력 순서(원글:0)
    RE_LEVEL NUMBER(5) NOT NULL,     -- 답변글일 경우 들여쓰기 정도(원글:0)
    IP       VARCHAR2(20) NOT NULL,  -- 작성자의 컴퓨터 IP 주소
    RDATE DATE DEFAULT SYSDATE);     -- 글쓴 시점(날짜+시간)
-- 글갯수
SELECT COUNT(*)  FROM BOARD;
-- 글목록 (최신글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC;
-- 글쓰기
SELECT NVL(MAX(NUM),0)+1 FROM BOARD; -- 새로운 글에 할당될 글번호
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '홍길동','제목임다','본문임다',NULL,
            '111', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0,'192.168.20.41');
SELECT * FROM BOARD ORDER BY NUM DESC;
-- 글번호로 글(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM=1;
-- HIT수 올리기
UPDATE BOARD SET HIT = HIT+1 WHERE NUM=1;
-- 글 수정
UPDATE BOARD SET WRITER = '김길동',
                 SUBJECT = '바뀐 제목',
                 CONTENT = '바뀐 내용',
                 EMAIL = 'yi@naver.com',
                 PW = '111',
                 IP = '192.168.20.41'
        WHERE NUM=1;
-- 글삭제
DELETE FROM BOARD WHERE NUM=1 AND PW='111';
COMMIT;
SELECT * FROM BOARD ORDER BY NUM DESC;