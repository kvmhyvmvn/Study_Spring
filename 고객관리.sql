select * from customer;

-- �������� ���ڰ��� �ڵ����� ������ ����� ���� ��ü : sequence
create sequence seq_customer
start with 7 increment by 1 nocache;
insert into customer(id, name)
values (seq_customer.nextval, '�ڹ���');

-- ������ �ڵ����� ��Ű�� ����� ó���� ��ü: trigger
create trigger trg_customer
    before insert on customer
    for each row
begin
    select seq_customer.nextval into :new.id from dual;
end;
/

insert into customer(name)
values('��û');

commit;

select * from customer
order by id;

-- ================ ������� ===================

select employee_id, last_name||' '||first_name name, e.department_id,
		department_name
		, job_id, job_title, hire_date
		from departments d right outer join employees e on
		e.department_id=d.department_id
		inner join jobs j using(job_id)
where e.department_id is null
order by employee_id;

alter trigger update_job_history disable;

-- �����ڷ� �ִ� �������
select distinct manager_id from employees order by 1;
-- FK�� constraint���� EMP_MANAGER_FK
-- references �Ǵ� �θ����� ������ �� �÷��� ������ null�� ����
-- �����ִ� constraint�� ����
alter table employees drop constraint emp_manager_fk;
-- ���������� constraint�� ����
alter table employees add constraint emp_manager_fk foreign key(manager_id) references employees(employee_id) on delete set null;

-- �����ִ� constraint�� ����
alter table job_history drop constraint JHIST_EMP_FK;
-- ���� ������ constraint�� ����
alter table job_history add constraint jhist_emp_fk foreign key(employee_id) references employees(employee_id) on delete cascade;

-- �����ִ� constraint�� ����
alter table departments drop constraint DEPT_MGR_FK;
-- ���� ������ constraint�� ����
alter table departments add constraint DEPT_MGR_FK foreign key(manager_id) references employees(employee_id) on delete set null;

select employees_seq.currval from dual;











