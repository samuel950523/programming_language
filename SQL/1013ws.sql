CREATE TABLE EMP
(
EMPNO int(4) PRIMARY KEY,
ENAME VARCHAR(10),
JOB VARCHAR(9),
MGR int(4),
HIREDATE DATE,
SAL decimal(7,2),
COMM decimal(7,2),
DEPTNO int(2)
);

-- 1
desc emp;

-- 2
select EMPNO, ENAME, HIREDATE, SAL
from emp
where ENAME like 'K%';

-- 3
select *
from emp
where year(HIREDATE) = 2000;

-- 4
select *
from emp
where COMM IS NOT NULL;

-- 5
select ENAME, DEPTNO, SAL
from emp
where DEPTNO=30 AND SAL>=1500;

-- 6
select *
from emp
where DEPTNO=30
order by EMPNO;

-- 7
select *
from emp
order by SAL desc;

-- 8
select *
from emp
order by DEPTNO asc, SAL desc;

-- 9
select *
from emp
order by DEPTNO desc, ENAME asc, SAL desc;

-- 10
select ENAME, SAL, SAL*COMM/100 AS COMMCOST, SAL+SAL*COMM/100 AS TOTAL
from emp
where COMM IS NOT NULL
order by SAL+SAL*COMM/100 desc;

-- 11
select ENAME, SAL, SAL*0.13 AS bonus, DEPTNO
from emp
where DEPTNO=10;

-- 12
select ENAME, SAL, SAL/60 AS 시간당임금
from emp
where DEPTNO=20;

-- 13
select ENAME, SAL, ROUND(SAL*0.15,2) AS 회비
from emp
where SAL BETWEEN 1500 AND 3000;

-- 14
select ENAME, SAL, SAL*0.9 AS 실수령액
from emp
order by SAL desc;

-- 15
select ENAME, HIREDATE, DATEDIFF(now(),HIREDATE) AS 근무일수
from emp;

-- 16
select ENAME, TIMESTAMPDIFF(YEAR, HIREDATE, now()) AS 근속년수
from emp;


