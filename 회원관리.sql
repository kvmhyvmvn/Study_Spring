drop table member;
-- ȸ������
create table member (
name           varchar2(50) not null, /* ȸ���� */
userid         varchar2(50) constraint member_userid_pk primary key, /* ���̵� */
userpw         varchar2(300) not null, /* ��й�ȣ */
gender         varchar2(3) default '��' not null, /*����*/
email          varchar2(50) not null, /* �̸��� */
profile        varchar2(300), /* �������̹��� */
birth          date, /* ������� */
phone          varchar2(13), /* ��ȭ��ȣ */
post           varchar2(5), /* �����ȣ */ 
address        varchar2(300), /* �ּ� */
admin          varchar2(1) default 'N' /* �����ڿ���: Y/N */
);

��й�ȣ ��ȣȭ : 1234 -> ahfdluq479843280adfhljhlaf : �����
         ��ȣȭ : ahfdluq479843280adfhljhlaf -> 1234
��й�ȣ ��ȣȭ�� �ܹ���         

select * from member;

delete from member;
commit;