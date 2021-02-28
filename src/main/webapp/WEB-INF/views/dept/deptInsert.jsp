<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptInsert.jsp</title>
<style>
div {
	display: inline-block;
}

.insertDept {
	position: absolute;
	top: 10px;
	padding: 10px;
}
</style>
</head>
<body>
	<form action="deptInsert" method="post">
		<div>
			<table border="1">
				<tr>
					<td>부서 번호</td>
					<td>부서 이름</td>
				</tr>
				<c:forEach var="dept" items="#{list }">
					<tr>
						<td>${dept.department_id }</td>
						<td>${dept.department_name }</td>
					</tr>
				</c:forEach>
			</table>

		</div>	

		<div class="insertDept">
			<h4>등록</h4>
			부서 번호<input type="text" name="department_id" value=""> 
			부서 이름<input type="text" name="department_name" value="">
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>