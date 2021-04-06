<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>

아이디 : ${param.id}<br/>
이름 :  ${param.name}<br/>
이메일 : ${param.email}&emsp;<a href=""><input type="button" value="이메일 변경하기"></a><br/>
전화번호 : ${param.phoneNumber1} - ${param.phoneNumber2} - ${param.phoneNumber3}
&emsp;<a href=""><input type="button" value="전화번호 변경하기"></a><br/>
<a href=""><input type="button" value="비밀번호 변경하기"></a>

</body>
</html>