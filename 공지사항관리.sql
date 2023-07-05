--공지글 관리
create table notice (
id            number constraint notice_id_pk primary key,
title         varchar2(300) not null /*제목*/,
content       varchar2(4000)  not null /*내용*/,
writer        varchar2(50)  not null /* 작성자의 id */,
writedate     date default sysdate /* 작성일자 */,
readcnt       number default 0 /*조회수*/,
filename      varchar2(300)/*첨부파일명*/,
filepath      varchar2(600)/*첨부파일경로*/,
root          number /* 답글 관리를 위한 id */,
step          number default 0/* 글 순서 */,
indent        number default 0/* 들여쓰기 */,
rid           number constraint notice_rid_fk references notice(id) on delete cascade,
constraint notice_writer_fk foreign key(writer)
                       references member(userid)  on delete cascade
);

alter table notice add (
rid           number constraint notice_rid_fk references notice(id) on delete cascade
);

alter table notice add (
root          number /* 답글 관리를 위한 id */,
step          number default 0/* 글 순서 */,
indent        number default 0/* 들여쓰기 */
);

select id, root, step, indent from notice
order by id desc;

update notice set root = id;
commit;

-- 작성자 id : hong
-- 탈퇴하면 member에는 회원이 없다. - 
-- 1. writer에 null 넣는다 : writer 컬럼은 null을 허용해야 한다
--    constraint에 옵션 지정 : on delete set null
-- 2. 탈퇴자가 쓴 글은 삭제 : writer 컬럼은 null을 불허한다; not null
--    constraint 에 옵션 지정 : on delete cascade

-- PK인 id 컬럼에 적용할 시퀀스 생성
create sequence seq_notice
start with 1 increment by 1 nocache;

-- notice 의 PK인 id에 시퀀스를 자동 적용시킬 트리거 생성
create or replace trigger trg_notice
    before insert on notice
    for each row
begin
    select seq_notice.nextval into :new.id from dual;
    if ( :new.root is null) then
        /* 원글인 경우 root에 값을 넣기 위한 처리 */
        select seq_notice.currval into :new.root from dual;
    else
        /* 답글인 경우 순서를 위한 step 변경 처리 */
        update notice set step = step + 1
        where root = :old.root and step > :old.step;
    end if;
end;
/

insert into notice(id, title, content, writer)
values (seq_notice.nextval, '테스트 공지글', '테스트 공지글입니다', 'su123');

insert into notice(title, content, writer)
values ('두번째 공지글', '두번째 테스트 공지글입니다', 'su123');

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

-- 데이터 행을 조회 해온 순서에 해당하는 컬럼 : rownum
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

-- notice의 PK인 id 에 시퀀스를 자동 적용시킬 트리거 생성
create or replace trigger trg_notice
    before insert on notice
    for each row
begin
    select seq_notice.nextval into :new.id from dual;
    if ( :new.root is null) then
        /* 원글인 경우 root에 값을 넣기 위한 처리 */
        select seq_notice.currval into :new.root from dual;
    else
        update notice set step = step + 1
        where root = :new.root and step >= :new.step;
    end if;
end;
/

-- 원글 삭제시 답글들 삭제처리
create or replace trigger trg_notice_delete
    after delete on notice
    for each row
begin
    -- 삭제한 글의 root와 같은 root인 데이터행을 삭제
    delete from notice where root = :old.root;
end;
/


alter trigger trg_notice_delete disable; -- disable / enable

desc notice;

select * from notice;







