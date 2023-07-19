select count(*) from employees;

-- select 절에 group 함수를 사용한 표현이 있는 경우,
-- group 함수가 사용되지 않은 모든 표현에 대해서는 group by의 기준으로 명시되어야 한다.

select e.department_id, count(*) count, nvl(d.department_name, '소속없음') department_name
from employees e left outer join departments d on e.department_id = d.department_id
group by e.department_id, d.department_name
order by e.department_id;

select count(*) from departments;

select to_char(hire_date, 'YYYY')||'년' 년도별, count(employee_id) 사원수 from employees
group by to_char(hire_date, 'YYYY')
order by 1;

select to_char(hire_date, 'MM')||'월' 월별, count(employee_id) 입사 from employees
group by to_char(hire_date, 'MM')
order by 1;

-- 사원수가 많은 상위 3위 부서
select * from (select dense_rank() over(order by count(*) desc) rank, department_id, count(employee_id) count
               from employees
               group by department_id) e
where rank <= 3;


select rank, department_id, '(TOP' || rank || ')'|| department_name department_name
from (select dense_rank() over(order by count(*) desc) rank, department_id, count(employee_id) count
               from employees
               group by department_id) e left outer join departments d using(department_id)
where rank <= 3;

-- 위 부서에 대해서만 월별 채용 인원수 조회
select department_name, to_char(hire_date, 'mm') unit
from employees e inner join
        (select rank, department_id, '(TOP' || rank || ')'|| department_name department_name
            from (select dense_rank() over(order by count(*) desc) rank, department_id, count(employee_id) count
                    from employees
                    group by department_id) e left outer join departments d using(department_id)
        where rank <= 3) r using(department_id);
        
-- 세로 데이터행 --> 가로데이터행으로 변경: pivot
-- select 컬럼
-- from (테이블, 인라인뷰서브쿼리로부터 데이터를 조회하는 select)
-- pivot(집계함수(표현식) for 피벗대상컬럼 in (행으로 올릴 열))

select 5 "01월", 10 "02월", 20 "03월", 15 "04월", 3 "05월", 0 "06월",
       3 "07월", 2 "08월", 10 "09월", 3 "10월", 5 "11월", 2 "12월"
from dual;

-- 열로 이루어진 데이터행을 행으로 변환
select * from (select 5 "01월", 10 "02월", 20 "03월", 15 "04월", 3 "05월", 0 "06월",
                3 "07월", 2 "08월", 10 "09월", 3 "10월", 5 "11월", 2 "12월"
               from dual)
unpivot (cnt for mm in ("01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"));

-- 행으로 이루어진 데이터행을 열로 변환
select *
from (select * from (select 5 "01월", 10 "02월", 20 "03월", 15 "04월", 3 "05월", 0 "06월",
                3 "07월", 2 "08월", 10 "09월", 3 "10월", 5 "11월", 2 "12월"
               from dual)
     unpivot (cnt for mm in ("01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"))
    )
pivot (sum(cnt) for mm in ('01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월') );

-- 입사월별 사원수
select *
from (select to_char(hire_date, 'mm') mm from employees)
pivot(count(*) for mm in ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'))
;

select *
from (select department_name, to_char(hire_date, 'mm') unit
      from employees e inner join
        (select rank, department_id, '(TOP' || rank || ')'|| department_name department_name
         from (select dense_rank() over(order by count(*) desc) rank, department_id, count(employee_id) count
                    from employees
                    group by department_id) e left outer join departments d using(department_id)
               where rank <= 3) r using(department_id)
     )
     pivot(count(*) for unit in ('01' "01월", '02' "02월", '03' "03월", '04' "04월", '05' "05월", '06' "06월", '07' "07월", '08' "08월", '09' "09월", '10' "10월", '11' "11월", '12' "12월"))
order by department_name;
        





