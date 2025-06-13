<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
</head>
<body>
	<h1>게시글 목록</h1>

    <c:forEach var="vo" items="${voList}">
        <h2>${vo}</h2>
    </c:forEach>

    <button type="button" onclick="location.href='/board/insert'">작성하기</button>
</body>
</html>