<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="./css/main.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <title>main</title>
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
      <ul>
        <li>
          <a href="/team">팀</a>
          <div>
            <ul>
              <li><a href="/teamList">팀 목록</a></li>
              <li><a href="/myTeam">나의 팀</a></li>
            </ul>
          </div>
        </li>
        <li><a href="/gameList">경기 목록</a></li>
        <li><a href="/stadiumList">경기장 목록</a></li>
        <li><a href="/rankWatch">랭킹</a></li>
        <li><a href="#">게시판</a></li>
      </ul>
    </div>
  </header>
  <main>
    <div>　</div>
    <div>
      <div class="service">
        <section class="sec1">
          <div class="profile">
            <div>
              <img src="./image/우사기.jpg">
              <a href="/myPage"><div>프로필 수정</div></a>
            </div>
          </div>
          <div class="board">
            <div>
              <span>게시판</span>
              <span><a href="#">+ 더보기</a></span>
            </div>
            <div>
              <ul>
                <li>가</li>
                <li>나</li>
                <li>다</li>
                <li>라</li>
              </ul>
            </div>
          </div>
        </section>
        <section class="sec2">
          <div class="gamelist">
            <div>
              <span>최신 경기목록</span>
              <span><a href="/gameList">+ 더보기</a></span>
            </div>
            <div>
              <ul>
                <li>가</li>
                <li>나</li>
                <li>다</li>
                <li>라</li>
              </ul>
            </div>
          </div>
          <div class="rank">
            <div>
              <span>전체 랭킹 정보</span>
              <span><a href="/rankWatch">+ 더보기</a></span>
            </div>
            <div>
              <ul>
                <li>문주 군단</li>
                <li>문주 갱스터즈</li>
                <li>개발 냥발</li>
                <li>김반박이</li>
              </ul>
            </div>
          </div>
        </section>
      </div>
    </div>
  </main>
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