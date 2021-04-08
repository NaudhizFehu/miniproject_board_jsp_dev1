<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 변경하기</title>
</head>
<body>
이메일이 변경되었습니다.
${ctxPath = pageContext.request.contextPath; ''}
<a href="${ctxPath}/myInfo.do">[내 정보 보기]</a>
</body>
</html>