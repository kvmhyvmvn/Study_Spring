-- ȸ������
create table member (
name           varchar2(50), /* ȸ���� */
userid         varchar2(50), /* ���̵� */
userpw         varchar2(300), /* ��й�ȣ */
gender         varchar2(3) default '��' not null, /*����*/
email          varchar2(50), /* �̸��� */
profile        varchar2(300), /* �������̹��� */
birth          date, /* ������� */
phone          varchar2(13), /* ��ȭ��ȣ */
post           varchar2(5), /* �����ȣ */ 
address        varchar2(300), /* �ּ� */
admin          varchar2(1) default 'N' /* �����ڿ���: Y/N */
);