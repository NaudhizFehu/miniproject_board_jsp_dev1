<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
${ctxPath = pageContext.request.contextPath;''}
<table border="1" width="100%">
<tr>
	<td>글 번호</td>
	<td>${articleData.article.number}</td>
</tr>
<tr>
	<td>작성자</td>
	<td>${articleData.article.writer.name}</td>
</tr>
<tr>
	<td>글 제목</td>
	<td>${articleData.article.title}</td>
</tr>
<tr>
	<td>글 내용</td>
	<td>${articleData.content}</td>
</tr>
<tr>
	<td colspan="2"><a href="${ctxPath}/article/list.do">[목록보기]</a>&emsp;
	<a href="${ctxPath}/article/modify.do">[글 수정하기]</a>&emsp;
	<a href="${ctxPath}/article/delete.do">[글 삭제하기]</a>
	</td>
</tr>
</table>
</body>
</html>