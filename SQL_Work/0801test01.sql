SELECT * FROM EMP;
SELECT * FROM salgrade;
SELECT * FROM dept;

SELECT ENAME '사원이름', GRADE '사원직위'
FROM EMP, salgrade
WHERE SAL BETWEEN(LOSAL, HISAL);
-- 1) 사원의 이름과 직위를 출력하세요. 단 사원의 이름은 '사원이름', 직위는 '사원직위' 머리글이 나오도록 출력하세요. (X)

SELECT ENAME '사원이름', SAL '급여'
FROM EMP WHERE DEPTNO = 30;
-- 2) 30번 부서에 근무하는 모든 사원의 이름과 급여를 출력하세요.

SELECT EMPNO 사원번호, ENAME 이름, SAL 현재급여, IFNULL(COMM, 0) AS '증가액', (SAL*1.1) '인상된 급여'
FROM EMP ORDER BY EMPNO;
-- 3) 사원번호와 이름, 현재 급여, 증가한 급여분(열 이름은 '증가액'), 10% 인상된 급여(열 이름은 '인상된 급여')를 사원번호순으로 출력하세요.

SELECT ENAME '이름', DEPTNO '부서번호'
FROM EMP WHERE ENAME LIKE 'S%';
-- 4) 'S'로 시작하는 모든 사원과 부서번호를 출력하세요.

SELECT MAX(SAL) 'MAX', MIN(SAL) 'MIN', SUM(SAL) 'SUM', ROUND(AVG(SAL), 0) 'AVG'
FROM EMP;
-- 5) 모든 사원의 최대 및 최소 급여, 합계 및 평균 급여를 출력하세요.
--  열 이름은 각각 MAX, MIN, SUM, AVG로 합니다. 단, 소수점 이하는 반올림하여 정수로 출력하세요.

SELECT DNAME 업무, COUNT(EMP.DEPTNO) '업무별 사원수'
FROM DEPT, EMP
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY EMP.DEPTNO;
-- 6) 업무 이름과 업무별로 동일한 업무를 하는 사원의 수를 출력하세요. 열 이름은 각각 '업무'와 '업무별 사원수'로 합니다.

SELECT MAX(SAL)-MIN(SAL) '차액'
FROM EMP;
-- 7) 사원의 최대 급여와 최소 급여의 차액을 출력하세요.

SELECT COUNT(*) '구성원 수', SUM(SAL) SUM, ROUND(AVG(SAL), 0) AVG
FROM EMP WHERE DEPTNO = 30;
-- 8) 30번 부서의 구성원 수와 사원들 급여의 합계와 평균을 출력하세요.

SELECT DEPTNO
FROM emp
WHERE AVG(SAL) = MAX(AVG(SAL))
GROUP BY DEPTNO;
-- 9) 평균 급여가 가장 높은 부서의 번호를 출력하세요. (X)

SELECT JOB '업무명', AVG(SAL) '평균 급여'
FROM EMP
WHERE SAL >= 3000
GROUP BY JOB
ORDER BY AVG(SAL) DESC;
-- 10) 세일즈맨(SALESMAN)을 제외하고, 업무별 사원의 급여가 3,000 이상인 각 업무에 대해서,
-- 업무명과 업무별 평균 급여를 출력하세요. 단 평균 급여는 내림차순으로 출력합니다.

SELECT COUNT(*)
FROM EMP
WHERE MGR IS NOT NULL;
-- 11) 전체 사원 가운데 직속상관이 있는 사원의 수를 출력하세요.

SELECT ENAME '이름', SAL '급여', COMM '커미션', (SAL+COMM) '총액'
FROM EMP
WHERE COMM IS NOT NULL
ORDER BY 총액 DESC;
-- 12) EMP테이블에서 이름, 급여, 커미션(COMM)금액, 총액(SAL+COMM)을 구하여
-- 총액이 많은 순서대로 출력하세요. 단 커미션이 NULL인 사람은 제외합니다.

SELECT DEPTNO '부서번호', JOB '업무이름', COUNT(*) '인원수'
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY 부서번호;
-- 13) 부서별로 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무이름, 인원수를 출력하세요.

SELECT DNAME

-- 14) 사원이 한 명도 없는 부서의 이름을 출력하세요. (X)

SELECT JOB '업무', COUNT(JOB) '인원수'
FROM EMP
GROUP BY JOB
HAVING COUNT(JOB)>=4;
-- 15) 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하세요.

