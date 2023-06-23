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
constraint notice_writer_fk foreign key(writer)
                       references member(userid)  on delete cascade
);

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
create trigger trg_notice
    before insert on notice
    for each row
begin
    select seq_notice.nextval into :new.id from dual;
end;
/

insert into notice(id, title, content, writer)
values (seq_notice.nextval, '테스트 공지글', '테스트 공지글입니다', 'su123');

insert into notice(title, content, writer)
values ('두번째 공지글', '두번째 테스트 공지글입니다', 'su123');

select * from notice;

select * from member;

commit;