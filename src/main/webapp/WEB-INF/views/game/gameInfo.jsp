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
  <title>경기 상세</title>
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
    <div>
      <!-- content 영역 시작 -->
      <div class="gameInfo-content">
        <!-- 경기 제목 영역 시작 -->
        <div class="titeContainer">
          <div>${gameInfoVO.sRegion}</div>
          <div>${gameInfoVO.gTitle}</div>
          <div>
            <a href="gameResult.html">경기 참여</a>
          </div>
        </div>
        <!-- 경기 제목 영역 종료 -->
        <!-- 사이 공간 영역 시작 -->
        <div class="intermediate">
          <div class="gTag" id="gTag" name="gTag">
            ${gameInfoVO.gTag}
          </div>
          <div class="gMinmember" id="gMinmember" name="gMinmember">
            9<span> <현재 참여 인원></span> / ${gameInfoVO.gMinMember}<span> <최소 참여 인원></span>
          </div>
          <div>
            ${gameInfoVO.gCreatedDate} 개설
          </div>
        </div>
        <!-- 사이 공간 영역 종료 -->
        <!-- 팀 정보 영역 시작 -->
        <div class="gameInfoContainer">
          <!-- 나의 팀 시작 -->
          <div class="teamMember">
            <div>
                <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
                <div>${gameInfoVO.tName}</div>
            </div>
            <div>
              <label>경기 참가 인원</label>
              <ul>
                <li>허진욱<span>주장</span></li>
                <li>홍성연</li>
                <li>최연희</li>
                <li>기성룡</li>
                <li>정성룡</li>
                <li>이을룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
              </ul>
            </div>
          </div>
          <!-- 나의 팀 끝 -->
          <!-- 상대 팀 시작 -->
          <div class="teamMember">
            <div>
              <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
              <div>문주군단</div>
            </div>
            <div>
              <label>경기 참가 인원</label>
              <ul>
                <li>허진욱<span>주장</span></li>
                <li>홍성연</li>
                <li>최연희</li>
                <li>기성룡</li>
                <li>정성룡</li>
                <li>이을룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
                <li>이청룡</li>
              </ul>
            </div>
          </div>
          <!-- 상대 팀 끝 -->
        </div>
        <!-- 팀 정보 영역 시작 -->
        <!-- 경기장 정보 영역 시작  -->
        <div class="stadiumInfoContainer">
          <div>
            경기 일시<br>
            ${gameInfoVO.gResDate} (${gameInfoVO.gTime} 시간)
          </div>
          <div>
            ${gameInfoVO.sName} ${gameInfoVO.sNum} 경기장<br>
           ${gameInfoVO.sAddr}
          </div>
        </div>
        <!-- 경기장 정보 영역 끝  -->
        <!-- 공지 사항 및 코멘트 영역 시작 -->
        <div class="comentContainer">
          <div class="gInfoContainer">
            <label>경기 안내 사항</label>
            <div class="gInfo" id="gInfo" name="gInfo">
              ${gameInfoVO.gInfo}
            </div>
          </div>
          <div class="gComentContainer">
            <div>코멘트</div>
            <div class="gComent" id="gComent" name="gComent">
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
              <p><span>공지 : </span>경기일 우천이 예고 되어있습니다.</p>
            </div>
            <div class="comentsContainer">
              <input type="text" class="gameComents">
              <input type="submmit" value="입력" class="gameComentsSumit">
            </div>
          </div>
        </div>
        <!-- 공지 사항 및 코멘트 영역 끝 -->
      </div>
      <!-- content 영역 종료 -->
    </div>
    <!-- 이름없는 div 종료 -->
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