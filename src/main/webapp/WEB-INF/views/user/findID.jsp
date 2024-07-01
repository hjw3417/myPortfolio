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

    $('#find_id_btn').on("submit", function(e){

        e.preventDefault();

        let popUrl = "/user/idPop";
        let popOption = "width=650, height=550, top=300, left=300";

        window = window.open(popUrl,"_blank",popOption);

    });
    </script>
  <title>idFind</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="./image/logo.png">
    </div>
    <div>
      <span><a href="/login">로그인</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="/join">회원가입</a></span>
    </div>
    <div>
      <ul></ul>
    </div>
  </header>
  <main style="text-align: center; height: 750px;">
    <div>　</div>
    <div>
      <section class="idFind">
        <div>
          아이디 찾기
        </div>
        <div>
          <form name="find" method="post" action="/findId" enctype="utf-8">
            <div>
              <input type="text" name="uName" placeholder="이름을 입력해주세요." required>
            </div>
            <div>
              <input type="text" name="uBday" placeholder="생년월일 8자리를 입력해주세요." required>
            </div>
            <div>
              <input type="text" name="uPhone" size="11" maxlength="11" placeholder="휴대폰 번호를 입력해주세요." required>
            </div>
            <div>
              <input type="submit" value="확인" id="find_id_btn">
              <input type="reset" value="취소">
            </div>
          </form>
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