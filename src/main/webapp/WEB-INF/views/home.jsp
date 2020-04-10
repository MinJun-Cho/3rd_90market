<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>메인</h1>
	<c:choose>
		<c:when test="${loginMember.memberLogin == true}">
	<input type="button" value="정보수정" onclick="location.href='/modify'" />
	<input type="button" value="로그아웃" onclick="location.href='/logout'" />
		</c:when>
		<c:otherwise>
	<input type="button" value="회원가입" onclick="location.href='/join'" />
	<input type="button" value="로그인" onclick="location.href='/login'" />
		</c:otherwise>
	</c:choose>
	<input type="button" value="상품 정보" onclick="location.href='/product'" />
</body>
</html>
