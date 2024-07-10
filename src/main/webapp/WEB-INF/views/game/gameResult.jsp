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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.js"></script>
    <title>경기 결과 입력</title>
    <script>
        alert("gID : " + ${gameinfoVO.gID});
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
            <li><a href="${contextPath}/game/gameList.do">경기 목록</a></li>
            <li><a href="${contextPath}/game/stadiumList.do">경기장 목록</a></li>
            <li><a href="/ranking">랭킹</a></li>
            <li><a href="/mainBoard">게시판</a></li>
        </ul>
    </div>
</header>
<main>
    <div>　</div>
    <div>
        <!-- content 영역 시작 -->
        <div class="gameResult-content">
            <!-- 경기 제목 영역 시작 -->
            <div class="titeContainer">
                <div>${sRegion}</div>
                <div>${gTitle}</div>
                <div>
                    <a>경기 종료</a>
                </div>
            </div>
            <!-- 경기 제목 영역 종료 -->
            <!-- 경기 평가 영역 시작 -->
            <div class="resultInputContainer">
                <div class="teamNameContainer">
                    <button class="teamName" id="homeTeam" onclick="changeButtons('homeTeam', 'oppanentTeam')">
                        ${homeTeamName}
                    </button>
                    <button class="teamName" id="oppanentTeam" onclick="changeButtons('oppanentTeam', 'homeTeam')">
                        ${awayTeamName}
                    </button>
                </div>
                <div class="scoreInputContianer">
                    <input type="text" name="homeTeamScore" id="homeTeamScore" placeholder="Score" maxlength="2">
                    <input type="text" name="awayTeamScore" id="awayTeamScore" placeholder="Score" maxlength="2">
                </div>
                <div class="submitContainer">
                    <form id="inputResultForm" method="post" action="${contextPath}/game/insert/gameResult.do">
                        <input type="hidden" name="homeTeamScoreHidden" id="homeTeamScoreHidden">
                        <input type="hidden" name="awayTeamScoreHidden" id="awayTeamScoreHidden">
                        <input type="hidden" name="gTeamID" id="gTeamID" value="${gTeamID}">
                        <input type="hidden" name="tAwayID" id="tAwayID" value="${tAwayID}">
                        <input type="hidden" name="uID" id="uID" value="${uID}">
                        <input type="hidden" name="gID" value="${gID}"/>
                        <input type="submit" value="결과 제출" />
                    </form>
                </div>
            </div>
            <!-- 경기 평가 영역 종료 -->
        </div>
        <!-- 이름없는 div 종료 -->
    </div>
    <!-- content 영역 종료 -->
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
