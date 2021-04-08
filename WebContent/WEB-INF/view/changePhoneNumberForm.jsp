<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호 변경하기</title>
</head>
<body>
<form action="changePhoneNumber.do" method="post">
<p>새로운 전화번호 : <input type="text" name="newPhoneNumber1" style="width:40px">-<input type="text" name="newPhoneNumber2" style="width:50px">-<input type="text" name="newPhoneNumber3" style="width:50px"></p>
<c:choose>
<c:when test="${errors.blankNewPhoneNumber}">전화번호를 입력해 주세요.</c:when>
<c:when test="${errors.notPhoneNumber}">전화번호 양식에 맞지 않습니다. 다시 입력해주세요.</c:when>
</c:choose>
<p><input type="submit" value="전화번호 변경하기"> &emsp;<a href="myInfo.do"><input type="button" value="변경 취소하기"></a></p>
</form>
</body>
</html>