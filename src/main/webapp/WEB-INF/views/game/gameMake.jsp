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
  <script>

  </script>
  <title>경기 만들기</title>
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
        <li><a href="gameList.html">경기 목록</a></li>
        <li><a href="../../../../../../../../../2차포트폴리오/웹페이지/html/stadiumList.html">경기장 목록</a></li>
        <li><a href="rankWatch.html">랭킹</a></li>
        <li><a href="#">게시판</a></li>
      </ul>
    </div>
  </header>
<main>
  <div>　</div>
  <div class="gameMake-content">
    <table class="inputTable">
        <tr>
            <td colspan="3" style="background-color: white; border: 2pt solid rgb(184, 206, 146); height: 40px;">
              <button id="openResStadiumBtn" onclick="openResStadium('${pageContext.request.contextPath}')">경기장 선택하기</button>
              <input type="hidden" id="sIDInput" class="sIDInput" name="sIDInput" />
              <input type="hidden" id="sNameInput" class="sNameInput" name="sNameInput" />
              <button id="sName" class="sName" name="sName" onclick="openResStadium('${pageContext.request.contextPath}')"></button>
              </a>
            </td>
          </tr>
          <tr>
            <td style="background-color: white; border: 2pt solid rgb(184, 206, 146);  font-size: 8pt; height: 30px;">
              <span>선택 정보 없음</span>
                <input type="hidden" id="gResDate" name="gResDate" value="gResDate">
                <span id="gResDate"></span>

            </td>
            <td style="background-color: white; border: 2pt solid rgb(184, 206, 146);  font-size: 8pt;height: 30px;">
              <span>선택 정보 없음</span>
                주소:
            </td>
            </tr>
            <tr>
              <td colspan="1" style="background-color: white; border: 2pt solid rgb(184, 206, 146);  height: 30px;">
                <span>선택 정보 없음</span>
                <input type="hidden" id="gTime" name="gTime" value="2">
                <span id="gTime">2</span> 시간
              </td>
              <td style="background-color: white; border: 2pt solid rgb(184, 206, 146);  height: 30px;">
                <span>선택 정보 없음</span>
                <input type="hidden" id="sNum" name="sNum" value="2">
                <span id="sNum">2</span> 경기장
              </td>
            </tr>
      <tr>
        <td colspan="3">
          <select name="selectTeam" id="selectTeam">
          <option selected>팀 선택하기</option>
          <!-- game/gameMake.do 통해 team Table의 팀 명(t_name) 값 표시 -->
          <c:forEach var="tName" items="${teamNameList}">
            <option>${tName.tName}</option>
          </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td colspan="3">
          <input type="text" name="gTitle" id="gTitle" placeholder="경기 제목을 입력하세요.">
        </td>
      </tr>
      <tr>
        <td colspan="3">
          <input type="text" name="gTag" id="gTag" placeholder="해시태그를 입력해주세요.(#로 구분)">
        </td>
      </tr>

        <tr>
          <td colspan="3">
            <input type="text" name="gMinMember" placeholder="참여 인원 설정하기">
          </td>
        </tr>
        <tr>
          <td colspan="3"  style="height: 300px; margin: 0;">
            <input type="textarea" name="gInfo" placeholder="공지사항을 입력하기">
          </td>
        </tr>
        <tr>
          <td style="background-color: rgb(146, 172, 101); height: 40px;">
            <a href="#">저장</a>
          </td>
          <td style="background-color: rgb(146, 172, 101); height: 40px;">
            <a href="gameInfo.html">경기 만들기</a>
          </td>
        </tr>
      </table>
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
