-- ★ 고객(Customer) 관련
-- 1. 회원가입시 id 중복체크를 위한 SQL
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 2. 회원가입 SQL
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('aaa','111','홍길동','010-9999-9999', 'aaa@abc.com', '서울시 종로구','m','1991-01-01');
-- 3. 로그인할 때 (ID/PW)
SELECT * FROM CUSTOMER WHERE CID='aaa' and CPW='111';
-- 4. ID로 DTO 가져오기
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 5. 회원정보 수정
UPDATE CUSTOMER SET CPW='111',
                CNAME='엑스맨',
                CTEL = '010-9999-1111',
                CEMAIL='a@a.com',
                CADDRESS='서울시 용산구',
                CBIRTH=to_date('1992-03-12','yyyy-mm-dd'),
                CGENDER = 'm'
        WHERE CID='aaa';
-- 6. 회원리스트 보기(startRow부터 endRow 목록보기)
SELECT * FROM CUSTOMER ORDER BY CID;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM CUSTOMER ORDER BY CID) A)
    WHERE RN BETWEEN 4 AND 6;
-- 7. 등록된 회원 명수 가져오기
SELECT COUNT(*) TOTCNT FROM CUSTOMER;

-- ★ 도서(Book) 관련
-- 1. 책등록 
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은자바다',20000,'NOTHING.JPG','noImg.png','좋아',10);

-- 2.책목록(TOP-N) : 페이징
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
-- 3. 등록된 책 갯수
SELECT COUNT(*) FROM BOOK;
-- 4. bID로 책 가져오기
SELECT * FROM BOOK WHERE bID=3;

-- ★ 게시판(FileBoard) 관련
--1. 글목록(startRow부터 endRow까지 목록)
SELECT F.*, CNAME, cemail FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY fREF DESC, fRE_STEP; -- 목록 출력 기준

SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
        (SELECT F.*, CNAME, cemail FROM FILEBOARD F, CUSTOMER C
            WHERE F.CID=C.CID ORDER BY fREF DESC, fRE_STEP) A)
    WHERE RN BETWEEN 2 AND 4;  -- DAO에 쓸 QUERY

-- 2. 등록된 글 갯수
SELECT COUNT(*) FROM FILEBOARD;
-- 3. 원글쓰기
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', 'titile','',null,'111',
                FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.20.44');
-- 4. 답변글 쓰기전 STEP ⓐ 수행(REF가 같고 원글의 RE_STEP보다 많은 경우 RE_STEP++)
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP+1
            WHERE fREF=3 AND fRE_STEP>0;
SELECT * FROM FILEBOARD WHERE fREF=3;
-- 4. 답변글쓰기
INSERT INTO FILEBOARD 
    (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
  VALUES (FILEBOARD_SEQ.NEXTVAL, 'ddd', '답3-1','',NULL,'111',3, 1, 1, '127.0.0.1');
SELECT * FROM FILEBOARD ORDER BY fREF DESC, fRE_STEP;

-- 5. 글 상세보기(글번호로 DTO가져오기)
SELECT F.*, cNAME, cEMAIL FROM FILEBOARD F, CUSTOMER C 
        WHERE F.cID=C.cID AND fNUM=3;
-- 5. 조회수 올리기
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=3;
-- 6. 글 수정하기
UPDATE FILEBOARD SET fSUBJECT = '바뀐제목',
                    fCONTENT = '바뀐내용',
                    fFILENAME = NULL,
                    fPW = '111',
                    fIP = '127.0.0.1'
        WHERE fNUM=3;
SELECT * FROM FILEBOARD;
--7. 글삭제
DELETE FROM FILEBOARD WHERE fNUM=6 AND fPW='111';