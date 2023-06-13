-- 회원관리
create table member (
name           varchar2(50), /* 회원명 */
userid         varchar2(50), /* 아이디 */
userpw         varchar2(300), /* 비밀번호 */
gender         varchar2(3) default '남' not null, /*성별*/
email          varchar2(50), /* 이메일 */
profile        varchar2(300), /* 프로필이미지 */
birth          date, /* 생년월일 */
phone          varchar2(13), /* 전화번호 */
post           varchar2(5), /* 우편번호 */ 
address        varchar2(300), /* 주소 */
admin          varchar2(1) default 'N' /* 관리자여부: Y/N */
);