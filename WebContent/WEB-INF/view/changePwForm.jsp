<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
<form action="changePw.do" method="post">
<p>현재 비밀번호 : <input type="password" name="curPw"></p>
<c:choose>
<c:when test="${errors.blankCurPw}">현재 비밀번호를 입력해주세요.</c:when>
<c:when test="${errors.wrongCurPw}">현재 비밀번호가 일치하지 않습니다.</c:when>
</c:choose>
<p>새로운 비밀번호 : <input type="password" name="newPw"></p>
<c:choose>
<c:when test="${errors.blankNewPw}">새로운 비밀번호를 입력해주세요.</c:when>
<c:when test="${errors.notPassword}">비밀번호는 6~20자 사이로 입력해주세요.</c:when>
</c:choose>
<p><input type="submit" value="비밀번호 변경하기">&emsp;<a href="myInfo.do"><input type="button" value="변경 취소하기"></a></p>
</form>
</body>
</html>