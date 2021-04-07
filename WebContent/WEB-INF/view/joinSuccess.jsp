<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<!-- param.name은 joinForm.jsp에서 가져온 name값 -->
${param.name}님 회원가입이 완료되셨습니다.
<!-- ctxPath : contextPath경로를 가진 변수 -->
${ctxPath = pageContext.request.contextPath; ''}
<a href="${ctxPath}/list.do">[메인화면으로 돌아가기]</a>
</body>
</html>