DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SEQ;
CREATE TABLE MAJOR(
    mNO NUMBER(1,0),
    mNAME VARCHAR2(50),
    PRIMARY KEY(mNO));
CREATE SEQUENCE STUDENT_SEQ MAXVALUE 999 NOCACHE NOCYCLE;
CREATE TABLE STUDENT(
    sNO VARCHAR2(10),
    sNAME VARCHAR2(50),
    mNO NUMBER(1,0),
    SCORE NUMBER(3,0) DEFAULT 0 CHECK(SCORE>=0 AND SCORE<=100),
    sEXPEL NUMBER(1,0) DEFAULT 0 CHECK(sEXPEL=0 OR sEXPEL=1),
    PRIMARY KEY(sNO),
    FOREIGN KEY(mNO) REFERENCES MAJOR(mNO));
INSERT INTO MAJOR VALUES (1, '컴퓨터공학');
INSERT INTO MAJOR VALUES (2, '경영정보학');
INSERT INTO MAJOR VALUES (3, '산업디자인');
INSERT INTO MAJOR VALUES (4, '정보전자학');
INSERT INTO MAJOR VALUES (5, '연극영화학');
COMMIT;
SELECT * FROM MAJOR;
-- 콘솔 StudentMng
-- 1번. 이름, 전공명, 점수를 입력받아 
--    학번은 시퀀스를 이용하여 "현재년도||학과번호||순차번호"로 입력한다
SELECT * FROM STUDENT;
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||(SELECT mNO FROM MAJOR WHERE mNAME='컴퓨터공학')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '정우성',(SELECT mNO FROM MAJOR WHERE mNAME='컴퓨터공학'), 90) ;
SELECT * FROM STUDENT;
--2를 누르면 원하는 학과이름을 입력받아
--    학과별 조회후 총점을 추가하여 총점이 높은 순으로 이름(번호)로 출력
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND mNAME='컴퓨터공학'
            ORDER BY SCORE DESC);
--3을 누르면  
--     제적당하지 않은 전체 학생을 조회 후 점수가 높은 순으로 아래와 같이 출력한다
--등수     이름(studentID)         학과      	점수
--────────────────────────
--1등    	송혜교(20205005)     연극영화학     	100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=0
            ORDER BY SCORE DESC);

-- 스윙StudentMng에서 필요한 Query
-- 0. 첫화면에 전공이름들 콤보박스에 추가(mName)
SELECT MNAME FROM MAJOR;
-- 1. 학번검색 (sNo, sName, mName, score)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNO='20201001';
-- 2. 이름검색 (sNo, sName, mName, score)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNAME='정우성';
-- 3. 전공검색 (rank, name_no, mName, score) - 1 송혜교(20205005) 연극영화학(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND mNAME='컴퓨터공학'
            ORDER BY SCORE DESC);
-- 4. 학생입력
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||(SELECT mNO FROM MAJOR WHERE mNAME='연극영화학')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '신길동',(SELECT mNO FROM MAJOR WHERE mNAME='연극영화학'), 40);
COMMIT;
-- 5. 학생수정
UPDATE STUDENT SET  sNAME='신길동', 
                    mNO=(SELECT mNO FROM MAJOR WHERE mNAME='산업디자인'),
                    SCORE = 70
                WHERE SNO='20205008';
COMMIT;
-- 6. 학생출력 (rank, name_no, mName, score) - 1 송혜교(20205005) 연극영화학(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND sEXPEL=0
            ORDER BY SCORE DESC);
-- 7. 제적자출력  (rank, name_no, mName, score) - 1 송혜교(20205005) 연극영화학(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME, SCORE
    FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND sEXPEL=1
            ORDER BY SCORE DESC);
-- 8. 제적처리
UPDATE STUDENT SET sEXPEL = 1 WHERE SNO=20201004;

