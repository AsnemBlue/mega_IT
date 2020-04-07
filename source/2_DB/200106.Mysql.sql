show databases;
create database kimdb;
use kimdb;
use world;
show tables; -- select * from tab;
SELECT * FROM CITY;
USE KIMDB;
SELECT DATABASE(); -- 현재 위치한 DATABASE
DROP table if exists major;
create table major(
	major_code int primary key auto_increment,
    major_name varchar(30));
insert into major (major_name) values ('경영정보');
insert into major (major_name) values ('전자공학');
insert into major (major_name) values ('화학공학');
select * from major;
drop table if exists student;
CREATE TABLE STUDENT(
	STU_ID int PRIMARY KEY,
    NAME VARCHAR(15),
    MAJOR_CODE int,
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE));
INSERT INTO STUDENT VALUES (1001, '홍길동', 1);
INSERT INTO STUDENT VALUES (1002, '김길동', 2);
INSERT INTO STUDENT VALUES (1003, '신길동', 9);
SELECT * FROM STUDENT;
SELECT * FROM STUDENT S, MAJOR M
	WHERE S.MAJOR_CODE=M.MAJOR_CODE;
SELECT * FROM STUDENT S LEFT JOIN MAJOR M
	ON S.MAJOR_CODE=M.MAJOR_CODE;    -- OUTER JOIN
-- 자바(JDBC)수업시간에 쓸 테이블
DROP TABLE IF EXISTS DIVISION;
CREATE TABLE DIVISION(
	DNO int PRIMARY KEY,        -- 부서번호(부서코드)
    DNAME varchar(20) NOT NULL, -- 부서이름check
    PHONE VARCHAR(20) UNIQUE,   -- 부서전화
    POSITION VARCHAR(20));      -- 부서위치
CREATE TABLE PERSONAL(
	PNO int PRIMARY KEY,       -- 사번
    PNAME varchar(10) NOT NULL,-- 이름
    JOB   varchar(15) NOT NULL,-- 직책
    MANAGER int,               -- 직속상사의 사번
    STARTDATE date,            -- 입사일
    PAY int,                   -- 급여
    BONUS int,                 -- 보너스
    DNO int,                   -- 부서번호
    FOREIGN KEY(DNO) REFERENCES DIVISION(DNO));
INSERT INTO DIVISION VALUES (10, 'finance','02-777-7777','종로');
INSERT INTO DIVISION VALUES (20, 'research','041-888-8888','대전');
INSERT INTO DIVISION VALUES (30, 'sales','031-666-6666','인천');
INSERT INTO DIVISION VALUES (40, 'marketing','02-555-5555','강남');
SELECT * FROM DIVISION;
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
SELECT * FROM PERSONAL;
-- 1. 사번, 이름, 급여를 출력
SELECT PNO, PNAME, PAY FROM PERSONAL;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
SELECT * FROM PERSONAL WHERE PAY BETWEEN 2000 AND 5000;
SELECT * FROM PERSONAL WHERE PAY>=2000 && PAY<=5000;
SELECT * FROM PERSONAL WHERE PAY>=2000 AND PAY<=5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
SELECT PNO, PNAME, DNO FROM PERSONAL WHERE DNO IN (10, 20) ORDER BY DNO DESC;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
SELECT PNO, PNAME, PAY, BONUS FROM PERSONAL WHERE BONUS IS NULL ORDER BY PAY;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 큰 순으로 정렬
SELECT PNO, PNAME, DNO, PAY FROM PERSONAL ORDER BY DNO DESC;
-- 6. 사번, 이름, 부서명
SELECT PNO, PNAME, DNAME FROM PERSONAL P, DIVISION D WHERE P.DNO=D.DNO;
-- 7. 사번, 이름, 상사이름
SELECT W.PNO, W.PNAME, M.PNAME 상사명
	FROM PERSONAL W, PERSONAL M
    WHERE W.MANAGER = M.PNO;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
SELECT W.PNO, W.PNAME, M.PNAME 상사명
	FROM PERSONAL W LEFT OUTER JOIN PERSONAL M
    ON W.MANAGER=M.PNO;
SELECT W.PNO, W.PNAME, ifnull(M.PNAME,'없음') 상사명
	FROM PERSONAL W LEFT OUTER JOIN PERSONAL M
    ON W.MANAGER=M.PNO;
SELECT W.PNO, W.PNAME, if(M.PNAME is null,'없음', M.PNAME) 상사명
	FROM PERSONAL W LEFT OUTER JOIN PERSONAL M
    ON W.MANAGER=M.PNO;
-- 9. 이름이 s로 시작하는 사원 이름
SELECT PNAME FROM PERSONAL WHERE PNAME LIKE 's%';
SELECT PNAME FROM PERSONAL WHERE SUBSTR(PNAME, 1, 1)='s';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
SELECT W.PNO, W.PNAME, W.PAY, DNAME, M.PNAME 관리자명 
	FROM PERSONAL W, PERSONAL M, DIVISION D 
    WHERE W.MANAGER = M.PNO && W.DNO=D.DNO;
-- 11. 부서코드, 급여합계, 최대급여
SELECT DNO, SUM(PAY), MAX(PAY) 
	FROM PERSONAL GROUP BY DNO;
-- 12. 부서명, 급여평균, 인원수
SELECT DNAME, AVG(PAY), COUNT(*) 
	FROM DIVISION D, PERSONAL P  
	WHERE D.DNO=P.DNO GROUP BY DNAME;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
SELECT DNO, SUM(PAY), COUNT(*) 
	FROM PERSONAL GROUP BY DNO HAVING COUNT(*)>=4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
SELECT PNO, PNAME, PAY FROM PERSONAL 
	WHERE PAY=(SELECT MAX(PAY) FROM PERSONAL);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여
SELECT PNAME, PAY, DNO FROM PERSONAL 
	WHERE PAY>(SELECT AVG(PAY) FROM PERSONAL);
-- 16. 15에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
SELECT PNAME, PAY, D.DNO, DNAME
	FROM PERSONAL P, DIVISION D
	WHERE P.DNO=D.DNO &&
		PAY > (SELECT AVG(PAY) FROM PERSONAL) 
	ORDER BY DNAME, PAY DESC;
-- 17. 자기부서평균보다 급여를 많이 받는 사람 이름, 급여
SELECT PNAME, PAY FROM PERSONAL P 
	WHERE PAY>(SELECT AVG(PAY) FROM PERSONAL 
					WHERE P.DNO=DNO);
SELECT * FROM PERSONAL P, 
(SELECT DNO, AVG(PAY) AVGSAL FROM PERSONAL GROUP BY DNO) A
	WHERE P.PAY > A.AVGSAL && P.DNO=A.DNO;
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
SELECT PNAME, PAY, DNAME FROM PERSONAL P, DIVISION D 
	WHERE P.DNO=D.DNO AND
	STARTDATE=(SELECT MIN(STARTDATE) FROM PERSONAL); 
-- 19. 이름, 급여, 해당부서평균
SELECT PNAME, PAY, (SELECT AVG(PAY) FROM PERSONAL WHERE DNO=P.DNO) 부서평균 
	FROM PERSONAL P;
-- 20. 이름, 급여, 부서명, 해당부서평균
SELECT PNAME, PAY, DNAME, (SELECT AVG(PAY) FROM PERSONAL WHERE DNO=P.DNO) 부서평균 
	FROM PERSONAL P, DIVISION D
	WHERE D.DNO=P.DNO;
-- 오라클과 다소 다른 단일행함수(컬럼함수)
SELECT CONCAT(PNAME, '(' , JOB, ')의 급여는 ',PAY) FROM PERSONAL;
SELECT ROUND(114.75, 1); -- FROM절 생략 가능
SELECT YEAR(STARTDATE) FROM PERSONAL;
SELECT MONTH(STARTDATE) FROM PERSONAL;
SELECT MONTHNAME(STARTDATE) FROM PERSONAL; -- 월이름(January , ...)
SELECT DAYNAME(STARTDATE) FROM PERSONAL; -- 요일
SELECT SYSDATE();
SELECT NOW(); -- 날짜와 시간(지금)
SELECT current_date(); -- 날짜만(지금)
SELECT current_time(); -- 시간만(지금)
SELECT date_format(STARTDATE, '%y년%m월%e일 %a %p %h시 %i분') FROM PERSONAL;
SELECT date_format(NOW(), '%Y년%m월%e일 %a %H시 %i분');
-- 이름, 급여, 높다 또는 낮다(3000기준)
SELECT PNAME, PAY, IF(PAY>=3000, '높다', '낮다') FROM PERSONAL;
-- TOP N구문
SELECT PNAME, PAY FROM PERSONAL ORDER BY PAY DESC LIMIT 0,3; -- 0등부터 3개 출력
SELECT PNAME, PAY FROM PERSONAL ORDER BY PAY DESC LIMIT 3,3;

SELECT PNAME, FORMAT(PAY, 0) FROM PERSONAL;
SELECT PNAME, FORMAT(PAY, 1) FROM PERSONAL;

-- 1월 7일 테스트용











