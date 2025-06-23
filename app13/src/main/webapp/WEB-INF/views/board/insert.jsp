<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
</head>
<script defer src="/js/board/insert.js"></script>
<body>
	<h1>게시글 작성</h1>

	<!-- <form action="/api/board" method="post" enctype="multipart/form-data">
        <input type="text" name="title" placeholder="제목">
        <br>
        <textarea name="content" placeholder="내용"></textarea>
        <br>
        <input type="file" name="f">
        <br>
        <input type="submit" value="게시글 작성">
    </form> -->

    <input type="text" name="title" placeholder="제목">
    <br>
    <textarea name="content" placeholder="내용"></textarea>
    <br>
    <input type="file" name="f">
    <br>
    <input type="submit" value="게시글 작성" onclick="insertBoard();">

</body>
</html>