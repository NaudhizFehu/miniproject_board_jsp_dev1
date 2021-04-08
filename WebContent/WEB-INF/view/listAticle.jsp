<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>게시글 목록 보기</title>
</head>
<body>

<table border="1">
		<tr>
				<td colspan="4"><a href="write.do">[게시글 쓰기]</a>
		</tr>
		
		<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>등록일</td>
				<td>조회</td>
		</tr>
		
<c:if test="${articlePage.hasArticle()}">
		<tr>
				<td colspan="7">등록된 게시글이 없습니다</td>
		</tr>
</c:if>
<c:forEach var="article" items="${articlePage.content}">
		<tr>
				<td>${article.number}</td>
				<td>
				<a href="read.do?no=${article.number}&pageNo=$pageNo=${articlePage.currentPage}">
				<c:out value="${article.title}"/>
				</a>
				</td>
				<td>${article.write.name}</td>
				<td>${article.readCount}</td>
		</tr>
</c:forEach>
<c:if test="${articlePage.hasNoArticle()}">
		<tr>
				<td colspan="5">
					<c:if test="${articlePage.startPage > 5}>
					<a href="list.do?pageNo=${articlePage.startPage -5}">[이전]</a>
					</c:if>
					
					<c:forEach var="pNo"
									begin="${articlePage.startPage}"
									end="${articlePage.endPage}">
					<a href="list.do?pageNo=${pno}">[${pNo}]</a>
					</c:forEach>
					
					<c:if test="${articlePage.endPage<articlePage.totalPages}">
					<a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
					</c:if>
			</td>
	</tr>
</table>
</body>
</html>