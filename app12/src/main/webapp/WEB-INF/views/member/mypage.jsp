<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<script defer src="/js/member/mypage.js"></script>
</head>
<body>
	<h1>마이페이지</h1>

    <input type="text" name="userId" placeholder="유저아이디" readonly value="${loginMember.userId}">
    <br>
    <input type="password" name="userPwd" placeholder="비밀번호" value="${loginMember.userPwd}">
    <br>
    <input type="text" name="userNick" placeholder="닉네임" value="${loginMember.userNick}">

    <br>
    <input type="button" onclick="edit();" value="수정하기">
    <input type="button" onclick="quit();" value="탈퇴하기">
</body>
</html>