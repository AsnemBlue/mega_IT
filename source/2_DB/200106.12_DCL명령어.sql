-- DCL (CREATE USER ~, ALTER USER~, GRANT, REVOKE, DROP USER) - DBA권한이 있을 때 가능
CREATE USER gong IDENTIFIED BY gong; -- 사용자 생성
ALTER USER gong IDENTIFIED BY tiger; -- 비밀번호 변경
select * from empv1;
GRANT CREATE SESSION TO gong;
-- 여러번 grant(권한부여)하지 않고 권한객체를 만들어서 한번에 권한을 주는게
CREATE ROLE ROLLEX1; -- ROLLEX1권한 객체 생성
-- ROLLEX1은 로그인, 테이블생성, 뷰생성할 수 있는 권한 객체
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO ROLLEX1; 
GRANT ROLLEX1 TO gong;
GRANT SELECT ON EMPv1 TO gong; -- gong은 scott이 가지고 있는 EMPv1 테이블을 SELECT
SHOW USER;
GRANT ALL ON EMPv1 TO gong;
select * from empV1;
select * from emp;
GRANT ALL ON SALGRADE TO gong;
REVOKE ALL ON SALGRADE FROM gong;
GRANT SELECT ON SALGRADE TO gong;
DROP USER gong CASCADE; -- 사용자 삭제




