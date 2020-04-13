<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
	<link rel="shortcut icon" type="image/x-icon" href="/resources/img/logo2.png" />
	<link rel="stylesheet" href="/resources/css/login.css">
	<script src="https://kit.fontawesome.com/7b5ecf7db0.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<script>
	function emailCheck() {

		var email = $("#email").val()

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

					alert("이미 가입된 이메일 입니다.")
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
	<div class = 'member'>
        <div class = 'member_container'>
			<h2>회원가입</h2>
<<<<<<< HEAD
	<form:form action="/postJoin" method="post" modelAttribute="memberVO">
		
	<form:hidden path="emailExist" />
		
	이메일 :
		
		<form:input type="text" path="email" onkeypress="resetEmailExist()" />
		
		<button type="button" id='overlap' onclick="emailCheck()">중복확인</button><br>
		
		<form:errors path="email" style="color:red" /><br><br>
		
	패스워드 :
		
		<form:password showPassword="true" path="passwd" /><br>
		
		<form:errors path="passwd" style="color:red" /><br><br>
		
	패스워드 확인 :
		
		<form:password showPassword="true" path="passwd2" /><br>
		
		<form:errors path="passwd2" style="color:red" /><br><br>
		
	성명 :
		
		<form:input type="text" path="username" maxlength="10" /><br>
		
		<form:errors path="username" style="color:red" /><br><br>
		
	닉네임 :
		
		<form:input type="text" path="nickname" /><br>
		
		<form:errors path="nickname" style="color:red" /><br><br>
		
	연락처 :
		
		<form:input type="text" path="phone" /><br>
		
		<form:errors path="phone" style="color:red" /><br><br>

		
		<form:button type="submit">회원가입</form:button>
		
		<input type="button" value="취소" onclick="location.href='/'" />
	
	</form:form>
=======
				<form:form action="/postJoin" method="post" modelAttribute="memberVO">
					<form:hidden path="emailExist" />
					이메일 : 
					<form:input type="text" path="email" onkeypress="resetEmailExist()" />
					<button type="button"  id='overlap' onclick="emailCheck()">중복확인</button><br>
					<form:errors path="email" style="color:red" /><br><br>
					패스워드 :
					<form:password showPassword="true" path="passwd" /><br>
					<form:errors path="passwd" style="color:red" /><br><br>
					패스워드 확인 :
					<form:password showPassword="true" path="passwd2" /><br>
					<form:errors path="passwd2" style="color:red" /><br><br>
					성명 :
					<form:input type="text" path="username" maxlength="10" /><br>
					<form:errors path="username" style="color:red" /><br><br>
					닉네임 :
					<form:input type="text" path="nickname" /><br>
					<form:errors path="nickname" style="color:red" /><br><br>
					연락처 :
					<form:input type="text" path="phone" /><br>
					<form:errors path="phone" style="color:red" /><br><br>
			
					<form:button type="submit">회원가입</form:button>
					<input type="button" value="취소" onclick="location.href='/'" />
				</form:form>
		</div>
	</div>
>>>>>>> 2ec96547f39a0deca83d244c8100249685012921
</body>

</html>