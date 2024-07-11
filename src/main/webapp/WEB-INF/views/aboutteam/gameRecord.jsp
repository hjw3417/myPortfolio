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
      <a href="/serviceMain">
        <img src="${contextPath}/image/logo.png">
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
  <main class="gameRecord-main">
    <div>　</div>
    <div>
      <div class="gameRecord-side">
        <div>
          <div>　</div>
          <div>나의 팀</div>
          <!-- 팀 이름 목록을 출력합니다. -->
          <ul id="teamNameList">
            <c:forEach items="${myTeams}" var="team">
              <li>
                <a href="${contextPath}/api/teamInfo?tID=${team.tID}" class="team-link" data-tid="${team.tID}">
                  ${team.tName}
                  <ul>
                    <li><a href="${contextPath}/teamMembers?tID=${team.tID}">팀원 목록</a></li>
                    <li><a href="${contextPath}/team/gameSchedule.do?tID=${team.tID}">팀 경기 일정</a></li>
                    <li><a href="${contextPath}/team/gameRecord.do?tID=${team.tID}">전적</a></li>
                  </ul>
                </a>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
      <div class="gamerecord">
        <div>
          ${gameRecordVO.tName} 전적
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
        <c:choose>
            <c:when test="${empty gameRecordVO or empty gameRecordVO.gameRecordInfoListVO}">
                <div>조회 결과가 없습니다</div>
            </c:when>
            <c:otherwise>
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
            </c:otherwise>
        </c:choose>
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