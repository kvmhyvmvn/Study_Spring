select count(*) from employees;

-- select ���� group �Լ��� ����� ǥ���� �ִ� ���,
-- group �Լ��� ������ ���� ��� ǥ���� ���ؼ��� group by�� �������� ��õǾ�� �Ѵ�.

select e.department_id, count(*) count, nvl(d.department_name, '�ҼӾ���') department_name
from employees e left outer join departments d on e.department_id = d.department_id
group by e.department_id, d.department_name
order by e.department_id;

select count(*) from departments;

select to_char(hire_date, 'YYYY')||'��' �⵵��, count(employee_id) ����� from employees
group by to_char(hire_date, 'YYYY')
order by 1;

select to_char(hire_date, 'MM')||'��' ����, count(employee_id) �Ի� from employees
group by to_char(hire_date, 'MM')
order by 1;

-- ������� ���� ���� 3�� �μ�
select * from (select dense_rank() over(order by count(*) desc) rank, department_id, count(employee_id) count
               from employees
               group by department_id) e
where rank <= 3;


select rank, department_id, '(TOP' || rank || ')'|| department_name department_name
from (select dense_rank() over(order by count(*) desc) rank, department_id, count(employee_id) count
               from employees
               group by department_id) e left outer join departments d using(department_id)
where rank <= 3;

-- �� �μ��� ���ؼ��� ���� ä�� �ο��� ��ȸ
select department_name, to_char(hire_date, 'mm') unit
from employees e inner join
        (select rank, department_id, '(TOP' || rank || ')'|| department_name department_name
            from (select dense_rank() over(order by count(*) desc) rank, department_id, count(employee_id) count
                    from employees
                    group by department_id) e left outer join departments d using(department_id)
        where rank <= 3) r using(department_id);
        
-- ���� �������� --> ���ε����������� ����: pivot
-- select �÷�
-- from (���̺�, �ζ��κ伭�������κ��� �����͸� ��ȸ�ϴ� select)
-- pivot(�����Լ�(ǥ����) for �ǹ�����÷� in (������ �ø� ��))

select 5 "01��", 10 "02��", 20 "03��", 15 "04��", 3 "05��", 0 "06��",
       3 "07��", 2 "08��", 10 "09��", 3 "10��", 5 "11��", 2 "12��"
from dual;

-- ���� �̷���� ���������� ������ ��ȯ
select * from (select 5 "01��", 10 "02��", 20 "03��", 15 "04��", 3 "05��", 0 "06��",
                3 "07��", 2 "08��", 10 "09��", 3 "10��", 5 "11��", 2 "12��"
               from dual)
unpivot (cnt for mm in ("01��", "02��", "03��", "04��", "05��", "06��", "07��", "08��", "09��", "10��", "11��", "12��"));

-- ������ �̷���� ���������� ���� ��ȯ
select *
from (select * from (select 5 "01��", 10 "02��", 20 "03��", 15 "04��", 3 "05��", 0 "06��",
                3 "07��", 2 "08��", 10 "09��", 3 "10��", 5 "11��", 2 "12��"
               from dual)
     unpivot (cnt for mm in ("01��", "02��", "03��", "04��", "05��", "06��", "07��", "08��", "09��", "10��", "11��", "12��"))
    )
pivot (sum(cnt) for mm in ('01��', '02��', '03��', '04��', '05��', '06��', '07��', '08��', '09��', '10��', '11��', '12��') );

-- �Ի���� �����
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
     pivot(count(*) for unit in ('01' "01��", '02' "02��", '03' "03��", '04' "04��", '05' "05��", '06' "06��", '07' "07��", '08' "08��", '09' "09��", '10' "10��", '11' "11��", '12' "12��"))
order by department_name;
        





