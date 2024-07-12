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
          <a href="/serviceMain">
            <img src="./image/logo.png">
          </a>
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
        <li><a href="${contextPath}/game/gameInfoList.do">경기 목록</a></li>
        <li><a href="${contextPath}/game/stadiumList.do">경기장 목록</a></li>
        <li><a href="/ranking">랭킹</a></li>
        <li><a href="/mainBoard">게시판</a></li>
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
            <th>${mBoard.bBullet}</th>
            <th><c:choose>
              <c:when test="${mBoard.bType == 0}">
                메인
              </c:when>
              <c:when test="${mBoard.bType == 1}">
                팀
              </c:when>
            </c:choose>
            </th>
            <th>${mBoard.bTitle}</th>
            <th>${mBoard.createdID}</th>
            <th>${mBoard.createdDate}</th>
          </tr>
          <tr>
            <td colspan="5">
              ${mBoard.bContent}
            </td>
          </tr>
        </table>
        <div>
            <button type="submit" id="modify" onclick="location.href='/boardEdit?bID=${mBoard.bID}'">수정</button>
            <button type="button" id="delete" onclick="location.href='/boardDelete?bID=${mBoard.bID}'">삭제</button>
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