<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/adminPage.css">
  <title>관리자페이지-팀 관리</title>
</head>
<body>
  <header>
  <main>

      <div class="admin">
        <a href="adminMainPage.html">
         <img src="../image/home.png" alt="홈으로">
        </a>

         <div> 관리자 페이지 </div>
      </div>

      <h2> 팀 목록 </h2>

    <div>
      <div class="side">
        <img src="../image/user.png" alt="사용자">
          <div> admin</div>

            <ul style="list-style-type: none;">
              <li> <a href="adminMainPage.html"> 관리자 메인 </a> </li>
              <li> <a href="adminUserPage.html">회원 관리 </a> </li>
              <li><a href="adminTeamListPage.html">팀 관리 </a> </li>
              <li><a href="adminGameListPage.html">경기 관리 </a></li>
            </ul>
        <a href="#">
        <img class="logoutimg" src="../image/logout.png" alt="로그아웃">
      </a>

    </div>

    <div class="tablecontainer">
    <table class="list">
      <thead>
          <tr>
              <th>팀ID</th>
              <th>팀 명</th>
              <th>지역</th>
              <th>랭크</th>
              <th>인원</th>

          </tr>
      </thead>

      <tbody>
        <c:forEach items="${teamsList}" var="team">
            <tr>
              <td> ${team.tID} </td>  <!-- 팀아이디 -->
              <td> ${team.tName}  </td>
              <td> ${team.tRegion}  </td>
              <td> ${team.tRankScore}    </td>
              <td> ${team.tMember}  </td>
            </tr>
        </c:forEach>

      </tbody>
    </table>

  </div>
</div>
</main>
</body>
</html>