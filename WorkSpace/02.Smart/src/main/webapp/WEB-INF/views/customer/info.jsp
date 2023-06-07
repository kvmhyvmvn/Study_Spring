<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 class="my-4">고객정보</h3>
	<table class="tb-row">
		<colgroup>
			<col width="180px">
			<col>
		</colgroup>
		<tr>
			<th>고객명</th>
			<td>${vo.name }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${vo.gender }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${vo.email }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${vo.phone }</td>
		</tr>
	</table>

	<div class="btn-toolbar gap-2 my-3 justify-content-center">
		<button class="btn btn-primary" onclick="loation='list.cu'">고객목록</button>
		<button class="btn btn-warning"
			onclick="location='modify.cu?id=${vo.id}'">정보수정</button>
		<button class="btn btn-danger"
			onclick="if(confirm('정말 삭제?') ) location='delete.cu?id=${vo.id}'">정보삭제</button>
	</div>

</body>
</html>