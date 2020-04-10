<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인</h1>
		<form:form action="/postLogin" method="post" modelAttribute="tempLoginMember">
			<p>이메일 : <form:input type="text" path="email" /></p>
						<form:errors path="email" style="color:red" />
			<p>패스워드 : <form:password showPassword="true" path="passwd" /></p>
						<form:errors path="passwd" style="color:red" />
			<c:if test="${fail == true}">
				로그인에 실패하였습니다. 이메일 또는 패스워드를 확인해주세요.
			</c:if><br>
			<form:button type="submit">로그인</form:button>
			<input type="button" value="메인" onclick="location.href='/'" />
		</form:form>
</body>
</html>