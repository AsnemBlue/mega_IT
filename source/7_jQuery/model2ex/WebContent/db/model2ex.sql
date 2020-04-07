DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
CREATE TABLE FILEBOARD(
    fId NUMBER(6) PRIMARY KEY,
    mId VARCHAR2(30) REFERENCES MVC_MEMBER(MID),
    fTitle VARCHAR2(100) NOT NULL,
    fContent VARCHAR2(1000),
    fFileName VARCHAR2(30),
    fRdate    DATE DEFAULT SYSDATE,
    fHit     NUMBER(6) DEFAULT 0,
    fGroup   NUMBER(6) NOT NULL,
    fStep    NUMBER(3) NOT NULL,
    fIndent  NUMBER(3) NOT NULL,
    fIp      VARCHAR2(20) NOT NULL);

-- 더미데이터(원글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME,  
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','title','content',null, 
        FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.20.31');
SELECT * FROM FILEBOARD;
-- 더미데이터(위의 1번글에 대한 첫번째 답변글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','reply','content', null,
        1, 1, 1, '192.168.20.31');
select * from fileboard order by fgroup desc, fstep;
-- 더미데이터 (위의 1번글에 대한 두번째 답변글)
--    답변글 추가전 STEP a 수행
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','reply','content', null,
        1, 1, 1, '192.168.10.151');
COMMIT;
-- 글목록(startRow부터 endRow까지) - 글번호, 작성자이름, ...
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID 
                ORDER BY FGROUP DESC, FSTEP; -- 출력 기준
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID 
                ORDER BY FGROUP DESC, FSTEP) A)
    WHERE RN BETWEEN 1 AND 11;
-- 글갯수
SELECT COUNT(*) FROM FILEBOARD;
-- 글쓰기(원글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,  
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','title','content',null, 
        FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.10.151');
-- FHit 하나 올리기(1번글 조회수 하나 올리기)
UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=1;
-- bId로 글 dto보기
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE M.MID=F.MID AND FID=1;
-- 글 수정하기(FId, FTitle, FContent, FILENAME,  FIp, FDATE)
UPDATE FILEBOARD SET FTITLE = '제목',
                    FCONTENT = '본문',
                    fFILENAME = NULL,
                    FIP = '192.168.151.10',
                    FDATE = SYSDATE
            WHERE FID = 1;
-- 글 삭제하기(bId로 삭제하기)
DELETE FROM FILEBOARD WHERE FID=3;
--    답변글 추가전 STEP a 수행
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
-- 답변글 쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb','reply','content', null,
        1, 1, 1, '192.168.10.151');
commit;
----------------------------------------------------------------------
--                          admin table                             --
----------------------------------------------------------------------
DROP TABLE ADMIN;
CREATE TABLE ADMIN(
    aId VARCHAR2(30) PRIMARY KEY,
    aPw VARCHAR2(30) NOT NULL,
    aName VARCHAR2(30) NOT NULL);
-- dummy data
INSERT INTO ADMIN VALUES ('admin','111','김관리');
-- admin loginCheck
SELECT * FROM ADMIN WHERE AID='admin' AND APW='111';
-- admin aid로 dto 가져오기
SELECT * FROM ADMIN WHERE AID='admin';
COMMIT;