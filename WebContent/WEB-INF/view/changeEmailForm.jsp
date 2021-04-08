<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 변경하기</title>
</head>
<body>
<form action="changeEmail.do" method="post">
<p>새로운 이메일 : <input type="email" name="newEmail"></p>
<c:choose>
<c:when test="${errors.blankNewEmail}">새로운 이메일을 입력해주세요.</c:when>
<c:when test="${errors.notEmail}">email 양식에 맞지 않습니다. 다시 입력해주세요.</c:when>
</c:choose>
<p><input type="submit" value="이메일 변경하기">&emsp;<a href="myInfo.do"><input type="button" value="변경 취소하기"></a></p>
</form>
</body>
</html>