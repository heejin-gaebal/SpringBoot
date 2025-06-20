<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<script defer src="/js/member/join.js"></script>
</head>
<body>
	<h1>회원가입</h1>

    <input type="text" name="userId" placeholder="유저아이디">
    <br>
    <input type="password" name="userPwd" placeholder="비밀번호">
    <br>
    <input type="text" name="userNick" placeholder="닉네임">
    <br>
    <input type="button" onclick="join();" value="회원가입">
</body>
</html>