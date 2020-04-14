<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<script>
	function emailCheck() {
		
		var email = $("#email").val()
		
		if(email.length == 0) {
			
			alert("이메일을 입력해주세요.")
			return
		}
		
		$.ajax({
			url : "/user/emailCheck/" + email,
			type : "get",
			dataType : "text",
			success : function(result) {
				if(result.trim() == "true") {
					
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
	<h1>정보수정</h1>
		<form:form action="/postModify" method="post" modelAttribute="modifyMember">
			이메일 : <form:input type="text" path="email" readonly="true"/><br><br>
			패스워드 : <form:password showPassword="true" path="passwd" /><br>
						<form:errors path="passwd" style="color:red" /><br>
			패스워드 확인 : <form:password showPassword="true" path="passwd2" /><br>
						<form:errors path="passwd2" style="color:red" /><br>
			성명 : <form:input type="text" path="username" readonly="true" /><br><br>
			닉네임 : <form:input type="text" path="nickname" /><br>
						<form:errors path="nickname" style="color:red" /><br>
			연락처 : <form:input type="text" path="phone" /><br>
						<form:errors path="phone" style="color:red" /><br>
			
			<form:button type="submit">정보수정</form:button>
			<input type="button" value="취소" onclick="location.href='/'" />
		</form:form>
</body>
</html>