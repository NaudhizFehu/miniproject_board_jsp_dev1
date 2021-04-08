<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 작성 완료</title>
</head>
<body>
	글이 성공적으로 작성 되었습니다.
	<br> ${ctxPath = pageContext.request.contextPath ; ''}
	<a href="${ctxPath}/article/list.do"><input type="button"
		value="게시글 목록 보기"></a>
	<a href="${ctxPath}/article/read.do?no=${newArticleNo}"><input
		type="button" value="게시글 내용 보기"></a>
</body>
</html>