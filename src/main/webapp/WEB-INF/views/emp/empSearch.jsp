<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$('.btnSelect').on('click',function(){
			var empid = $(this).closest('div').find('span').eq(0).html();
			var firstName ="$('.row').children().eq(1).html()";
			opener.document.frm.manager_id=empid;
			$(opener.document).find('[name=manager_id]').val(empid);
			window.close();
		});
	});
</script>
</head>
<body>
	<h3>사원검색</h3>
	<c:forEach var="emp" items="${list }">
		<div class="row">
			<span>${emp.employee_id }</span>
			<span>${emp.first_name }</span>
			<span>${emp.last_name }</span>
			<span>${emp.email }</span>
			<span><button type="button" class="btnSelect">선택</button></span>
		</div>
	</c:forEach>
</body>
</html>