<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="login.do" method="post">
<p>아이디 : <input type="text" name="id" value="${param.id}"></p>
<p>비밀번호 : <input type="password" name="password"></p>
<input type="submit" value="로그인">&emsp;
<a href="join.do"><input type="button" value="회원가입" /></a>

</form>
</body>
</html>