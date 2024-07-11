<!DOCTYPE html>
<html lang="ko">
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/main.css">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <title>pwPop</title>
</head>
<body bgcolor="#FFFFEA">
    <div class="pwPage">
        <hr>
        <div>회원님의 비밀번호는 ${uPW}입니다.</div>
        <button type="button" onclick="location.href='/login'">확인</button>
    </div>
</body>
</html>