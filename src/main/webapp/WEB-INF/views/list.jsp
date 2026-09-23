<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
		<tr>
			<th colspan="5">Students</th>
		</tr>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>kor</th>
			<th>eng</th>
			<th>math</th>
		</tr>

		<c:forEach var="i" items="${lists}">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.kor}</td>
				<td>${i.eng}</td>
				<td>${i.math}</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="5"><form action="/student/update">
					<input type="text" name="id" placeholder="수정할 대상 학생 id"><br>
					<input type="text" name="name" placeholder="name"><br>
					<input type="text" name="kor" placeholder="kor">
						<input type="text" name="eng" placeholder="eng">
							<input type="text" name="math" placeholder="math">
					<button type="submit">수정</button>
				</form></td>
		<tr>
			<td colspan="5"><form action="student/delete/">
					<input type="text" name="id" placeholder="삭제할 id를 입력하세요.">
					<button type="submit">삭제</button>
				</form></td>
		</tr>
		<tr>
			<td colspan="5" align="center">

				<form action="/student/home">
					<button>Home</button>
				</form>
			</td>
		</tr>
	</table>

</body>
</body>
</html>