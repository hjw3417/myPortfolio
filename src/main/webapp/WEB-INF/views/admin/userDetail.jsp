<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="/css/adminPage.css">
  <title>회원상세보기</title>
</head>
<body>
  <header>
  <main>

      <div class="admin">
        <a href="/admin/main.do">
         <img src="/image/home.png" alt="홈으로">
        </a>

         <div> 관리자 페이지 </div>
      </div>

      <h2> 회원 상세보기</h2>

    <div>
      <div class="side">
        <img src="/image/user.png" alt="사용자">
          <div> admin</div>

             <ul style="list-style-type: none;">
                  <li> <a href="/admin/main.do"> 관리자 메인 </a> </li>
                  <li> <a href="/admin/userList.do">회원 관리 </a> </li>
                  <li><a href="/admin/teamList.do">팀 관리 </a> </li>
                  <li><a href="/admin/gameList.do">경기 관리 </a></li>
                  <li><a href="/mainBoard"> 게시판 </a></li>
             </ul>
        <a href="/login">
        <img class="logoutimg" src="/image/logout.png" alt="로그아웃">
      </a>
    </div>
    <div class="userDetail">
      <table>
            <tr>
              <td> 이름 </td>
              <td>${userInfo.uName}</td>
            </tr>

            <tr>
              <td> 아이디</td>
              <td>${userInfo.uID}</td>
            </tr>

            <tr>
              <td> 생년월일</td>
              <td>
                 ${userInfo.uBday}
               </td>
            </tr>

            <tr>
              <td> 성별 </td>
              <td> ${userInfo.uGender} </td>
            </tr>

            <tr>
              <td> 도로명 주소 </td>
              <td>  ${userInfo.uAddr1} </td>
            </tr>

            <tr>
              <td> 상세 주소 </td>
              <td>   ${userInfo.uAddr2} </td>
            </tr>

            <tr>
              <td> 이메일 </td>
              <td>  ${userInfo.uEmail}</td>
            </tr>

            <tr>
              <td>전화번호</td>
              <td>  010-****-**** </td>
            </tr>

            <tr>
               <td> 소속팀1 </td>
               <td>  </td>
               <td>  </td>
            </tr>

             <tr>
               <td> 소속팀2 </td>
               <td>  </td>
               <td> </td>
            </tr>

             <tr>
               <td> 소속팀3 </td>
               <td>  </td>
               <td>  </td>
            </tr>

              <tr>
                <td> 가입일자 </td>
                <td> ${userInfo.createdDate}</td>
            </tr>
      </table>
     <a href="#"> <button> 뒤로가기</button> </a>
</div>
</main>

</body>
</html>