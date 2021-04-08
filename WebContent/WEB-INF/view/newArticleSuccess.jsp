<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 작성 완료</title>
</head>
<body>
	새 글 작성을 완료했습니다.
	<br> ${ctxPath = pageContext.request.contextPath ; ''}
	<a href="${ctxPath}/article/list.do"><input type="button"
		value="게시글 목록 보기"></a>
	<a href="${ctxPath}/article/read.do?no=${modReq.articleNumber}"><input
		type="button" value="게시글 내용 보기"></a>
</body>
</html>