--1 TO_DATE 단일행함수를 이용하여 EMP 테이블에서 
--hiredate가 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 
--입사일을 최초 입사일부터 최근 입사일 순으로 정렬하여 출력
SELECT ENAME, JOB, HIREDATE FROM EMP 
  WHERE HIREDATE BETWEEN TO_DATE('19810220','YYYYMMDD')
  AND TO_DATE('19810501','YYYYMMDD')  ORDER BY HIREDATE;

SELECT ENAME, JOB, HIREDATE FROM EMP
  WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD')
  AND TO_DATE('1981/05/01','YYYY/MM/DD')  ORDER BY HIREDATE;
--2 EMP테이블과 DEPT테이블을 이용하여 사원명, 급여, 부서번호, 부서명, 근무지, 직속상사명을 
-- 출력하시오. 단, 직속상사가 없을 경우 직속상사명에는 ‘없음’으로 대신 출력하시오.
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'없음') 상사명
  FROM EMP W, EMP M, DEPT D  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;

SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'없음') 상사명
  FROM EMP W, EMP M, DEPT D  WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+);
--3 EMP테이블에서 사원명에 알파벳 L이 있는 사원에 대해 사원명, 직책, 부서명, 근무지를 출력
SELECT ENAME, JOB, DNAME, LOC
  FROM EMP E, DEPT D
  WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
--4 SALGRADE 테이블의 LOSAL을 등급최저 급여, HISAL을 등급 최고 급여로 이용하여, 
--EMP테이블의 사원을 사번, 사원명, 직책, 급여, 급여등급을 급여기준으로 내림차순 정렬하여 출력
SELECT EMPNO, ENAME, JOB, SAL, GRADE
  FROM EMP, SALGRADE
  WHERE SAL BETWEEN LOSAL AND HISAL
  ORDER BY SAL DESC;   
--5 EMP 테이블에서 부서번호가 20번인 사원의 사번, 사원명, 급여를 출력하되 
-- 급여 앞에는 $를 붙이고, 숫자는 3자리마다 콤마(,)를 추가하여 출력
SELECT EMPNO, ENAME, TO_CHAR(SAL, '$99,999') FROM EMP WHERE DEPTNO=20;
--6 EMP테이블과 DEPT 테이블을 통해 사원수가 5명 이상인 부서명과 사원수를 출력하는 
-- SQL문을 그룹함수와 테이블 JOIN을 이용하여 작성하시오.
SELECT DNAME, COUNT(*) FROM EMP E, DEPT D
    	WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME HAVING COUNT(*)>=5;
--7 EMP테이블에서 사원명이 ‘FORD’인 직원과 직책(JOB)과 급여(SAL)이 같은 사원의 모든 정보 출력
SELECT * FROM EMP WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP 
                                    WHERE ENAME='FORD') AND ENAME != 'FORD';
SELECT * FROM emp WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP 
                                    WHERE ENAME='FORD') AND ENAME <> 'FORD';
--8 EMP테이블에서 이름(ENAME)이 ‘KING’인 사원의 직속부하의 사원명(ENAME)과 급여(SAL)를 출력하는 SQL문을 작성하시오(서브쿼리, EXISTS연산자를 이용한 서브쿼리, SELF-JOIN).
SELECT ename, sal FROM emp 
    WHERE mgr=(SELECT empno FROM emp WHERE ename='KING');
SELECT ENAME, SAL FROM EMP W 
    WHERE EXISTS (SELECT * FROM EMP M WHERE M.EMPNO=W.MGR 
                                AND ENAME='KING');
SELECT W.ENAME, W.SAL FROM EMP W, EMP M
                   WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
--1 EMP 테이블에서 급여(SAL)가 각각의 부서별 평균 급여보다 높은 사원들만 사번, 사원명, 
--급여, 부서번호를 출력하는 SQL문을 작성하시오.
SELECT empno, ename, sal, DEPTNO FROM emp e WHERE sal > (SELECT avg(sal) 
	     FROM emp WHERE e.deptno=deptno);

--2 EMP 테이블에서 사원명이 ‘FORD’인 사원을 삭제하는 SQL문을 작성하시오.
DELETE FROM EMP WHERE ENAME='FORD';
--3 EMP 테이블에서 급여(SAL)이 3000이상인 사원들만 급여(SAL)을 10% 인상시키는 SQL문을 작성하시오.
UPDATE EMP SET SAL=SAL*1.1 WHERE SAL>=3000;
--4 EMP테이블에서 SCOTT사원의 부서번호(DEPTNO)는 20번으로, 직책(JOB)은 MANAGER로 수정하는 SQL문을 작성하시오
UPDATE EMP SET DEPTNO=20, JOB='MANAGER' WHERE ENAME=’SCOTT’;
--5 EMP 테이블과 DEPT 테이블을 이용하여, ‘DALLAS’에서 근무하는 직원들의 급여(SAL)을 1000씩 인상시키는 SQL문을 작성하시오.
UPDATE EMP SET SAL = SAL+1000 
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
--6 EMP 테이블에서 최근입사일순으로 6번째인 사원부터 최근입사일 순 10번째 사원까지
--사번, 사원명, 입사일을 출력하는 SQL문을 작성하시오.
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;

SELECT EMPNO, ENAME, HIREDTEE
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;
--7 데이터베이스에서 트랜잭션은 데이터 처리의 한 단위를 말한다. 데이터를 조작하기 위한 INSERT, UPDATE, DELETE 등의 명령들이 실행됨과 동시에 트랜잭션이 진행되는데, 이들 INSERT, UPDATE, DELETE작업이 성공적으로 데이터베이스에 반영·처리되도록 명령어를 작성하시오.
COMMIT;