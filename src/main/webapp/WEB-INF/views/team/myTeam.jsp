<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/maketeam.css">
  <title>나의 팀</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="${contextPath}/js/myTeam.js"></script>
  <script>
    var contextPath = "${contextPath}";
  </script>
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
  <main>
    <div>　</div>
    <div>
      <div class="side">
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
                    <li><a href="${contextPath}/team/gameSchedule?tID=${team.tID}">팀 경기 일정</a></li>
                    <li><a href="${contextPath}/team/gameRecord?tID=${team.tID}">전적</a></li>
                    <li><a href="${contextPath}/teamBoard?tID=${team.tID}">팀 게시판</a></li>
                  </ul>
                </a>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
      <div id="content">
          <div class="myteam">
            <section class="sec1">
              <div id="teamprofile" class="teamprofile">
                <div>
                  <div>
                    <div>
                      <img src="${contextPath}/image/우사기.jpg">
                    </div>
                    <div>
                      <span>${teamProfile.rankName}</span>
                      <span>${teamProfile.tRankScore}</span>
                    </div>
                  </div>
                  <div>
                    <div>
                      <span>${teamProfile.tName}</span>
                    </div>
                    <div>
                      <span>전적 : </span>
                      <span>${teamProfile.gameRecordVO.totalCount}전
                            ${teamProfile.gameRecordVO.winCount}승
                            ${teamProfile.gameRecordVO.loseCount}패
                      </span>
                    </div>
                    <div>
                      <span>팀원 수 : </span>
                      <span>${teamProfile.tMember}명</span>
                    </div>
                    <div>
                      <span>창단일 : </span>
                      <span>${teamProfile.createdDate}</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="record">
                <div>
                  <span>전적</span>
                  <span><a href="/team/gameRecord.do?tID=${teamProfile.tID}">+ 더보기</a></span>
                </div>
                <div id="record">
                  <ul>
                    <c:forEach items="${teamProfile.gameRecordVO.gameRecordInfoListVO}" var="match" end="3">
                      <li>
                        <span>${match.tHomeName}</span>
                        <span>&nbsp;${match.homeGoal}&nbsp;</span>
                        <span>:</span>
                        <span>&nbsp;${match.awayGoal}&nbsp;</span>
                        <span>${match.tAwayName}</span>
                        <span>${match.resultType}</span>
                      </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </section>
            <section class="sec2">
              <div class="schedule">
                <div>
                  <span>경기 일정</span>
                  <span><a href="/team/gameSchedule.do?tID=${teamProfile.tID}">+ 더보기</a></span>
                </div>
                <div id="schedule">
                  <ul>
                    <c:forEach items="${gameList}" var="gameList" end="3">
                      <li>
                        <span>${gameList.gResDate} ${gameList.sName}</span>
                      </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
              <div class="teamboard">
                <div>
                  <span>팀 게시판</span>
                  <span><a href="#">+ 더보기</a></span>
                </div>
                <div>
                  <ul>
                    <li>안녕하세요.</li>
                    <li>안전게임하세요!</li>
                    <li>다 이겨버리자고!</li>
                    <li>뿌르르르르르</li>
                  </ul>
                </div>
              </div>
            </section>
          </div>
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