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
      <img src="./logo.png">
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
        <li><a href="stadiumList.html">경기장 목록</a></li>
        <li><a href="rankWatch.html">랭킹</a></li>
        <li><a href="#">게시판</a></li>
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
          <ul>문주 군단
            <li><a href="teammemberlist.html">팀원 목록</a></li>
            <li><a href="#">팀 경기 일정</a></li>
            <li><a href="teamrecord.html">전적</a></li>
            <li><a href="#">팀 게시판</a></li>
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
            <tr>
              <th>NO</th>
              <th>ID</th>
              <th>생년월일</th>
              <th>전화번호</th>
              <th>가입날짜</th>
              <th>
                <div>추방버튼</div>
                <div>(팀장만 가능)</div>
              </th>
            </tr>
            <tr>
              <td>1</td>
              <td>moon</td>
              <td>99****</td>
              <td>010****1111</td>
              <td>2024.05.29</td>
              <td><div>추방</div></td>
            </tr>
            <tr>
              <td>2</td>
              <td>heo</td>
              <td>95****</td>
              <td>010****2222</td>
              <td>2024.05.01</td>
              <td><div>추방</div></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td><div>추방</div></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td><div>추방</div></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td><div>추방</div></td>
            </tr>
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