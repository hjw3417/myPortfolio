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
  <title>board</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="./image/logo.png">
    </div>
    <div>
      <span><a href="/login">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
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
        <li><a href="/board">게시판</a></li>
      </ul>
    </div>
  </header>
  <main style="text-align: center; height: 750px;">
    <div>　</div>
    <div>
      <section class="boardDetail">
      <div>
        <table>
          <tr>
            <th>${mBoard.bType}</th>
            <th>${mBoard.bTitle}</th>
            <th>${mBoard.createdID}</th>
            <th>${mBoard.createdDate}</th>
          </tr>
          <tr>
            <td colspan="4">
              ${mBoard.bContent}
            </td>
          </tr>
        </table>
        <div>
          <button type="button" id="modify" onclick="modfiy_btn">수정</button>
          <button type="button" id="list" onclick="location.href='/mainBoard'">목록</button>
        </div>
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