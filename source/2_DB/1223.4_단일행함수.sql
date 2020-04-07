-- 2019.12.20 ~ 12.23 4장 단일행 함수 (반대말 : 다중행함수=그룹함수)
SELECT ENAME, TO_CHAR(HIREDATE, 'YY-MM-DD DY"요일" AM HH:MI:SS') FROM EMP; -- 단일행
SELECT SUM(SAL) FROM EMP; -- EMP테이블의 SAL들의 합 - 그룹함수(다중행함수)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
-- 단일행 함수의 종류 : 숫자관련함수, 문자처리함수, 날짜관련함수, 형변환함수, VNL(), DECODE함수, ETC..
-- (1)숫자관련함수
SELECT ABS(-9) FROM DUAL;
-- 아무 의미 없는 1행짜리 테이블 : DUAL
SELECT * FROM DUAL;
SELECT FLOOR(34.5678) FROM DUAL; -- 소수점 이하를 내림
SELECT FLOOR(34.5678*10)/10 FROM DUAL;
SELECT TRUNC(34.5678, 2) FROM DUAL; -- 소수점 몇자리까지 내림
SELECT TRUNC(156.54, -1) FROM DUAL; -- 150
SELECT TRUNC(156.54, -2) FROM DUAL; -- 100
-- 이름, SAL(백의자리내림으로 출력)
SELECT ENAME, TRUNC(SAL, -3) FROM EMP;
SELECT ROUND(34.5678) FROM DUAL;-- 소수점에서 반올림
SELECT ROUND(34.5678,1) FROM DUAL; -- 소수점 한자리까지 , 반올림
SELECT ROUND(34.5678,3) FROM DUAL;
SELECT ROUND(34.5678, -1) FROM DUAL; -- 30
-- 이름, SAL(백의자리 반올림 출력)
SELECT ENAME, ROUND(SAL, -3) FROM EMP;
SELECT CEIL(34.5678) FROM DUAL; -- 소수점 올림
SELECT FLOOR(10/4) FROM DUAL;
SELECT POWER(3,2) FROM DUAL; -- 3의 2승 = 9
SELECT MOD('9',6) FROM DUAL;
-- 홀수달에 입사한 직원들의 모든 필드 출력
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1;

-- (2) 문자관련함수
SELECT UPPER('abcABC') FROM DUAL;-- 대문자로
SELECT LOWER('abcABC') FROM DUAL; -- 소문자로
SELECT INITCAP('abcABC') FROM DUAL;-- 첫번째문자만 대문자, 나머지는 소문자
-- JOB이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(JOB)='MANAGER';
SELECT EMPNO, LOWER(JOB) FROM EMP WHERE LOWER(JOB)='manager';
SELECT EMPNO, INITCAP(ENAME), INITCAP(JOB) FROM EMP;
-- CONCAT(A, B)
SELECT CONCAT(CONCAT('AB','CD'),'EF') FROM DUAL;
SELECT CONCAT('ABC','DEF') FROM DUAL;
SELECT CONCAT(CONCAT('ABC','DEF'),'GHI') FROM DUAL;
-- XXX는 JOB이다
SELECT CONCAT(CONCAT(ENAME, '는 '),CONCAT(JOB,'이다')) TITLE FROM EMP;
-- SUBSTR(str, 시작할 위치, 추출할 갯수) 첫번째 위치는 1.
-- SUBSTRB(str, 시작할 위치, 추출할 갯수)
SELECT SUBSTR('welcome to Oracle',3,2) FROM DUAL; -- lc
--             123456789
SELECT SUBSTR('welcome to Oracle',-3,2) FROM DUAL; -- 시작할 위치가 음수일 경우 -1은 제일 끝
-- 우리의 시스템에서의 날짜 포맷 : 81/01/02
-- SUBSTR함수를 이용해서 짝수일자에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE MOD(SUBSTR(HIREDATE, -2, 2),2)=0; --SUBSTR(HIREDATE, -2, 2):일자
SELECT SUBSTR('데이터베이스',2,2) FROM DUAL; -- 이터
SELECT SUBSTRB('데이터베이스',4,6) FROM DUAL; -- B(BYTE) 
-- 9월에 입사한 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '%/09/%'; -- LIKE
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2)='09'; -- SUBSTR()함수 '81/01/01'
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')= '09'; -- TO_CHAR() 함수
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')=9;
SELECT SUBSTR('ABCD',2,3) FROM DUAL;  -- 2번째 위치의 글자부터 3글자 출력 : BCD
SELECT SUBSTRB('ABCD',2,3) FROM DUAL; -- 2번째 BYTE 위치부터 3BYTE 출력 : BCD
SELECT SUBSTR('오락클디비',2,3) FROM DUAL; -- 2번째 위치글자부터 3글자 : 락클디
SELECT SUBSTRB('오락클디비',4,6) FROM DUAL; -- 4번째 BYTE위치 3BYTE 출력 
-- LENGTH(문자):문자의 길이수, LENGTHB(문자):문자의 BYTE수
SELECT LENGTH('ABCD'), LENGTHB('ABCD') FROM DUAL;
SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL;
-- INSTR(string, 찾을글자) : string에서 찾을글자의 위치
-- INSTR(string, 찾을글자, 시작위치) : 시작위치부터 string에서 찾을글자의 위치
-- INSTR(string, 찾을글자, 시작위치, K) : string에서 시작위치부터 K번째 나오는 찾을글자의 위치
SELECT INSTR('ABCABCABC','B') FROM DUAL;   -- 2
SELECT INSTR('ABCABCABC','B',3) FROM DUAL; -- 5
SELECT INSTR('ABCABCABC','B',3,2) FROM DUAL; -- 3번째 위치부터 3번째 나오는 'B'의 위치는 : 8
-- 9월에 입사한 직원들 모든 필드 출력
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09')=4;
-- LPAD(문자, 10, '*')  - 문자를 10자리 확보하고 왼쪽 빈자리 *를 채웁니다
SELECT LPAD('ORACLE', 20, '#') FROM DUAL;
-- RPAD(문자, 10, '*') - 문자를 10자리 확보하고 오른쪽 빈자리는 *로 채웁니다
SELECT RPAD('ORACLE',20, '*') FROM DUAL;
SELECT ENAME, LPAD(SAL, 6, '*') FROM EMP;
-- TRIM, LTRIM, RTRIM
SELECT TRIM('   ORACLE DB   ') FROM DUAL;
SELECT LTRIM('   ORACLE DB   '), RTRIM('    ORACLE DB   ') FROM DUAL;
SELECT TRIM('_' FROM '___ORACLE DB_____') FROM DUAL;
-- REPLACE(문자, 원글자, 바꿀글자)
SELECT REPLACE('abcabc','a','999') FROM DUAL;
-- 탄탄다지기
-- 83년도에 입사한 직원의 모든 필드 출력하기
-- SUBSTR, INSTR, TO_CHAR, LIKE
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 2)='83';
SELECT * FROM EMP WHERE INSTR(HIREDATE, '83')=1;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY')='83';
SELECT * FROM EMP WHERE HIREDATE LIKE '%83%';
-- 이름이 E로 끝나는 사원의 모든 필드 출력하기(SUBSTR, INSTR, LIKE)
SELECT * FROM EMP WHERE ENAME LIKE '%E';
SELECT * FROM EMP WHERE SUBSTR(ENAME, -1,1)='E';
SELECT * FROM EMP WHERE INSTR(ENAME, 'E', LENGTH(ENAME))=LENGTH(ENAME);
-- 이름이 E로 끝나는 사원의 이름(****E) 출력하기
SELECT ENAME, LPAD(SUBSTR(ENAME, -1,1), LENGTH(ENAME), '*') FROM EMP
    WHERE ENAME LIKE '%E';
-- 사번, 이름(S****), 직책, 입사일(81/09/**)
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP;
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*'), JOB,
    RPAD(SUBSTR(HIREDATE, 1, 6), 8, '*') FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YY/MM/**') FROM EMP;
-- 사번, 이름, 직책을 출력(직책은 이름의 문자열 수만큼만 표시)
SELECT EMPNO, ENAME, SUBSTR(JOB, 1, LENGTH(ENAME)) FROM EMP;
-- 82년12월에 입사한 직원들의 모든 필드를 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/12/01' AND '82/12/31';
SELECT * FROM EMP WHERE HIREDATE LIKE '82/12/%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 5)='82/12';
SELECT * FROM EMP WHERE INSTR(HIREDATE, '82/12')=1;
-- 이름의 세번째 글자가 R인 사원의 이름을 출력 ( LIKE, SUBSTR, INSTR)
SELECT ENAME FROM EMP WHERE ENAME LIKE '__R%';
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';
SELECT ENAME FROM EMP WHERE INSTR(ENAME, 'R', 3)=3;

-- (3) 날짜관련 예약어와 함수
SELECT SYSDATE "지금현재" FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD DY"요일" HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 "어제", SYSDATE "오늘", SYSDATE+1 "내일" FROM DUAL;
SELECT TO_CHAR(SYSDATE+14, 'YY-MM-DD HH24') FROM DUAL;
-- 이름, 입사일, 근무일자
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) "근무일자" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) "근무일자" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE)/365) "근무년수" FROM EMP;
-- MONTHS_BETWEEN(특정날짜, 특정날짜) ; 두 날짜간의 개월수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무달수" FROM EMP;
SELECT ENAME, TRUNC(MONTHS_BETWEEN(HIREDATE, SYSDATE)) FROM EMP;
-- ADD_MONTHS(특정날짜, N) ; 특정날짜에서  N개월후
-- ENAME, HIREDATE(입사일), 수습기간마지막날(수습은 입사후 6개월동안)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
-- NEXT_DAY(특정날짜, '수') 특정날짜로 처음 도래하는 수
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토요일') FROM DUAL;
-- 사원이름, 입사일, 입사후 맞는 첫주말
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE, '토') FROM EMP;
-- LAST_DAY(특정날짜) ; 특정날짜인 달의 말날
-- ENAME, 입사일, 월급날(말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "31말일" FROM EMP;
-- 이달의 말일
SELECT LAST_DAY(SYSDATE) FROM DUAL;
-- ROUND(반올림), TRUNC(버림) - YEAR, MONTH, DAY, 생략
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; -- YEAR 반올림 결과 : 가까운 1월1일
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- YEAR 버림   결과 : 올해 1월1일
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL; -- MONTH 반올림 결과 : 가까운 1일
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL; -- MONTH 버림 결과 : 이번달 1일
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL; -- DAY 반올림 결과 : 전 일요일
SELECT ROUND(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL;-- DAY 반올림 결과 : 가까운 일요일
SELECT TRUNC(TO_DATE('191222','YYMMDD'), 'DAY') FROM DUAL; 
--DEFAULT 반올림결과 : 0시0분0초
SELECT TO_CHAR(ROUND(SYSDATE),'YY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(TRUNC(SYSDATE), 'YY-MM_DD HH24:MI:SS') FROM DUAL;
-- 탄탄다지기
-- ENAME, 입사일, 입사일달의 1일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
-- ENAME, 입사일, 월급날(말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
-- ENAME, 입사일, 월급날(25일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 "월급날" FROM EMP;
SELECT SYSDATE-1, SYSDATE, SYSDATE+7 FROM DUAL; -- 날짜 계산 가능

-- ENAME, 입사일, 월급날(17일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1, 'MONTH')+16 "월급날" FROM EMP;

-- ENAME, 입사일, SAL(월급), 이때까지 받은 월급합
SELECT ENAME, HIREDATE, SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;
-- ENAME, 입사일, SAL, COMM, 이때까지 회사에서 받은 돈
SELECT ENAME, HIREDATE, SAL, COMM,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))+NVL(COMM,0)*TRUNC((SYSDATE-HIREDATE)/365)
    FROM EMP;

-- (4) 형변환함수
-- TO_CHAR(날짜, 패턴) 날짜를 문자로
-- YY(년도) MM(월) MON(월이름) D(일) DY(요일) AM(오전/오후) HH(12시간단위) HH24(24시간단위) MI(분) SS(초)
-- 패턴내에 알파벳이나 특수문자 사용 가능 외래어일 경우 ""안에
SELECT ENAME, SAL, TO_CHAR(HIREDATE, 'YYYY/MON/DD DY AM HH:MI:SS') FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD DY HH"시"MI"분"SS"초"') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM-DD') FROM DUAL;
-- TO_CHAR(숫자, 패턴) 숫자를 문자로
-- 패턴내 0 (자릿수, 자릿수가 맞지 않으면 0으로 채운다)
--       9 (자릿수, 자릿수가 맞지 않으면 채우지 않는다)
--       L (지역 통화단위 붙음)
--       $ ($ 통화단위가 붙음)
--       , (천단위마다 ,를 붙이고 싶을 때)
SELECT ENAME, SAL, TO_CHAR(SAL, 'L000,000.0') FROM EMP;
SELECT ENAME, SAL, TO_CHAR(SAL, '$999,999.9') FROM EMP;

-- TO_DATE(문자, 패턴) 문자를 날짜형로 '191216'
-- DATE_FORMET을 모른 상태에서 81년5월1일부터 83년 5월1일 사이에 입사한 직원들의 모든 필드
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD') AND
                        TO_DATE('19830501','YYYYMMDD');
-- 2019,8,1로부터 오늘이 몇일째인지
SELECT CEIL(SYSDATE - TO_DATE('20190801','YYYYMMDD')) FROM DUAL;

-- TO_NUMBER(문자, 패턴) 문자를 숫자로 '9,876' -> 9876
SELECT TO_NUMBER('1,000', '9,999') +1000 FROM DUAL;

-- (5) NULL 관련 함수 = NVL(널일수도 있는 데이터,널이면대신쓸값)
-- 사원이름, 상사의 이름(상사가 없으면 'CEO'라고 출력)
SELECT W.ENAME "사원이름", NVL(M.ENAME,'CEO') "상사의이름"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- 사원이름, MGR(MGR이 NULL이면 'CEO'라고 출력)
SELECT ENAME, NVL(TO_CHAR(MGR,'9999'),'CEO') MGR FROM EMP;
-- (6) DECODE(데이터, 값1, 결과1, 값2, 결과2, 값3, 결과3, ....., 값N,결과N, 그외결과)
SELECT ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES',
                                     40, 'OPERATIONS') AS "DNAME" FROM EMP;
SELECT ENAME, DEPTNO, CASE WHEN DEPTNO=10 THEN 'ACCOUNTING'
                           WHEN DEPTNO=20 THEN 'RESEARCH'
                           WHEN DEPTNO=30 THEN 'SALES'
                           WHEN DEPTNO=40 THEN 'OPERATIONS'
                           ELSE 'ETC' END AS "DNAME" FROM EMP;
SELECT ENAME, DEPTNO, CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                                  WHEN 20 THEN 'RESEARCH'
                                  WHEN 30 THEN 'SALES'
                                  WHEN 40 THEN 'OPERATION' END DNAME FROM EMP;
-- 기존의 SAL를 이용해서 조정될 SAL은 JOB에 따라 'ANALYST' 10%인상 'SALESMAN' 20%인상, 
                                           --'MANAGER' 30%인상 'CLERK' 40%인상
                                           -- 그외는 조정없음
-- 사번, 이름, 조정전 SAL, 인상된 SAL
SELECT EMPNO, ENAME, SAL, CASE WHEN JOB='ANALYST' THEN SAL*1.1
                            WHEN JOB='SALESMAN' THEN SAL*1.2
                            WHEN JOB='MANAGER' THEN SAL*1.3
                            WHEN JOB='CLERK' THEN SAL*1.4
                            ELSE SAL END "인상된 SAL" FROM EMP;
SELECT EMPNO, ENAME, SAL, CASE JOB WHEN 'ANALYST' THEN SAL*1.1
                            WHEN 'SALESMAN' THEN SAL*1.2
                            WHEN 'MANAGER' THEN SAL*1.3
                            WHEN 'CLERK' THEN SAL*1.4
                            ELSE SAL END "인상된 SAL" FROM EMP;
SELECT EMPNO, ENAME, SAL, DECODE(JOB, 'ANALYST', SAL*1.1, 'SALESMAN', SAL*1.2,
                    'MANAGER', SAL*1.3, 'CLERK', SAL*1.4, SAL) "인상된 SAL" FROM EMP;
-- 입사한 년도만
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY') FROM EMP; -- '1980'
SELECT ENAME, EXTRACT(YEAR FROM HIREDATE) FROM EMP; -- 년도(1980)만 추출하는 함수
SELECT ENAME, EXTRACT(MONTH FROM HIREDATE) FROM EMP;

-- (7) 그외
-- LEVEL, START WITH, CONNECT BY PRIOR
SELECT LEVEL, LPAD(' ', LEVEL*2)||'>'||ENAME, MGR FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR; -- 윗레벨과 아랫레벨의 연결 조건
-- <셤 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "증가된 급여(New Salary)",SAL*0.15 "증가액(Increase)" 
    FROM EMP;
--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월') "6개월후 월요일" FROM EMP;

--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, trunc(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 개월수, SAL, 
        MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL 급여총계 
    FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 개월수, SAL, 
        TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL, 'L9,999,999') 급여총계 
    FROM EMP;
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP;
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') from EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"요일"') from EMP;

--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME)>= 6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL 급여, COMM 보너스, SAL+NVL(COMM,0) "급여+보너스" FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT  ENAME, SUBSTR(ENAME, 2,3) FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE HIREDATE LIKE '%/12/%';
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 4,2)='12'; 
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE INSTR(HIREDATE, '12', 4)=4;
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)=12;
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';

--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--…….
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') 급여 FROM EMP;
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일 FROM EMP;

-- 13. 사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시 오.
-- 급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL,
 			 CASE WHEN SAL BETWEEN    0 AND 1000 THEN 'E'
                  WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
          		  WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
                  WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
                  WHEN SAL BETWEEN 4001 AND 5000 THEN 'A' END 등급 FROM EMP;
SELECT EMPNO, ENAME, SAL,
  			CASE WHEN SAL >= 0 AND SAL<= 1000 THEN 'E'
                 WHEN SAL >= 1001 AND SAL<= 2000 THEN 'D'
                 WHEN SAL >= 2001 AND SAL<= 3000 THEN 'C'
                 WHEN SAL >= 3001 AND SAL<= 4000 THEN 'B'
                 WHEN SAL >= 4001 AND SAL<=5000 THEN 'A' END 등급 FROM EMP;
SELECT EMPNO, ENAME, SAL,
  			CASE TRUNC((SAL-1)/1000) WHEN 0 THEN 'E' 
                                     WHEN 1 THEN 'D'
                                     WHEN 2 THEN 'C' 
                                     WHEN 3 THEN 'B' 
            ELSE 'A' END 등급 FROM EMP;
SELECT EMPNO, ENAME, SAL, 
        DECODE(TRUNC((SAL-1)/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A') 등급 
    FROM EMP;
--------급여가- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000이상 A
SELECT EMPNO, ENAME, SAL, 
        DECODE(TRUNC(SAL/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A') 등급 
    FROM EMP;
SELECT EMPNO, ENAME, SAL, CASE TRUNC(SAL/1000) WHEN 0 then 'E' 
                                               WHEN 1 THEN 'D' 
                                               WHEN 2 THEN 'C' 
                                               WHEN 3 THEN 'B'
                          ELSE 'A' END 등급 FROM EMP;

--14. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$9,999,999') FROM EMP 
    WHERE DEPTNO=20;
DESC EMP;

    
    
    
    
    