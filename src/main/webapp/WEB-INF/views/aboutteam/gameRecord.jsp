<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="widtd=device-widtd, initial-scale=1.0">
  <link rel="stylesheet" href="../css/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/js.js"></script>
  <title>game record</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="../image/logo.png">
      <!-- <div>누가 잘차</div> -->
    </div>
    <div>
      <span><a href="login.html">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="myPage.html">마이페이지</a></span>
    </div>
    <div>
      <ul>
        <li>
          <a href="teamlist.html">팀</a>
          <div>
            <ul>
              <li><a href="teamlist.html">팀 목록</a></li>
              <li><a href="myteam.html">나의 팀</a></li>
            </ul>
          </div>
        </li>
        <li><a href="${contextPath}/game/gameInfoList.do">경기 목록</a></li>
        <li><a href="${contextPath}/game/stadiumList.do">경기장 목록</a></li>
        <li><a href="rankWatch.html">랭킹</a></li>
        <li><a href="#">게시판</a></li>
      </ul>
    </div>
  </header>
  <main>
    <div>　</div>
    <div>
      <div class="gameRecord-side">
        <div>
          <div>　</div>
          <div>나의 팀</div>
          <ul>문주 군단
            <li><a href="#">팀원 목록</a></li>
            <li><a href="#">팀 경기 일정</a></li>
            <li><a href="#">전적</a></li>
            <li><a href="#">팀 게시판</a></li>
          </ul>
        </div>
      </div>
      <div class="gamerecord">
        <div>
          전적
        </div>
        <div>
          <span>전체 전적&emsp;</span>
          <span></span>
          <span>${gameRecordVO.totalCount}&nbsp;</span>
          <span>전&emsp;</span>
          <span>${gameRecordVO.winCount}&nbsp;</span>
          <span>승&emsp;</span>
          <span>${gameRecordVO.loseCount}&nbsp;</span>
          <span>패&emsp;</span>
          <span>${gameRecordVO.drawCount}&nbsp;</span>
          <span>무</span>
          <span></span>
        </div>
        <div>
          <form action="#">
            <select id="resultType">
              <option value="">전체</option>
              <option value="승">승</option>
              <option value="패">패</option>
              <option value="무">무</option>
            </select>
          </form>
        </div>
        <div id="gameRecordContainer">
        <c:forEach var="gameRecord" items="${gameRecordVO.gameRecordInfoListVO}">
            <div>
                <span>${gameRecord.tHomeName}&nbsp;</span>
                <span>${gameRecord.homeGoal}</span>
                <span>:</span>
                <span>${gameRecord.awayGoal}</span>
                <span>&nbsp;</span>
                <span>${gameRecord.tAwayName}</span>
                <span>${gameRecord.gResDate}</span>
                <span>${gameRecord.resultType}</span>
            </div>
        </c:forEach>
        </div>
        <!-- pagination 시작 -->
        <div class="paginationContainer">
          <ul class="pagination">
            <li>
            <button id="GameRecord-prevPage" type="button" onclick="#">이전</button>
            </li>
            <li id="GameRecord-pageNumBtnLI" name="GameRecord-pageNumBtnLI">
            </li>
            <li>
                <button id="GameRecord-nextPage" type="button" onclick="#">다음</button>
            </li>
          </ul>
        </div>
        <!-- pagination 종료 -->
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