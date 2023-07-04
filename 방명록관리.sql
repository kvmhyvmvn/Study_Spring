-- ���� ����
create table board (
id            number constraint board_id_pk primary key,
title         varchar2(300) not null /*����*/,
content       varchar2(4000)  not null /*����*/,
writer        varchar2(50)  not null /* �ۼ����� id */,
writedate     date default sysdate /* �ۼ����� */,
readcnt       number default 0 /*��ȸ��*/
);

create sequence seq_board start with 1 increment by 1 nocache;

create or replace trigger trg_board
    before insert on board
    for each row
begin
    select seq_board.nextval into :new.id from dual;
end;
/

-- ���Ͽ� ÷���ϴ� ���ϰ���
create table board_file(
id          number constraint board_file_id_pk primary key,
board_id    number constraint board_file_fk 
                             references board(id) on delete cascade,
filename    varchar2(300)/* ÷�����ϸ� */,
filepath    varchar2(600)/* ÷�����ϰ�� */
);

create sequence seq_board_file start with 1 increment by 1 nocache;

create or replace trigger trg_board_file
    before insert on board_file
    for each row
begin
    select seq_board_file.nextval into :new.id from dual;
end;
/

select * from board;

insert into board(title, content, writer)
select title, content, writer from board;

commit;

select (select count(*) from board_file where b.id=board_id) filecnt, b.* 
from (select row_number() over(order by id) no, b.*, name  
	  from board b inner join member m  on b.writer = m.userid) b
order by no desc
;



