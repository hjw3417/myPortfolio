<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/adminPage.css">
  <title>관리자페이지-관리자 메인</title>
</head>
<body>
  <header>
  <main>

      <div class="admin">
        <a href="#">
         <img src="img/home.png" alt="홈으로">
        </a>

         <div> 관리자 페이지 </div>
      </div>
<!-- 사이드 바 -->
    <div>
      <div class="side">
        <img src="img/user.png" alt="사용자">
          <div> admin</div>

            <ul style="list-style-type: none;">
              <li> <a href="adminMainPage.html"> 관리자 메인 </a> </li>
              <li> <a href="adminUserPage.html">회원 관리 </a> </li>
              <li><a href="adminTeamListPage.html">팀 관리 </a> </li>
              <li><a href="adminGameListPage.html">경기 관리 </a></li>
            </ul>
        <a href="#">
        <img class="logoutimg" src="img/logout.png" alt="로그아웃">
      </a>

    </div>

<!-- 최근 회원 목록 테이블-->

    <div class="usertablecontainer">
      <h2> 최근 회원 목록</h2>
    <table class="user-list">
      <thead>
          <tr>
              <th>ID</th>
              <th>이름</th>
              <th>생년월일</th>
              <th>성별</th>
              <th>도로명주소</th>
              <th>상세주소</th>
              <th>이메일</th>

          </tr>


      </thead>
      <tbody>
        <tr>
          <td>  hong   </td>
          <td>   홍*  </td>
          <td>  19880811   </td>
          <td>   남자  </td>
          <td>  경기 평택시 고평로 50   </td>
          <td>   101동 101호	  </td>
          <td>   hong@test.com  </td>
        </tr>

        <tr>
          <td>  hong   </td>
          <td>   홍*  </td>
          <td>  19880811   </td>
          <td>   남자  </td>
          <td>  경기 평택시 고평로 50   </td>
          <td>   101동 101호	  </td>
          <td>   hong@test.com  </td>
        </tr>

        <tr>
          <td>  hong   </td>
          <td>   홍*  </td>
          <td>  19880811   </td>
          <td>   남자  </td>
          <td>  경기 평택시 고평로 50   </td>
          <td>   101동 101호	  </td>
          <td>   hong@test.com  </td>
        </tr>
        <tr>
          <td>  hong   </td>
          <td>   홍*  </td>
          <td>  19880811   </td>
          <td>   남자  </td>
          <td>  경기 평택시 고평로 50   </td>
          <td>   101동 101호	  </td>
          <td>   hong@test.com  </td>
      </tr>

      </tbody>
    </table>

    <a href="adminUserPage.html"> <button> 회원 전체보기</button> </a>
  </div>
</div>

<!-- 최근 팀 목록 테이블-->

<div class="teamtablecontainer">
  <h2> 최근 팀 목록 </h2>
<table class="user-list">
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
    <tr>
      <td>  hong   </td>
      <td>   홍*  </td>
      <td>  19880811   </td>
      <td>   남자  </td>
      <td>  경기 평택시 고평로 50   </td>

    </tr>

    <tr>
      <td>  hong   </td>
      <td>   홍*  </td>
      <td>  19880811   </td>
      <td>   남자  </td>
      <td>  경기 평택시 고평로 50   </td>

    </tr>

    <tr>
      <td>  hong   </td>
      <td>   홍*  </td>
      <td>  19880811   </td>
      <td>   남자  </td>
      <td>  경기 평택시 고평로 50   </td>

    </tr>
    <tr>
      <td>  hong   </td>
      <td>   홍*  </td>
      <td>  19880811   </td>
      <td>   남자  </td>
      <td>  경기 평택시 고평로 50   </td>
    </tr>

  </tbody>
</table>

<a href="adminTeamListPage.html"> <button> 팀 전체보기</button> </a>
  </div>
</div>

</main>

</body>
</html>