<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
              <li> <a href="/myPage"> 마이페이지 </a> </li>
              <li> <a href="/myPage/myGameRecord"> 경기 결과 </a> </li>
              <li><a href="/myPage/updatePwCheck">정보 수정 </a> </li>
            </ul>
        </div>

  <!---메인화면 -->

        <h1> 마이페이지 </h1>
        <div class="divide-line">
        </div>
        <div class="myInfoContainer">
          <img src="../image/user.png" class="profile">  </img>

          <c:if test="${not empty myPageInfo}">
              <div class="name">${myPageInfo[0].uID}</div> <!-- 첫 번째 요소의 이름 출력 -->
          </c:if>


          <div class="infoTable">
            <table>
              <tbody>
                <c:forEach items="${myPageInfo}" var="myInfo" end="2">
                  <tr>
                    <td>소속팀</td>
                    <td>${myInfo.tName}</td> <!-- 소속팀 이름 -->
                    <td><img src="../image/rank.png" width="34px" height="28px"></td>
                     <td> ${myInfo.tRankScore} </td> <!-- 랭크 -->
                     <td>
                     <c:choose>
                         <c:when test="${myInfo.tRankScore >=0 and myInfo.tRankScore <=500}">
                            브론즈
                         </c:when>
                         <c:when test="${myInfo.tRankScore >500 and myInfo.tRankScore <=1000}">
                            실버
                         </c:when>
                         <c:when test="${myInfo.tRankScore >1000 and myInfo.tRankScore <=1500}">
                            골드
                         </c:when>
                          <c:when test="${myInfo.tRankScore >1500 }">
                            플래티넘
                         </c:when>
                      </c:choose>
                     </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>

        <h2> 최근 경기결과</h2>

        <!--최근 경기결과-->
        <div class="recentlyPlay">
          <table>
            <tr>
                 <th width="110"> 경기 일시 </th>
                 <th width="190"> 나의팀</th>
                 <th width="50" colspan="3"> 득점 </th>
                 <th width="190"> 상대팀 </th>
                 <th width="220"> 경기 장소</th>
                 <th width="70"> 경기 결과</td>
            </tr>

           <c:forEach items="${recentGame}" var="recent" end="3">
             <tr>
                  <td width="110" height="50"> ${recent.gResDate}   </td>
                  <td width="190"> ${recent.myTeam} </td>
                  <td width="20"> ${recent.homeGoal} </td>
                  <td width="10"> : </td>
                  <td width="20"> ${recent.awayGoal} </td>
                  <td  width="200"> ${recent.awayTeam}  </td>
                  <td width="220">  ${recent.sName} </td>
                  <td width="70">
                       <c:choose>
                           <c:when test="${recent.homeGoal > recent.awayGoal}">
                               승
                           </c:when>
                           <c:when test="${recent.homeGoal == recent.awayGoal}">
                               무승부
                           </c:when>
                           <c:otherwise>
                               패
                           </c:otherwise>
                       </c:choose>
                  </td>
              </tr>
            </c:forEach>
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