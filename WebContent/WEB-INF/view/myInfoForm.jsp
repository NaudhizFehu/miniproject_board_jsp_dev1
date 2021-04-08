<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
${ctxPath = pageContext.request.contextPath; ''}
<p><a href="${ctxPath}/article/list.do">[게시판으로 돌아가기]</a>
<p>아이디 : ${user.id}</p>
<p>이름 :  ${user.name}</p>
<p>이메일 : ${user.email}&emsp;<a href="changeEmail.do"><input type="button" value="이메일 변경하기"></a></p>
<p>전화번호 : ${user.phoneNumber1} - ${user.phoneNumber2} - ${user.phoneNumber3}
&emsp;<a href="changePhoneNumber.do"><input type="button" value="전화번호 변경하기"></a></p>
<a href="changePw.do"><input type="button" value="비밀번호 변경하기"></a>

</body>
</html>