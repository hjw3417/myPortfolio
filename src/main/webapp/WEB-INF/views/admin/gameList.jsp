<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/adminPage.css">
  <title>관리자페이지-경기 관리</title>
</head>
<body>

  <header>
  <main>

      <div class="admin">
        <a href="/admin/main.do">
         <img src="../image/home.png" alt="홈으로">
        </a>

         <div> 관리자 페이지 </div>
      </div>

      <h2> 경기 목록 </h2>

    <div>
      <div class="side">
        <img src="../image/user.png" alt="사용자">
          <div> admin</div>

            <ul style="list-style-type: none;">
                 <li> <a href="/admin/main.do"> 관리자 메인 </a> </li>
                  <li> <a href="/admin/userList.do">회원 관리 </a> </li>
                  <li><a href="/admin/teamList.do">팀 관리 </a> </li>
                  <li><a href="/admin/gameList.do">경기 관리 </a></li>
                  <li><a href="/mainBoard"> 게시판 </a></li>
            </ul>
        <a href="/login">
        <img class="logoutimg" src="../image/logout.png" alt="로그아웃">
      </a>

    </div>

    <div class="tablecontainer">
    <table class="list">
      <thead>
          <tr>
              <th>경기 ID</th>
              <th>경기 이름</th>
              <th>경기 일시</th>
              <th>경기 장소</th>
              <th>경기 상태</th>

          </tr>
      </thead>


      <tbody>
       <c:forEach items="${gameList}" var="game">
           <tr>
                 <td><a href="/admin/gameDetail/${game.gameId}">${game.gameId}</a></td>
                 <td>${game.gameTitle}</td>
                 <td>${game.gameResDate}</td>
                 <td>${game.stadiumName}</td>
                 <td>
                    <c:choose>
                        <c:when test="${game.gameStatus == 0}">
                            경기 생성
                        </c:when>
                        <c:when test="${game.gameStatus ==1}">
                           <span class="red-text"> 경기 종료   </span>
                        </c:when>
                    </c:choose>
                 </td>
           </tr>
       </c:forEach>
  </div>
</div>
</main>

</body>
</html>
