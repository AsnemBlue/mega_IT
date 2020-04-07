-- ★ Book.xml(신규순list, 도서보기(paging), 책갯수, 상세보기, 도서등록,  도서정보수정)
-- Book.xml id = mainList(신규도서순으로 list가져오기)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- Book.xml id = bookList (paging처리해서 도서이름 순으로 list가져오기)
SELECT * FROM BOOK ORDER BY BTITLE;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BTITLE) A)
    WHERE RN BETWEEN 1 AND 3;
-- Book.xml id = cntBook (등록된 책 갯수가져오기)
SELECT COUNT(*) FROM BOOK;
-- Book.xml id = getBook (책번호bnum으로 dto가져오기)
SELECT * FROM BOOK WHERE BNUM=1;
-- Book.xml id = registerBook (책 등록하기)
INSERT INTO BOOK (bnum, btitle, bwriter, brdate, bimg1, bimg2, binfo) VALUES
    (BOOK_SEQ.NEXTVAL, '오라클','오길동',SYSDATE, 'noImg.png', 'noImg.png','좋은 spring책');
INSERT INTO BOOK (bnum, btitle, bwriter, brdate, bimg1, binfo) VALUES
    (BOOK_SEQ.NEXTVAL, 'Java','윤길동',SYSDATE, 'noImg.png', '좋은 spring책');
INSERT INTO BOOK (bnum, btitle, bwriter, brdate,  bimg2, binfo) VALUES
    (BOOK_SEQ.NEXTVAL, 'JSP','제이피',SYSDATE,  'noImg.png','좋은 spring책');
INSERT INTO BOOK (bnum, btitle, bwriter, brdate, binfo) VALUES
    (BOOK_SEQ.NEXTVAL, 'PYTHON','팽길동',SYSDATE,  '좋은 spring책');
-- Book.xml id = modifyBook (책정보수정하기)
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='최',
    brdate=sysdate,
    bimg1='noImg.png',
    bimg2='noImg.png',
    binfo='좋은 책'
    WHERE BNUM=2;
-- ★ Member.xml(id중복체크, 가입, id로 dto가져오기, 정보수정)
-- Member.xml id=idConfirm (해당id가 몇개인지)
SELECT COUNT(*) FROM MEMBER WHERE MID='bbb';
-- Member.xml id = joinMember (회원가입)
INSERT INTO MEMBER VALUES
    ('bbb','1','홍길동','hybrid0506@gmail.com', '서울시 종로구','01234');
-- Member.xml id = getMember (mid로 dto가져오기)
SELECT * FROM MEMBER WHERE MID='bbb';
-- Member.xml id = modifyMember (회원정보수정)
UPDATE MEMBER SET MPW='111',
                MNAME='유길동',
                MMAIL = 'hybrid0506@gmail.com',
                MADDR='서울시 용산구',
                MPOST = '01234'
        WHERE MID='bbb';





