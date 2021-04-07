<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.do">
<p>아이디 : <input type="text" id="id" value="${param.id}"></p>
<p>비밀번호 : <input type="password" id="password"></p>
<input type="submit" value="로그인">&emsp;
<a href="joinForm.jsp"><input type="button" value="회원가입" /></a>

</form>
</body>
</html>