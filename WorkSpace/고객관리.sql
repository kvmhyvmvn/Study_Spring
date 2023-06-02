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