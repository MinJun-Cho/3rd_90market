<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	alert("인증된 사용자만 접근 가능합니다.\n로그인 후 다시 시도해주세요.")
	location.href="/auth/login"
</script>
</head>
</html>