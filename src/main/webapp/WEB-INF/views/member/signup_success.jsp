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
	<p>${memberVO.username}님, 환영합니다!</p>
	<p>구공마켓에 가입해주셔서 감사합니다.</p>
	<input type="button" value="메인" onclick="location.href='/'" />
</body>
</html>