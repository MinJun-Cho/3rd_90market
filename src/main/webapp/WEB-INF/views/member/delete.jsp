<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 탈퇴</title>
    <script src="https://kit.fontawesome.com/7b5ecf7db0.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/img/logo2.png" />
    <link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
    <div class="member">
        <div class="member_container">
            <h2>회원탈퇴</h2>
            <form:form action="/member/postDelete" method="post" modelAttribute="deleteMember">
            <div>
                <div>이메일</div>
                <form:input type="text" path="email" id ="userId" readonly="true"/><br>
                <div>패스워드</div>
                <form:password showPassword="true" path="passwd" id ="password" placeholder = "7 ~ 20자리로 입력해주세요." /><br>
                <form:errors path="passwd" style="color:red; display: inline-block; margin-left:140px; margin-top:10px" /><br><br>
            </div>
            <div>
                <form:button type="submit" id="signup">회원탈퇴</form:button>
            </div>
            </form:form>
        </div>
    </div>
    
</body>