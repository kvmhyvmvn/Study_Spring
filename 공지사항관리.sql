--������ ����
create table notice (
id            number constraint notice_id_pk primary key,
title         varchar2(300) not null /*����*/,
content       varchar2(4000)  not null /*����*/,
writer        varchar2(50)  not null /* �ۼ����� id */,
writedate     date default sysdate /* �ۼ����� */,
readcnt       number default 0 /*��ȸ��*/,
filename      varchar2(300)/*÷�����ϸ�*/,
filepath      varchar2(600)/*÷�����ϰ��*/,
root          number /* ��� ������ ���� id */,
step          number default 0/* �� ���� */,
indent        number default 0/* �鿩���� */,
rid           number constraint notice_rid_fk references notice(id) on delete cascade,
constraint notice_writer_fk foreign key(writer)
                       references member(userid)  on delete cascade
);

alter table notice add (
rid           number constraint notice_rid_fk references notice(id) on delete cascade
);

alter table notice add (
root          number /* ��� ������ ���� id */,
step          number default 0/* �� ���� */,
indent        number default 0/* �鿩���� */
);

select id, root, step, indent from notice
order by id desc;

update notice set root = id;
commit;

-- �ۼ��� id : hong
-- Ż���ϸ� member���� ȸ���� ����. - 
-- 1. writer�� null �ִ´� : writer �÷��� null�� ����ؾ� �Ѵ�
--    constraint�� �ɼ� ���� : on delete set null
-- 2. Ż���ڰ� �� ���� ���� : writer �÷��� null�� �����Ѵ�; not null
--    constraint �� �ɼ� ���� : on delete cascade

-- PK�� id �÷��� ������ ������ ����
create sequence seq_notice
start with 1 increment by 1 nocache;

-- notice �� PK�� id�� �������� �ڵ� �����ų Ʈ���� ����
create or replace trigger trg_notice
    before insert on notice
    for each row
begin
    select seq_notice.nextval into :new.id from dual;
    if ( :new.root is null) then
        /* ������ ��� root�� ���� �ֱ� ���� ó�� */
        select seq_notice.currval into :new.root from dual;
    else
        /* ����� ��� ������ ���� step ���� ó�� */
        update notice set step = step + 1
        where root = :old.root and step > :old.step;
    end if;
end;
/

insert into notice(id, title, content, writer)
values (seq_notice.nextval, '�׽�Ʈ ������', '�׽�Ʈ �������Դϴ�', 'su123');

insert into notice(title, content, writer)
values ('�ι�° ������', '�ι�° �׽�Ʈ �������Դϴ�', 'su123');

select * from notice;

select * from member;

commit;

select name, userid, admin from member;

update notice set writer = 'admin' where id = 1;

update notice
set writer = case when id=1 then 'admin1' when id = 2 then 'admin2' end;

select* from notice order by 1;
insert into notice(title, content, writer)
select title, content, writer from notice;

-- ������ ���� ��ȸ �ؿ� ������ �ش��ϴ� �÷� : rownum
select rownum, n.* from
(select n.*, name
from notice n inner join member m on n.writer = m.userid
order  by id) n
;

select row_number() over(order by id) no, n.*, name
from notice n inner join member m on n.writer = m.userid
order by no desc
;

delete from notice where mod(id, 5) = 0;
commit;

select count(*) from notice;


select *
from (select row_number() over(order by id) no, n.*, name
from notice n inner join member m on n.writer = m.userid) n
where no between 395 and 404
order by no desc
;

-- notice�� PK�� id �� �������� �ڵ� �����ų Ʈ���� ����
create or replace trigger trg_notice
    before insert on notice
    for each row
begin
    select seq_notice.nextval into :new.id from dual;
    if ( :new.root is null) then
        /* ������ ��� root�� ���� �ֱ� ���� ó�� */
        select seq_notice.currval into :new.root from dual;
    else
        update notice set step = step + 1
        where root = :new.root and step >= :new.step;
    end if;
end;
/

-- ���� ������ ��۵� ����ó��
create or replace trigger trg_notice_delete
    after delete on notice
    for each row
begin
    -- ������ ���� root�� ���� root�� ���������� ����
    delete from notice where root = :old.root;
end;
/


alter trigger trg_notice_delete disable; -- disable / enable

desc notice;

select * from notice;







