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
  <script>
      var contextPath = '${contextPath}'; // JavaScript 변수로 설정
  </script>
  <title>game record</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="../image/logo.png">
      <!-- <div>누가 잘차</div> -->
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
    <div class="gameSchedule-content">
      <div class="side">
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
      <div class="gameSchedule">
        <div>
          경기 일정
        </div>
        <div class="gameScheduleCardContainer" id="gameScheduleCardContainer">
            <!-- 카드 시작 -->
            <c:forEach var="gameList" items="${gameListVO}">
            <div class="tableContainer">
              <table>
                <tr>
                  <td>경기명 : </td>
                  <td>${gameList.gTitle}</td>
                  <td>
                    경기 생성일 :
                  </td>
                  <td>
                    ${gameList.gCreatedDate}
                  </td>
                </tr>
                <tr>
                  <td>경기장 : </td>
                  <td>${gameList.sName} ${gameList.sNum} 경기장</td>
                </tr>
                <tr>
                  <td>경기장 주소 : </td>
                  <td>${gameList.sAddr}</td>
                </tr>
                <tr>
                  <td>경기일시 : </td>
                  <td>${gameList.gResDate} (${gameList.gTime} 시간)</td>
                </tr>
              </table>
              <!-- 카드 submit 끝 -->
            <div class="cardSubmitContainer">
              <!-- 임시 폼 -->
              <form method="get" action="${contextPath}/game/gameInfo.do">
                <input type="hidden" class="gID" name="gID" id="gID" value="${gameList.gID}"/>
                <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
              </form>
              <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
            </div>
            <!-- 카드 submit 종료 -->
            </div>
        </c:forEach>
        </div>
        <!-- 카드 끝 -->

        <!-- pagination 시작 -->
        <div class="paginationContainer">
          <ul class="pagination">
            <li>
            <button id="gameSchedule-prevPage" type="button" onclick="#">이전</button>
            </li>
            <li id="gameSchedule-pageNumBtnLI" name="gameSchedule-pageNumBtnLI">
            </li>
            <li>
                <button id="gameSchedule-nextPage" type="button" onclick="#">다음</button>
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