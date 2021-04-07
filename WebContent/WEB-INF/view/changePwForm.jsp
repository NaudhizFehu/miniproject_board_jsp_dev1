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
<form action="changePw.do">
<p>현재 비밀번호 : <input type="password" id="curPw"></p>
<c:choose>
<c:when test="${errors.blankCurPw}">현재 비밀번호를 입력해주세요.</c:when>
<c:when test="${errors.wrongCurPw}">현재 비밀번호가 일치하지 않습니다.</c:when>
</c:choose>
<p>새로운 비밀번호 : <input type="password" id="newPw"></p>
<c:if test="${errors.blankNewPw}">새로운 비밀번호를 입력해주세요.</c:if>
<input type="submit" value="비밀번호 변경하기">
</form>
</body>
</html>