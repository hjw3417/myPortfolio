<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${contextPath}/css/maketeam.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.js"></script>
  <title>랭킹</title>

</head>
<!-- <body onload="checkInsertTeamMemberResult();"> -->
<!-- 허진욱 -->
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

      <div class="teamlist">
        <div>
          랭킹
        </div>
        <div> <!--searchteam 이름은 변경할 수 있음-->
          <!-- <form name="searchteam" method="post" action="searchteam" enctype="utf-8"> -->
          <!-- 허진욱 -->
          <form id="searchteamForm">
            <div>
              <!-- <select name="t_region"> -->
              <select name="t_region" id="t_region">
                <!--<option value="" disabled selected>지역</option> -->
                <!-- 허진욱 -->
                <option value="" selected>전체</option>
                <option value="서울">서울</option>
                <option value="인천">인천</option>
                <option value="경기">경기</option>
                <option value="충남">충남</option>
                <option value="충북">충북</option>
                <option value="대전">대전</option>
                <option value="대구">대구</option>
                <option value="경북">경북</option>
                <option value="경남">경남</option>
                <option value="울산">울산</option>
                <option value="부산">부산</option>
                <option value="전남">전남</option>
                <option value="전북">전북</option>
                <option value="광주">광주</option>
                <option value="강원">강원</option>
              </select>
            </div>
            <div>
              <!-- <input type="text" name="t_name" size="12" maxlength="12" placeholder="팀 이름을 입력해주세요"> -->
              <!-- 허진욱 -->
              <input type="text" id="t_name" name="t_name" size="12" maxlength="12" placeholder="팀 이름을 입력해주세요">
              <!-- <input type="button" value="검색"> -->
              <!-- 허진욱 -->
              <input type="submit" value="검색">
            </div>
          </form>
        </div>
      <div>
        <table>
          <thead>
            <tr>
              <th>순위</th>
              <th>팀명</th>
              <th>지역</th>
              <th>랭크</th>
              <th>점수</th>
              <th>나이제한</th>
              <th>인원</th>
            </tr>
          </thead>
          <!-- <tbody> -->
          <!-- 허진욱 -->
          <tbody id="rankingTbody">
            <c:forEach var="team" items="${ranking}" varStatus="loop" end="5">
              <tr>
                <td>${loop.index+1}</td>
                <td>${team.tName}</td>
                <td>${team.tRegion}</td>
                <td>${team.rankName}</td>
                <td>${team.tRankScore}</td>
                <td>${team.tMinAge} - ${team.tMaxAge}</td>
                <td>${team.tMember} / ${team.tMaxMember}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
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