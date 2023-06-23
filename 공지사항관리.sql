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
constraint notice_writer_fk foreign key(writer)
                       references member(userid)  on delete cascade
);

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
create trigger trg_notice
    before insert on notice
    for each row
begin
    select seq_notice.nextval into :new.id from dual;
end;
/

insert into notice(id, title, content, writer)
values (seq_notice.nextval, '�׽�Ʈ ������', '�׽�Ʈ �������Դϴ�', 'su123');

insert into notice(title, content, writer)
values ('�ι�° ������', '�ι�° �׽�Ʈ �������Դϴ�', 'su123');

select * from notice;

select * from member;

commit;