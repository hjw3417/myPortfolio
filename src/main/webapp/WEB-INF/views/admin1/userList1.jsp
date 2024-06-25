<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/adminPage.css">
  <title>관리자페이지-회원 관리</title>
</head>
<body>
  <header>
  <main>

      <div class="admin">
        <a href="adminMainPage.html">
         <img src="img/home.png" alt="홈으로">
        </a>

         <div> 관리자 페이지 </div>
      </div>

      <h2> 회원 목록 </h2>

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

    <div class="tablecontainer">
    <table class="list">
      <thead>
          <tr>
              <th>ID</th>
              <th>이름</th>
              <th>성별</th>
              <th>생년월일 </th>
              <th>도로명주소</th>
              <th>이메일</th>

          </tr>
      </thead>

      <tbody>
      <c:forEach items="${usersList}" var="user">
			<tr>
					<td> ${user.uID } </a></td>	<!-- 아이디 -->
					<td> ${user.uName} </td> <!-- 이름  -->
					<td> ${user.uGender }  </td>	<!-- 성별 -->
					<td> ${user.uBday }  </td>	<!-- 생년월일 -->
					<td>  ${user.uAddr1 }  </td>	<!-- 도로명 주소 -->
					<td>  ${user.uEmail } </td>	<!-- 이메일 -->
					<!--   <td> ${member.uPhone } </td>	<!-- 휴대폰 번호 -->
					<!--  <td>${member.uPhone.substring(0, 3)}****${member.uPhone.substring(7)} --></td>
			</tr>
		</c:forEach>

      </tbody>
  </table>
  </div>
</div>

  </main>
</body>
</html>