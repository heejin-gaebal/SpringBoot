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
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

    <main>
        <h1>MY PAGE</h1>
        <form action="/member/edit" method="post">
            <input type="text" name="userId" placeholder="아이디" value="${loginMember.userId}" readOnly>
            <br>
            <input type="password" name="userPwd" placeholder="비밀번호">
            <br>
            <input type="text" name="userNick" placeholder="닉네임" value="${loginMember.userNick}">
            <br>
            <input type="submit" value="수정하기">
            <input type="button" onclick="location.href='/member/quit'" value="탈퇴하기">
        </form>
    </main>

    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>