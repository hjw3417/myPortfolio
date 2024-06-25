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
</head>
<body>
  <header>
    <div class="logo">
      <img src="../../../../../../../../../2차포트폴리오/웹페이지/image/logo.png">
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
  <div>
    <!-- 컨텐트 영역 시작 -->
    <div class="resStadium-content">
      <!-- 검색 바 시작 -->
      <form class="findForm">
        <select name="sRegion">
          <option value="전체">전체</option>
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
        <input type="text" class="search" name="search" name="search" placeholder="경기장 이름 검색">
        <input type="submit" class="findFormSubmit" value="검색" >
      </form>
      <!-- 검색 바 끝 -->
      <!-- 경기장 정보 시작 -->
      <div class="stadiumContainer">
        <!-- 경기장 List 시작 -->
        <div class="stadiumList">
          <label><경기장 목록></label>
          <ul >
            <li>
              <form method="get" action="./stadiumdetail">
                  <input type="hidden" name="sID" value="<%= stadiumDTO.getsID()%>">
                  <a type="submit" class="studiumInfo" id="sID">천안축구센터</a>
              </form>
            </li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
            <li>경기장 없음</li>
          </ul>
        </div>
        <!-- 경기장 List 끝 -->
        <!-- 경기장 form 시작 -->
        <form method="get" action="commitstadium">
        <!-- 경기장 디테일 시작 -->
        <div class="stadiumDetail">
          <label><상세정보></label>
          <ul>
            <li>경기장을 선택해주세요.</li>
            <input type="hidden" name="sName" value="1">
            <li>경기장 명 : 천안 축구 센터</li>

            <input type="hidden" name="sAddr" value="1">
            <li>주소 : 천안시 서북구서북구서북구서북구서북구서북구서북구서북구서북구서북구서북구서북구 두정동 1975</li>

            <input type="hidden" name="sOwner" value="1">
            <li>관리주체 : 천안 시청 시설관리 공단</li>

            <input type="hidden" name="sPhone" value="1">
            <li>연락처 : 010 - 3417 -6687</li>
          </ul>
        </div>
        <!-- 경기장 디테일 끝 -->
        </div>
        <!-- 경기장 정보 끝 -->
      <!-- 예약 정보 시작 -->
      <table class="resInfoContainer">
        <tr>
          <td>예약일 : </td>
          <td><input type="date" name="gResDate"></td>
        </tr>
        <tr>
          <td>시작 시작 : </td>
          <td>
            <select  name="sTime">
              <option selected disabled>시작 시간 선택</option>
              <option value="8">08 : 00</option>
              <option value="9">09 : 00</option>
              <option value="10">10 : 00</option>
              <option value="11">11 : 00</option>
              <option value="12">12 : 00</option>
              <option value="13">01 : 00</option>
              <option value="14">02 : 00</option>
              <option value="15">03 : 00</option>
              <option value="16">04 : 00</option>
              <option value="17">05 : 00</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>종료 시작 : </td>
          <td>
            <select name="eTime">
              <option selected disabled>종료 시간 선택</option>
              <option value="8">08 : 00</option>
              <option value="9">09 : 00</option>
              <option value="10">10 : 00</option>
              <option value="11">11 : 00</option>
              <option value="12">12 : 00</option>
              <option value="13">01 : 00</option>
              <option value="14">02 : 00</option>
              <option value="15">03 : 00</option>
              <option value="16">04 : 00</option>
              <option value="17">05 : 00</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>경기장 선택 : </td>
          <td>
            <select name="sNum">
              <option disabled selected>경기장 선택하기</option>
              <option value="1">1 경기장</option>
            </select>
          </td>
        </tr>
      </table>
      <!-- 예약 정보 종료 -->
      <!-- 버튼 영역 시작 -->
      <div class="buttonContainer">
        <a href="gameMake.html">취소하기</a>
        <a href="gameMake.html">선택 완료</a>
      </div>
      <!-- 버튼 영역 끝 -->
    </form>
    <!-- form 영역 끝 -->
    </div>
    <!-- 컨텐트 영역 종료 -->
  </div>
  <!-- 이름 없는 div 끝 -->
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

