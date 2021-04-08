<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<form action="write.do" method="post">
<p>
글 제목:<br><input type="text" name="title" value="{param.title}">
<c:if test="${errors.title}">제목을 입력하세요.</c:if>
</p>
<p>
내용:<br><textarea name="content" rows="5" cols="30" value="${param.content}"></textarea>
</p>
<input type="submit" value="새 글 등록">
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/article/list.do"><input type="button" value="취소"></a>
</form>
</body>
</html>