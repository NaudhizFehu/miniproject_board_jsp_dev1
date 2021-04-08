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
	<td>1</td>
</tr>
<tr>
	<td>작성자</td>
	<td>닉네임</td>
</tr>
<tr>
	<td>글 제목</td>
	<td>제모오오오옥</td>
</tr>
<tr>
	<td>글 내용</td>
	<td>내요오오오오옹</td>
</tr>
<tr>
	<td colspan="2"><a href="${ctxPath}/list.do">[목록보기]</a>&emsp;
	<a href="${ctxPath}/modify.do">[글 수정하기]</a>&emsp;
	<a href="${ctxPath}/delete.do">[글 삭제하기]</a>
	</td>
</tr>
</table>
</body>
</html>