<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <script src="https://kit.fontawesome.com/7b5ecf7db0.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/img/logo2.png" />
    <link rel="stylesheet" href="/resources/css/login.css?ver=0.2" />
</head>
<script>
	function emailCheck() {
		var email = $("#userId").val()
		if (email.length == 0) {
			alert("이메일을 입력해주세요.")
			return
		}
		$.ajax({
			url: "/user/emailCheck/" + email,
			type: "get",
			dataType: "text",
			success: function (result) {
				if (result.trim() == "true") {
					alert("사용할 수 있는 이메일 입니다.")
					$("#emailExist").val("true")
				} else {
					alert("이미 가입된 이메일 입니다.\n다른 메일 주소를 입력해주세요.")
					$("#emailExist").val("false")
				}
			}
		})
	}
	function resetEmailExist() {
		$("#emailExist").val("false")
	}
</script>
<body>
    <div class = "member">
        <div class = "member_container">
            <h2>회원가입</h2>
            <form:form action="/member/postSignup" method="post" modelAttribute="memberVO">
            <div>
            	<form:hidden path="emailExist" />
                <div>이메일</div>
                <form:input type="text" path="email" id="userId" placeholder="이메일 주소만 허용됩니다." onkeypress="resetEmailExist()" /><br>
                <button type="button" id="overlap" onclick="emailCheck()">중복확인</button>
                <form:errors path="email" style="color:red; display: inline-block; margin-left:200px; margin-top:10px" /><br><br>
                <div>패스워드</div>
                <form:password showPassword="true" path="passwd" placeholder="7 ~ 20자리로 입력해주세요." /><br>
                <form:errors path="passwd" style="color:red; display: inline-block; margin-left:140px; margin-top:10px" /><br><br>
                <div>패스워드 확인</div>
                <form:password showPassword="true" path="passwd2" id="userconfirm" placeholder = "7 ~ 20자리로 입력해주세요." /><br>
                <form:errors path="passwd2" style="color:red; display: inline-block; margin-left:140px; margin-top:10px" /><br><br>
                <div>성명</div>
                <form:input type="text" path="username" id="name" placeholder="한글/영문만 허용됩니다." /><br>
                <form:errors path="username" style="color:red; display: inline-block; margin-left:155px; margin-top:10px" /><br><br>
                <div>닉네임</div>
                <form:input type="text" path="nickname" id="nickname" placeholder="한글/영문/숫자만 허용됩니다." /><br>
                <form:errors path="nickname" style="color:red; display: inline-block; margin-left:150px; margin-top:10px" /><br><br>
                <div>휴대폰 번호</div>
                <form:input type="text" path="phone" id="hp" placeholder="Ex) 010-1234-5678" /><br>
                <form:errors path="phone" style="color:red; display: inline-block; margin-left:140px; margin-top:10px" /><br><br>
            </div>
            <div>
            	<form:button type="submit" id="signup">가입하기</form:button>
            </div>
            </form:form>
        </div>
    </div>
    <script src="/resources/js/member_join.js"></script>
</body>