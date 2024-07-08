<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/myPage.css">


  <title>회원정보수정</title>
</head>
<body>
  <header>
    <header>
      <div class="logo">
        <img src="../image/logo.png">
        <!-- <div>누가 잘차</div> -->
      </div>

    <div>
      <span><a href="/logout">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="/myPage">마이페이지</a></span>
    </div>
    <div>
      <ul></ul>
    </div>
  </header>


  <main>
    <h1> 회원정보수정</h1>

    <!-- 사이드 바 -->
    <div class="side">

      <ul style="list-style-type: none;">
        <li> <a href="/myPage"> 마이페이지 </a> </li>
        <li> <a href="/myPage/myGameRecord"> 경기 결과 </a> </li>
        <li><a href="/myPage/updatePwCheck">정보 수정 </a> </li>
      </ul>
  </div>

   <div>　</div>

        <form class="pwCheck" name="check" method="post" action="/myPage/updatePwCheck" enctype="utf-8">
            <input type="id" name="uID" value="${uID}" readonly>
            <input type="password" name="uPW" size="20" minlength="9" maxlength="20" placeholder="비밀번호를 입력해주세요.">
            <button class="ok" type="submit" id="submit" > 확인</button>
            <button class="cancel" type="reset" > 취소</button>
      </form>

    <!-- 경고 메시지를 표시하는 JavaScript -->
    <c:if test="${not empty errorMessage}">
      <script type="text/javascript">
        alert("${errorMessage}");
      </script>
    </c:if>

    </main>



  <!--footer-->
  <footer>
    <div>
      <ul>
        <li><a href="#">이용약관</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">개인정보처리방침</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">오류/건의</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">광고/후원문의</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">고객센터</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">&copy;누가잘차</a></li>
      </ul>
    </div>
    <div>&copy;2024.MunjuGangz All rights reserved.</div>
  </footer>
</body>
</html>