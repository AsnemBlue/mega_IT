-- VI. SUB QUERY
-- SCOTT이 근무하는 부서이름
SELECT DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- JOIN
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- 서브쿼리
SELECT DNAME FROM DEPT 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- 메인쿼리
-- 서브쿼리의 종류 : 단일행서브쿼리, 다중행서브쿼리
-- JOB이 'MANAGER'인 사람의 부서이름
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- 서브쿼리(3행)
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (10,20,30);

-- 단일행 서브쿼리
SELECT MAX(SAL) FROM EMP; -- 최고금액 SAL
-- 최고금액SAL을 받는사람의 이름, 최고금액SAL
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP);
-- SCOTT과 같은 부서에 근무하는 사람들 이름
SELECT ENAME FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT')
        AND ENAME<>'SCOTT';
-- SCOTT과 같은 근무지에 근무하는 사람들 이름
SELECT * FROM DEPT;
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
SELECT * FROM EMP;
INSERT INTO EMP VALUES (9999,'홍길동',NULL, NULL, NULL, 9000, NULL, 50);
ROLLBACK; -- INSERT 취소
SELECT LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT';--서브쿼리
SELECT ENAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND 
    LOC=(SELECT LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT')
    AND ENAME<>'SCOTT';
-- 'SCOTT'과 같은 JOB을 가진 사원들의 모든 정보 출력
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');
-- 'scott'과 급여가 동일하거나 더 많이 받는 사원이름과 급여출력
SELECT ENAME, SAL FROM EMP WHERE SAL>=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');
-- 직속상관이 KING인 사원의 이름과 급여
SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');
-- 평균급여 이하를 받는 직원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<=(SELECT AVG(SAL) FROM EMP);
-- 부서번호, 부서별 최대급여, 그 최대급여를받는사람의이름, 그사람의급여
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 서브쿼리
SELECT DEPTNO, SAL, ENAME FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
-- 단일행다중행서브쿼리 : SCOTT과 JOB도 같고 부서번호도 같은 사람의 모든 필드를 출력
SELECT * FROM EMP 
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP
    WHERE ENAME='SCOTT');
-- 다중행서브쿼리 : 서브쿼리의 실행결과가 다중행 IN, ALL, ANY=SOME, EXISTS
-- 부서번호, DEPTNO(부서번호=부서코드)별로 최대급여, 그 최대급여를 받는 사람의 이름
SELECT DEPTNO, SAL, ENAME FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
-- 입시년도, 입사년별최소급여, 그 최소급여를 받는 사람 이름
-- 서브쿼리(입사년도별최소급여)
SELECT TO_CHAR(HIREDATE, 'YY'), MIN(SAL) 
    FROM EMP GROUP BY TO_CHAR(HIREDATE, 'YY');
SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2), MIN(SAL) 
    FROM EMP GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2);
-- 메인쿼리(메인쿼리 입사년도, 입사년도별최소급여, 그사람이름)
SELECT TO_CHAR(HIREDATE, 'YY') YEAR, SAL, ENAME FROM EMP
    WHERE (TO_CHAR(HIREDATE, 'YY'), SAL) IN 
            (SELECT TO_CHAR(HIREDATE, 'YY'), MIN(SAL) 
                FROM EMP GROUP BY TO_CHAR(HIREDATE, 'YY'))
    ORDER BY YEAR;
-- 급여가 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 모든 필드 출력
-- 서브쿼리(급여가 3000이상 받는 직원의 부서번호)
SELECT DEPTNO FROM EMP WHERE SAL>=3000; -- 다중행서브쿼리
-- 메인쿼리(서브쿼리에서 나온 부서번호와 같은 부서에 근무 직원들의 모든 필드)
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);
-- 부서별로 입사일이 가장 늦은 사람의 부서번호, 이름, 입사일을 출력
-- 서브쿼리 (부서별 가장 늦은 입사일)
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO;
-- 메인쿼리(부서번호, 이름, 입사일, 위의 서브쿼리 결과 같은 친구)
SELECT DEPTNO, ENAME, HIREDATE FROM EMP
    WHERE (DEPTNO, HIREDATE) 
            IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO)
    ORDER BY DEPTNO;
-- JOB(직책)별 가장 낮은 연봉을 받는 사람의 이름, JOB(직책), 연봉.
SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB; -- 서브쿼리(JOB별 MIN(SAL))
SELECT ENAME, JOB, SAL FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB);
-- 30번 부서 사원 중 급여가 가장 많은 사원보다 더 받은 급여를 받는 사람의 이름, 급여
SELECT SAL FROM EMP WHERE DEPTNO=30; -- 서브쿼리
SELECT ENAME, SAL FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30);
SELECT ENAME, SAL FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
-- 30번 부서 사원 급여 중 가장 작은값(950)보다 많은 급여를 받은 사원의 이름, 급여
SELECT ENAME, SAL FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30);
SELECT ENAME, SAL FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);
-- 직속부하가 있는 직원의 사원번호, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE EMPNO IN (SELECT MGR FROM EMP);

SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT EMPNO FROM EMP WORKER WHERE WORKER.MGR=MANAGER.EMPNO);

SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT EMPNO FROM EMP WHERE MGR=MANAGER.EMPNO);
-- 사번, 이름, 부서번호, SAL, 해당직원부서평균 (SELECT절에 SUBQUERY)
SELECT EMPNO, ENAME, DEPTNO, SAL, (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO)
    FROM EMP E;
-- 직속부하가 없는 직원들의 모든 정보를 출력
-- SELF JOIN+OUTER JOIN 이용
SELECT MANAGER.* FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR(+) = MANAGER.EMPNO AND WORKER.MGR IS NULL;
-- IN 연산자 이용
SELECT * FROM EMP WHERE EMPNO  IN (7902, 7698, NULL); -- A
SELECT * FROM EMP WHERE EMPNO=7902 OR EMPNO=7698 OR EMPNO=NULL; -- A

SELECT * FROM EMP WHERE EMPNO NOT IN (7902, 7698, NULL); -- B (A의 반대)
SELECT * FROM EMP WHERE EMPNO!=7902 AND EMPNO!=7698 AND EMPNO!=NULL; -- B(A의 반대)

SELECT * FROM EMP WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL);

-- EXISTS 연산자 이용
SELECT * FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MGR=MANAGER.EMPNO);

-- 탄탄다지기 예제
-- 부서별로 가장 급여를 많이 받는 사원의 정보(사원 번호, 사원이름, 급여, 부서번호)를 출력
        --(IN 연산자 이용)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 서브쿼리
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP 
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

--직급(JOB)이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력(IN)
SELECT DEPTNO, DNAME, LOC FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
    
--SAL이 3000이상인 사람들 중 연봉 등급을 나누어서 해당 등급별 최고 연봉을 받는 사람들의 
        --사번, 이름, 직업, 입사일, 급여, 급여등급을 출력
SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000 GROUP BY GRADE; -- 서브쿼리
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
        (GRADE, SAL) IN 
        (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE 
            WHERE SAL BETWEEN LOSAL AND HISAL AND 
                    SAL>=3000 GROUP BY GRADE); -- 메인쿼리

-- 입사일 분기별로 가장 높은 연봉을 받는 사람들의 
    --분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여를 출력하세요
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER FROM EMP;
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) QUARTER FROM EMP;
-- 서브쿼리(분기별 가장높은 연봉)
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) FROM EMP
    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER, EMPNO, ENAME, JOB, MGR, 
        HIREDATE, SAL, COMM FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN
        (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) FROM EMP
                        GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY QUARTER;

--SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되
    -- 영업 사원(JOB='SALESMAN')은 출력하지 않는다.(ALL이용)
SELECT ENAME, SAL, JOB FROM EMP 
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN') ;
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN');
    
-- SALESMAN 일부 어떤 한 사원보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를
    --출력하되 영업 사원을 포함해서 출력(ANY)
SELECT ENAME, SAL, JOB FROM EMP 
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN');
    
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN');
    
-- SAL이 3000미만인 사람 중에 가장 최근에 입사한 사람의 사원번호와 이름, 연봉, 
    --입사일을 출력
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP 
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP 
    WHERE HIREDATE >= ALL (SELECT HIREDATE FROM EMP WHERE SAL<3000);

-- 직급이 ‘SALESMAN’인 사원이 받는 급여의 최소 급여보다 많이 받는 사원들의 
    --이름, 급여, 직급, 부서번호를 출력하되 부서번호가 20번인 사원은 제외한다(ANY 연산자 이용)
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN') AND DEPTNO <> 20;
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP 
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN') AND DEPTNO <> 20;




-- ★ 셤연습문제
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP);

-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP);

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP);

--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND SAL<=(SELECT AVG(SAL) FROM EMP);
    
--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP, SALGRADE 
        WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
        
--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 
    --급여가 큰 순 정렬
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME 
    FROM EMP E, SALGRADE, DEPT D 
    WHERE SAL BETWEEN LOSAL AND HISAL AND 
        D.DEPTNO=E.DEPTNO AND 
        HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')  
        ORDER BY SAL DESC;
        
--7. 사원테이블에서 BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='BLAKE');
    
--8. 사원테이블에서 MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일을 검색하시오
SELECT EMPNO, ENAME, HIREDATE FROM EMP 
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP 
                        WHERE ENAME='MILLER');
                        
--9. 사원테이블에서 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
    
--10. 사원테이블에서 CLARK와 같은 부서며, 사번이 7698인 직원의 급여보다 
        -- 많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK'; -- 서브쿼리(CLARK의 부서번호)
SELECT SAL FROM EMP WHERE EMPNO=7698;  -- 서브쿼리(7698사번 직원의 급여)
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') 
    AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);
    
--11.  응용심화. 사원테이블에서 CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 
    --  많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK';-- 서브쿼리1
SELECT SAL FROM EMP WHERE EMPNO=7698; -- 서브쿼리2
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND 
        DNAME=(SELECT DNAME FROM EMP E, DEPT D 
            WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') 
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);

--12.  사원 테이블에서 BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, HIREDATE FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

--13.  사원 테이블에서 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름을 출력
        --(단 급여가 많은 순으로 출력하여라.)
SELECT EMPNO, ENAME FROM EMP 
    WHERE SAL>=(SELECT AVG(SAL) FROM EMP) ORDER BY SAL DESC;

-- 여기서부터는 다중행서브쿼리, 이전은 단일행서브쿼리
-- 14. 사원 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 종업원에 대해
    --사원 번호,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사원번호 순으로 출력하여라.
SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%'; 
SELECT EMPNO, ENAME, SAL FROM emp 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. 사원 테이블에서 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력
SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'; -- 20번 부서 단일서브쿼리
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE DEPTNO in (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
SELECT ENAME, JOB, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS';

-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문
SELECT ENAME, SAL FROM EMP 
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING');
    
SELECT ENAME, SAL FROM EMP W 
    WHERE EXISTS (SELECT * FROM EMP WHERE EMPNO=W.MGR AND ENAME='KING');

-- 17. 사원 테이블에서 SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES';

-- 18. 사원 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력
SELECT * FROM EMP WHERE SAL>(SELECT MIN(SAL)  FROM EMP WHERE DEPTNO=30);
SELECT * FROM EMP WHERE SAL > ANY (SELECT sal  FROM EMP WHERE DEPTNO=30);

-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력
SELECT ENAME, JOB FROM EMP WHERE DEPTNO=10 AND 
            JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);

-- 20. 사원 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력
SELECT * FROM EMP 
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP 
                        WHERE ENAME='FORD') AND ENAME != 'FORD';

-- 21. 이름이 JONES인 직원의 JOB과 같거나 
    --월급이 FORD 월급 이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성.
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력하여라.
SELECT JOB FROM EMP WHERE ENAME='JONES';--단일행 서브쿼리
SELECT SAL FROM EMP WHERE ENAME='FORD'; --단일행 서브쿼리
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP 
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='JONES') OR 
        SAL>=(SELECT SAL FROM EMP WHERE ENAME='FORD')
    ORDER BY JOB, SAL DESC;

-- 22. 사원 테이블에서 SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD') 
        AND ENAME NOT IN ('SCOTT', 'WARD');
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD')) 
        AND ENAME NOT IN ('SCOTT','WARD');

-- 23. 사원 테이블에서 CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB FROM EMP 
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D 
                    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');
    
-- 24. 사원 테이블에서 월급이 부서별 평균 월급보다 높은 사원을 사원번호,이름,급여를 출력하는 SELECT문을 작성하시오.
--사원번호, 이름, 급여, DEPTNO, 해당부서별평균SAL
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);

-- 25. 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력
SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB;
SELECT DEPTNO,ENAME,SAL FROM EMP 
    WHERE SAL < ALL(SELECT AVG(SAL) FROM EMP
        GROUP BY JOB); --업무별평균이하가 아니다.이렇게 많이 했을거같아
SELECT DEPTNO, ENAME, SAL FROM EMP E 
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE E.JOB=JOB);

-- 26 사원 테이블에서 적어도 한명 이상으로부터 보고를 받을 수 있는 사원을 
    --업무,이름,사원번호,부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP M 
    WHERE EXISTS (SELECT EMPNO FROM EMP W WHERE M.EMPNO=W.MGR) 
    ORDER BY DEPTNO;
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP);
-- 27. 사원 테이블에서 말단 사원의 사원번호,이름,업무,부서번호를 출력하는 SELECT문을 작성하시오.
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP E 
    WHERE NOT EXISTS (SELECT EMPNO FROM EMP WHERE E.EMPNO=MGR);
SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO FROM EMP W, EMP M 
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL; 
-- 서브쿼리 결과가 NULL이 있어 아래의 질의는 안 됨
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE EMPNO NOT IN (SELECT DISTINCT MGR FROM EMP); 
--그래서 아래와 같이 함
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE EMPNO NOT IN (SELECT DISTINCT MGR FROM EMP WHERE MGR IS NOT NULL);