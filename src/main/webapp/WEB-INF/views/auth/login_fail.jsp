<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	alert("로그인에 실패하였습니다.\n이메일 또는 패스워드를 확인해주세요!")
	location.href="/login?fail=true"
</script>
</head>
</html>