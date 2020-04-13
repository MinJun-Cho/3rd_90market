<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <script src="https://kit.fontawesome.com/7b5ecf7db0.js" crossorigin="anonymous"></script>
    <link rel="shortcut icon" type="image/x-icon" href="img/logo2.png" />
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
	<form action="" method="POST">
        <div class=login>
            <div class="login_container">
                <h2>로그인</h2>
                <form:form action="/postLogin" method="post" modelAttribute="tempLoginMember">
                    <div>
                        <div class="name">E.mail</div>
                        <div>
                            <form:input type="text" path="email" placeholder="가입하셨던 이메일을 입력하세요">
                        </div>
                        <div class="name">Password</div>
                        <div>
                            <form:password showPassword="true" path="passwd" placeholder="비밀번호를 입력하세요">
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
                        <c:if test="${fail == true}">
                            로그인에 실패하였습니다. 이메일 또는 패스워드를 확인해주세요.
                        </c:if><br>
                        <form:button type="submit" class='btn3'>LOGIN</form:button>
                    </div>
                    <div id="join">
                        <div>아직 계정이 없으세요?<a href="member_ join.html">회원가입하기</a></div>
                    </div>
                </form:form>
            </div>
        </div>
</body>
</html>