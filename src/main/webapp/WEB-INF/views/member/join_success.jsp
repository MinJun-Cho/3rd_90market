<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<h1>회원가입 성공</h1>
	이메일 : ${memberVO.email}<br>
	<input type="button" value="메인" onclick="location.href='/'" />
</body>
</html>