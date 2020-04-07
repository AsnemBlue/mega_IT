DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(20) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    PW VARCHAR2(20) NOT NULL, 
    PHONE1 VARCHAR2(10),
    PHONE2 VARCHAR2(10),
    PHONE3 VARCHAR2(10),
    GENDER VARCHAR2(10)
);
-- 회원가입(id, name, pw, phone1, phone2, phone3, gender)
INSERT INTO MEMBER VALUES ('bbb','홍길동홍길동홍','111','02','9999','9999','f');
-- 로그인 (id, pw)
-- 1. id와 pw가 맞는지
-- 2. id가 맞으면 그 아이디인 사람의 정보(session에 추가하기 위함)
SELECT * FROM MEMBER WHERE ID='aaa' AND PW='111';
-- 회원정보수정
SELECT * FROM MEMBER WHERE ID='aaa';
UPDATE MEMBER 
    SET NAME='홍길동', PW='111', PHONE1 = '010', PHONE2='8888',PHONE3='8888',GENDER='f'
    WHERE ID='aaa';
commit;
select * from member;





