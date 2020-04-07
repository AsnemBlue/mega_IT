SHOW USER;
SELECT * FROM TAB; -- gong이 가지고 있는 테이블은 X
SELECT * FROM SCOTT.EMPv1;
INSERT INTO SCOTT.EMPv1 (EMPNO, ENAME, DEPTNO) VALUES (1111,'김',30);
select * from scott.empv1;
commit;
select * from scott.salgrade;
insert into scott.salgrade values (6, 9999,9999);
INSERT INTO SCOTT.SALGRADE VALUES (7,9999,9999);