-- khm
create table khm (
id          number constraint khm_id_pk primary key,
title       varchar2(300) not null /* ���� */,
content     varchar2(4000) not null /* ���� */,
writer      varchar2(50) not null /* �ۼ����� id */,
writedate   date default sysdate /* �ۼ����� */,
readcnt     number default 0 /* ��ȸ�� */
);

create sequence seq_khm start with 1 increment by 1 nocache;

create or replace trigger trg_khm
    before insert on khm
    for each row
begin
    select seq_khm.nextval into :new.id from dual;
end;
/

-- �Խñۿ� ÷���ϴ� ���� ����
create table khm_file (
id      number constraint khm_file_id_pk primary key,
khm_id  number constraint khm_file_fk
                            references khm(id) on delete cascade,
filename varchar2(300) /* ÷�����ϸ� */,
filepath varchar2(600) /* ÷�����ϰ�� */
);

create sequence seq_khm_file start with 1 increment by 1 nocache;

create or replace trigger trg_khm_file
    before insert on khm_file
    for each row
begin
    select seq_khm_file.nextval into : new.id from dual;
end;
/

-- �ۿ� ���� ��� ����(������ ������)
create table khm_comment (
id      number constraint khm_comment_id_pk primary key,
content varchar2(1000) not null /* ��� ���� */,
writer  varchar2(50) not null /* �۾��� ���̵� */,
writedate date default sysdate /* �ۼ� ���� */,
khm_id number /* ���� ���� pk�� id */,
constraint khm_comment_writer_fk foreign key(writer)
                references member(userid) on delete cascade,
constraint khm_comment_khm_id_fk foreign key(khm_id)
                references khm(id) on delete cascade
);




