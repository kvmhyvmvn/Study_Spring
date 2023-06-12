select * from customer;

-- 시퀀셜한 숫자값을 자동으로 만들어내는 기능을 가진 객체 : sequence
create sequence seq_customer
start with 7 increment by 1 nocache;
insert into customer(id, name)
values (seq_customer.nextval, '박문수');

-- 시퀀스 자동적용 시키는 기능을 처리할 객체: trigger
create trigger trg_customer
    before insert on customer
    for each row
begin
    select seq_customer.nextval into :new.id from dual;
end;
/

insert into customer(name)
values('심청');

commit;

select * from customer
order by id;

-- ================ 사원관리 ===================

select employee_id, last_name||' '||first_name name, e.department_id,
		department_name
		, job_id, job_title, hire_date
		from departments d right outer join employees e on
		e.department_id=d.department_id
		inner join jobs j using(job_id)
where e.department_id is null
order by employee_id;

alter trigger update_job_history disable;

-- 관리자로 있는 사원정보
select distinct manager_id from employees order by 1;
-- FK인 constraint명이 EMP_MANAGER_FK
-- references 되는 부모행이 삭제될 때 컬럼의 정보에 null로 변경
-- 원래있던 constraint를 삭제
alter table employees drop constraint emp_manager_fk;
-- 조건지정한 constraint를 지정
alter table employees add constraint emp_manager_fk foreign key(manager_id) references employees(employee_id) on delete set null;

-- 원래있던 constraint를 삭제
alter table job_history drop constraint JHIST_EMP_FK;
-- 조건 지정한 constraint를 지정
alter table job_history add constraint jhist_emp_fk foreign key(employee_id) references employees(employee_id) on delete cascade;

-- 원래있던 constraint를 삭제
alter table departments drop constraint DEPT_MGR_FK;
-- 조건 지정한 constraint를 지정
alter table departments add constraint DEPT_MGR_FK foreign key(manager_id) references employees(employee_id) on delete set null;

select employees_seq.currval from dual;











