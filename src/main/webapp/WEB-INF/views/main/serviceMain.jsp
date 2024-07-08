<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
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
      <span><a href="/logout">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="/myPage">마이페이지</a></span>
    </div>
    <div>
      <ul>
        <li>
          <a href="/teamList">팀</a>
          <div>
            <ul>
              <li><a href="/teamList">팀 목록</a></li>
              <li><a href="/myTeam">나의 팀</a></li>
            </ul>
          </div>
        </li>
        <li><a href="/gameList">경기 목록</a></li>
        <li><a href="/stadiumList">경기장 목록</a></li>
        <li><a href="/ranking">랭킹</a></li>
        <li><a href="/mainBoard">게시판</a></li>
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
          <div class="boardList">
            <div>
              <span>게시판</span>
              <span><a href="/mainBoard">+ 더보기</a></span>
            </div>
            <div>
              <table>
                <c:forEach var ="board" items="${mBoardList}" end="4">
                  <tr>
                    <td>
                      ${board.bTitle}
                    </td>
                    <td>
                      ${board.createdID}
                    </td>
                  <tr>
                </c:forEach>
              </table>
            </div>
          </div>
        </section>
        <section class="sec2">
          <div class="gameList">
            <div>
              <span>최신 경기목록</span>
              <span><a href="/gameList">+ 더보기</a></span>
            </div>
            <div>
              <table>
                <c:forEach var ="game" items="${mGameList}" end="4">
                  <tr>
                    <td>
                        ${game.gTitle}
                    </td>
                    <td>
                        ${game.uID}
                    </td>
                  <tr>
               </c:forEach>
              </table>
            </div>
          </div>
          <div class="rankList">
            <div>
              <span>전체 랭킹 정보</span>
              <span><a href="/ranking">+ 더보기</a></span>
            </div>
            <div>
              <table>
                 <c:forEach var ="rank" items="${mRanking}" end="4" varStatus="loop">
                   <tr>
                     <td>
                       ${loop.index+1}
                     </td>
                     <td>
                       ${rank.tName}
                     </td>
                     <td>
                       ${rank.rankName}
                     </td>
                     <td>
                       ${rank.tRankScore}
                     </td>
                   <tr>
                 </c:forEach>
              </table>
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