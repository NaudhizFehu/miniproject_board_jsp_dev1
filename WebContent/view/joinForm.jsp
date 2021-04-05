<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="join.do" method="post">
<!-- 아이디, 이름, 암호, 확인암호, 이메일, 전화번호  -->
<p>아이디 : <input type="text" id="id" value="${param.id}"></p>
<p>이름 : <input type="text" id="name" value="${param.name}"></p>
<p>암호 : <input type="password" id="password"></p>
<p>암호 확인 : <input type="password" id="confirmPassword"></p>
<p>이메일 : <input type="email" id="email"></p>
<p>폰번호 : <input type="text" id="phoneNumber"></p>
<input type="submit" value="회원가입">
</form>
</body>
</html>