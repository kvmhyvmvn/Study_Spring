-- khm
create table khm (
id          number constraint khm_id_pk primary key,
title       varchar2(300) not null /* 제목 */,
content     varchar2(4000) not null /* 내용 */,
writer      varchar2(50) not null /* 작성자의 id */,
writedate   date default sysdate /* 작성일자 */,
readcnt     number default 0 /* 조회수 */
);

create sequence seq_khm start with 1 increment by 1 nocache;

create or replace trigger trg_khm
    before insert on khm
    for each row
begin
    select seq_khm.nextval into :new.id from dual;
end;
/

-- 게시글에 첨부하는 파일 관리
create table khm_file (
id      number constraint khm_file_id_pk primary key,
khm_id  number constraint khm_file_fk
                            references khm(id) on delete cascade,
filename varchar2(300) /* 첨부파일명 */,
filepath varchar2(600) /* 첨부파일경로 */
);

create sequence seq_khm_file start with 1 increment by 1 nocache;

create or replace trigger trg_khm_file
    before insert on khm_file
    for each row
begin
    select seq_khm_file.nextval into : new.id from dual;
end;
/

-- 글에 대한 댓글 관리(오류남 수정해)
create table khm_comment (
id      number constraint khm_comment_id_pk primary key,
content varchar2(1000) not null /* 댓글 내용 */,
writer  varchar2(50) not null /* 글쓴이 아이디 */,
writedate date default sysdate /* 작성 일자 */,
khm_id number /* 방명록 글의 pk인 id */,
constraint khm_comment_writer_fk foreign key(writer)
                references member(userid) on delete cascade,
constraint khm_comment_khm_id_fk foreign key(khm_id)
                references khm(id) on delete cascade
);




