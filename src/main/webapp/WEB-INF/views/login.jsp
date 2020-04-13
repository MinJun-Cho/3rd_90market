<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/resources/css/login.css" >
</head>
<body>
	<div class=login>
	    <div class="login_container">
	        <h2>로그인</h2>
	        <c:if test="${fail == true}">
	                    로그인에 실패하였습니다. 이메일 또는 패스워드를 확인해주세요.
	                </c:if><br>
	        <form:form action="/postLogin" method="post" modelAttribute="tempLoginMember">
	            <div>
	                <div class="name">Email</div>
	                <div>
	                	<form:input type="text" path="email" placeholder="가입하셨던 이메일을 입력하세요" /><br>
	                    <div class="error">
	                    <form:errors path="email" style="color:red" />
	                    </div>
	                </div>
	                <div class="name">Password</div>
	                <div>
	                    <form:password showPassword="true" path="passwd" placeholder="비밀번호를 입력하세요" /><br>
	                    <div class="error">
	                    <form:errors path="passwd" style="color:red" />
	                    </div>
	                </div>
	            </div>
	            <div class='btn'>
	                <button class='btn1'>
	                    네이버로 로그인 하기
	                </button>
	                <button class='btn2'>
	                    카카오톡으로 로그인 하기
	                </button>
	            </div>
	            <div class="loginbtn">
	                <form:button type="submit" class='btn3'>LOGIN</form:button>
	            </div>
	            <div id="join">
	                <div>아직 계정이 없으세요?<a href="join">회원가입하기</a></div>
	            </div>
	        </form:form>
	    </div>
	</div>
</body>
</html>