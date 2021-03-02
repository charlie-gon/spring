<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="dept" items="${list }">
		<table border="1">
			<tr>
				<td>${dept }</td>
			</tr>
		</table>
	</c:forEach>
	
<!-- 확인 방법: spring 실행 후 서블릿 이름 삽입(empList) /http://localhost/yedam/deptList -->
</body>
</html>