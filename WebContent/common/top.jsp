<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<body>
<div>
<p style="position: fixed; right: 0px; left: auto;">
${ctxPath = pageContext.request.contextPath; ''}
<a href="${ctxPath}/login.do">[로그인]</a>
<a href="${ctxPath}/join.do">[회원가입]</a>
</div>
</p>
</body>
</html>