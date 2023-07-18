select count(*) from employees;

-- select ���� group �Լ��� ����� ǥ���� �ִ� ���,
-- group �Լ��� ������ ���� ��� ǥ���� ���ؼ��� group by�� �������� ��õǾ�� �Ѵ�.

select e.department_id, count(*) count, nvl(d.department_name, '�ҼӾ���') department_name
from employees e left outer join departments d on e.department_id = d.department_id
group by e.department_id, d.department_name
order by e.department_id;

select count(*) from departments;