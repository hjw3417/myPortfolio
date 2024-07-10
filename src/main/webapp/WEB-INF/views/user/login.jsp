<!DOCTYPE html>
<html lang="ko">
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/main.css">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script type="text/javascript">
     function checkLogin() {
         var errorMsg = '${errorMsg}';
         if (errorMsg != null && errorMsg != "") {
             alert(errorMsg);
         }
     }
  </script>
  <title>login</title>
</head>
<body onload="checkLogin();">
  <header>
    <div class="logo">
          <a href="/serviceMain">
            <img src="./image/logo.png">
          </a>
        </div>
    <div>
      <span><a href="${contextPath}/login">로그인</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="${contextPath}/join">회원가입</a></span>
    </div>
    <div>
      <ul></ul>
    </div>
  </header>
  <main style="text-align: center; height: 750px;">
    <div>　</div>
    <div>
      <section class="login">
        <div>
          로그인
        </div>
        <div>
          <form name="login" method="post" action="${contextPath}/login" enctype="utf-8">
            <div>
              <input type="text" id="uID" name="uID" size="12" maxlength="12" placeholder="아이디를 입력해주세요." required>
            </div>
            <div>
              <input type="password" name="uPW" size="20" minlength="9" maxlength="20" placeholder="비밀번호를 입력해주세요." required>
            </div>
            <div>
              <input type="submit" value="로그인">
              <input type="reset" value="취소">
            </div>
          </form>
        </div>
        <div>
          <span><a href="${contextPath}/findPw">비밀번호 찾기</a></span>
          <span><a href="${contextPath}/findId">아이디 찾기 &nbsp|&nbsp</a></span>
        </div>
      </section>
    </div>
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