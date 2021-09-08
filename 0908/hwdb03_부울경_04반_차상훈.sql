use ssafydb;
-- 1. emp와 dept Table을 JOIN하여 이름, 급여, 부서명을 검색하세요.
select e.ename, e.sal, d.dname
from emp e left join dept d
on e.deptno = d.deptno;
-- left join을 활용하여 부서가 지정되지 않은 사원 출력

-- 2. 이름이 ‘KING’인 사원의 부서명을 검색하세요.
select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where ename='king';

-- 3. dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
select deptno, dname from dept;				-- dept table에 있는 모든 부서 출력
select e.ename, d.deptno, d.dname, e.sal	-- emp table에 있는 data와 join하여 모든 사원의 이름, 부서번호, 부서명, 급여 출력
from emp e left join dept d
on e.deptno = d.deptno;

-- 4. emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력되도록 쿼리를 작성하세요. ‘SCOTT의 매니저는 JONES이다’.
select concat(e.ename, '의 매니저는 ', m.ename, '이다.') as 'empno와 mgr의 상관관계'
from emp e join emp m
on e.mgr = m.empno;

-- 5. 'SCOTT'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를 검색하세요.
select e.ename, d.dname, e.sal, e.job
from emp e join dept d
on e.deptno = d.deptno
where e.job in (select job 
			  from emp 
              where ename='SCOTT');

-- 6. 'SCOTT’가 속해 있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 검색하세요.
select empno, ename, hiredate, sal
from emp
where deptno in (
				  select e.deptno
                  from emp e join dept d
                  on e.deptno = d.deptno
                  where ename='SCOTT');

-- 7. 전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서명, 입사일, 지역, 급여를 검색하세요.
select e.empno, e.ename, d.deptno, e.hiredate, d.loc, e.sal
from emp e join dept d
on e.deptno = d.deptno
where sal > all (select avg(sal)
				 from emp);

-- 8. 30번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 검색하세요.
select e.empno, e.ename, d.dname, d.loc, e.sal
from emp e join dept d
on e.deptno = d.deptno
where job in (
				select job
                from emp
				where deptno=30) order by sal desc;

-- 9. 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 검색하세요.
select e.empno, e.ename, d.dname, e.hiredate, d.loc
from emp e join dept d
on e.deptno = d.deptno
where job not in (
			  select job
              from emp
              where deptno=30) and e.deptno=10;
              
-- 10.‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 검색하세요.
select empno, ename, sal
from emp
where sal in (
			  select sal
              from emp
              where ename = 'KING' or ename = 'JAMES');	-- 확인용 쿼리: or ename = 'SCOTT'
              
-- 11. 급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 검색하세요.
select empno, ename, sal
from emp
where sal > (
			 select max(sal)
             from emp
             where deptno=30);

-- 12. 이름 검색을 보다 빠르게 수행하기 위해 emp 테이블 ename에 인덱스를 생성하시오.
create index index_ename on emp (ename);
show index from emp;

-- 13. 이름이 'ALLEN'인 사원의 입사연도가 같은 사원들의 이름과 급여를 출력하세요.
select ename, sal
from emp
where year(hiredate) in 
			   (
			   select year(hiredate)
               from emp
               where ename='ALLEN');
               
-- 14. 부서별 급여의 합계를 출력하는 View를 작성하세요.

-- 15. 14번에서 작성된 View를 이용하여 부서별 급여의 합계가 큰 1~3순위를 출력하세요.
