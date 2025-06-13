<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<link rel="stylesheet" href="/css/common/header.css">
</head>
<c:if test="${not empty alertMsg}">
    <script>
        alert("${alertMsg}");
    </script>
</c:if>
<c:remove var="alertMsg" />

<body>
    <header>
	    <h1>WELCOME~~</h1>
    </header>

	<nav>
	    <a href="/board/list">게시판</a><br>
	    <a href="/notice/list">공지사항</a><br>
	    <a href="/gallery/list">갤러리</a><br>
	    <a href="/member/mypage">마이페이지</a><br>
	</nav>
</body>
</html>