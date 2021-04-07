<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:choose>
<c:when test="${errors.blankId}">ID를 입력해주세요.</c:when>
<c:when test="${errors.duplicateId}">이미 등록된 ID입니다. 다른 ID를 입력해주세요.</c:when>
</c:choose>
<p>이름 : <input type="text" id="name" value="${param.name}"></p>
<c:if test="${errors.blankName}">이름을 입력해주세요.</c:if>
<p>암호 : <input type="password" id="password"></p>
<c:if test="${errors.blankPassword}">암호를 입력해주세요.</c:if>
<p>암호 확인 : <input type="password" id="confirmPassword"></p>
<c:choose>
<c:when test="${errors.blankConfirmPassword}">확인암호를 입력해주세요.</c:when>
<c:when test="${errors.notMatch}">암호와 확인암호가 일치하지 않습니다.</c:when>
</c:choose>
<p>이메일 : <input type="email" id="email"></p>
<c:choose>
<c:when test="${errors.blankEmail}">email을 입력해주세요.</c:when>
<c:when test="${errors.notEmail}">email 양식에 맞지 않습니다. 다시 입력해주세요.</c:when>
</c:choose>
<p>전화번호 : <input type="text" id="phoneNumber1" style="width:40px">-<input type="text" id="phoneNumber2" style="width:50px">-<input type="text" id="phoneNumber3" style="width:50px"></p>
<c:choose>
<c:when test="${errors.blankPhoneNumber}">전화번호를 입력해 주세요.</c:when>
<c:when test="${errors.notPhoneNumber}">전화번호 양식에 맞지 않습니다. 다시 입력해주세요.</c:when>
</c:choose>
<input type="submit" value="회원가입">
</form>
</body>
</html>