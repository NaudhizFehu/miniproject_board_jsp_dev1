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
	<td colspan="2">
	<!-- GET방식으로 파라미터를 넘겨주므로 param.pageNo으로 값을 조회한다. -->
	<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}"></c:set>
	<a href="list.do?pageNo=${pageNo}">[목록보기]</a>&emsp;
	
	<c:if test="${authUser.id == articleData.article.writer.id}">
	<a href="modify.do?no=${articleData.article.number}">[글 수정하기]</a>&emsp;
	<a href="delete.do?no=${articleData.article.number}">[글 삭제하기]</a>
	</c:if>
	</td>
</tr>
</table>
</body>
</html>