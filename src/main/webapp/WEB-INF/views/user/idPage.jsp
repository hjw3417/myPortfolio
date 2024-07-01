<!DOCTYPE html>
<html lang="ko">
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/main.css">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <title>idPop</title>
</head>
<body>
    <div class="idPop">
        <hr>
        <form name="idP" method="post" action="/idPage" enctype="utf-8">
        <div>회원님의 아이디는 ${uId}입니다.</div>
        <input type="submit" value="확인">
    </div>
</body>
</html>