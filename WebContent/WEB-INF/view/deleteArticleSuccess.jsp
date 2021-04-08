<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
해당 글이 삭제되었습니다.
${ctxPath = pageContext.request.contextPath;''}
<a href="${ctxPath}/article/list.do?pageNo=${articlePage.currentPage}">[글 목록 보기]</a>
</body>
</html>