<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="widtd=device-widtd, initial-scale=1.0">
  <link rel="stylesheet" href="../css/maketeam.css">
  <title>team member list</title>
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
                    <li><a href="${contextPath}/gameSchedule?tID=${team.tID}">팀 경기 일정</a></li>
                    <li><a href="${contextPath}/gameRecord?tID=${team.tID}">전적</a></li>
                  </ul>
                </a>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
      <div class="teammemberlist">
        <div>
          팀원 목록
        </div>
        <div>
          <span>가입날짜&emsp;&emsp;</span>
          <span>최신순</span>
          <span>&nbsp;|&nbsp;</span>
          <span>오래된순</span>
        </div>
        <div>
          <table>
            <thead>
              <tr>
                <th>NO</th>
                <th>ID</th>
                <th>생년월일</th>
                <th>전화번호</th>
                <th>가입날짜</th>
                <c:if test="${teamMember.leader == 1}">
                  <th>
                    <div>추방버튼</div>
                  </th>
                </c:if>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="teamMembers" items="${teamMembers}" varStatus="loop" end="5">
                <tr>
                  <td>${loop.index+1}</td>
                  <td>${teamMembers.uID}</td>
                  <td>${teamMembers.uBday}</td>
                  <td>${teamMembers.uPhone}</td>
                  <td>${teamMembers.createdDate}</td>
                  <c:if test="${teamMember.leader == 1}">
                    <td><div>추방</div></td>
                  </c:if>
                </tr>
              </c:forEach>
            </tbody>
          </table>
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