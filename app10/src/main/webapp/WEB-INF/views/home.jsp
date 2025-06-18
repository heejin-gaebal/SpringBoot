<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<link rel="stylesheet" href="/css/home.css">
<script src="/js/home.js"></script>
</head>
<body>
	<h1>COMEBACK HOME</h1>

    <hr>

    <h2>게시글 작성</h2>
    <input type="text" id="title"> <br>
    <textarea name="content" id="content"></textarea> <br>
    <button onclick="insert();">작성하기</button>

    <hr>

    <h2>게시글 상세조회</h2>
    <div id="boardDetail"></div>
    
    <hr>

    <h2>게시글 조회</h2>
    <button onclick="list();">조회하기</button>
    <table>
        <thead>
            <tr>
                <th>게시글 번호</th>
                <th>게시글 제목</th>
                <th>게시글 작성일</th>
            </tr>
        </thead>
        <tbody>
            조회된 내용이 없습니다.
        </tbody>
    </table>

    <div id="page-area">
        <!-- <button onclick="list(1)">[1]</button>
        <button onclick="list(2)">[2]</button>
        <button onclick="list(3)">[3]</button>
        <button onclick="list(4)">[4]</button>
        <button onclick="list(5)">[5]</button> -->
    </div>
</body>
</html>