<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/myPage.css">
  <title>마이페이지</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="../image/logo.png">
      <!-- <div>누가 잘차</div> -->
    </div>
    <div>
      <span><a href="/login">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="/mypage/">마이페이지</a></span>
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

    <!-- 사이드 바 -->
      <div class="side">

            <ul style="list-style-type: none;">
              <li> <a href="myPage.html"> 마이페이지 </a> </li>
              <li> <a href="myTeamGameRecord.html"> 경기 결과 </a> </li>
              <li><a href="updateMyInfoPage.html">정보 수정 </a> </li>
            </ul>
        </div>

  <!---메인화면 -->

        <h1> 마이페이지 </h1>

        <div class="divide-line">
        </div>

        <div class="myInfoContainer">
          <img src="img/user.png" class="profile">  </img>
          <div class="profileUpdate"> 프로필 수정 </div>
          <div class="name"> ${myPageInfo.uName} </div>
          <div>
            <table>
              <tr>
                <td> 소속팀</td>
                <td> </td>
                <td> <img src="img/rank.png"  width="34px"  height="28px"> </img> </td>
                <td width="120"> ${myPageInfo.t_name} </td>
              </tr>
              <tr>
                <td> 소속팀</td>
                <td> </td>
                <td> <img src="img/rank.png"  width="34px"  height="28px"> </img> </td>
                <td width="120"> </td>
              </tr>
              <tr>
                <td> 소속팀</td>
                <td> </td>
                <td> <img src="img/rank.png"  width="34px"  height="28px"> </img> </td>
                <td width="120"> </td>
              </tr>

            </table>

          </div>
        </div>

        <h2> 최근 경기결과</h2>

        <!--최근 경기결과-->
        <div class="recentlyPlay">
          <table>
            <tr>
             <th width="140"> 경기 일시 </th>
             <th width="200"> 나의팀</th>
             <th width="20">  </th>
             <th width="200"> 상대팀 </th>
             <th width="200"> 경기 장소</th>
             <th width="70"> 경기 결과</td>
            </tr>

            <tr>
              <td width="140">  </td>
              <td width="200">  </td>
              <td width="20"> : </td>
              <td  width="200">  </td>
              <td width="200">  </td>
              <td width="70">  </td>
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