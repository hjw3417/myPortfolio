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
  <title>경기 만들기</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/js.js"></script>
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
      <div class="stadium-content">
        <div>
          경기장 목록
        </div>
        <div> <!--searchteam 이름은 변경할 수 있음-->
          <form id="stadiumList-findForm" name="stadiumList-findForm">
            <div>
              <select name="sRegion" id="sRegion">
                <option value="">전체</option>
                <option value="A">서울</option>
                <option value="B">경기</option>
                <option value="C">인천</option>
                <option value="D">강원</option>
                <option value="E">충남</option>
                <option value="F">충북</option>
                <option value="G">대전</option>
                <option value="H">경북</option>
                <option value="I">대구</option>
                <option value="J">경남</option>
                <option value="K">울산</option>
                <option value="L">부산</option>
                <option value="M">광주</option>
                <option value="N">전북</option>
                <option value="O">전남</option>
                <option value="P">제주</option>
              </select>
            </div>
            <div>
              <input type="text" name="search" id="search" size="12" maxlength="12" placeholder="경기장명을 입력해주세요">
              <input type="submit" value="검색">
            </div>
          </form>
      </div>
      <div id="stadiumListContent">
        <table>
          <thead>
            <tr>
              <th>No</th>
              <th>축구장 명</th>
              <th>주소</th>
              <th>관수</th>
              <th>관리주체</th>

            </tr>
          </thead>
          <!-- tbody 시작 -->
          <tbody id="stadiumListTBody">
          <c:forEach var="stadiumList" items="${stadiumVO}" varStatus="status">
            <tr>
              <td>${stadiumList.sID}</td>
              <td>${stadiumList.sName}</td>
              <td>${stadiumList.sAddr}</td>
              <td>${stadiumList.sNum}</td>
              <td>${stadiumList.sOwner}</td>
            </tr>
          </c:forEach>
          </tbody>
          <!-- tbody 끝 -->
        </table>
      </div>
        <!-- pagination 시작 -->
        <div class="stadiumList-paginationContainer">
          <ul class="pagination">
            <li>
            <button id="stadiumList-prevPage" type="button" onclick="#">이전</button>
            </li>
            <li id="stadiumList-pageNumBtnLI" name="stadiumList-pageNumBtnLI">
            </li>
            <li>
                <button id="stadiumList-nextPage" type="button" onclick="#">다음</button>
            </li>
          </ul>
        </div>
        <!-- pagination 종료 -->
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

