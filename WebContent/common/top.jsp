<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<body>
<div>
<div style="position: fixed; right: 0px; left: auto;">
${ctxPath = pageContext.request.contextPath; ''}
<u:isLogin>
	<a href="${ctxPath}/myInfo.do">[내 정보 보기]</a>
	<a href="${ctxPath}/logout.do">[로그아웃]</a>
</u:isLogin>
<u:notLogin>
	<a href="${ctxPath}/login.do">[로그인]</a>
	<a href="${ctxPath}/join.do">[회원가입]</a>
</u:notLogin>
</div>
</div>
</body>
</html>