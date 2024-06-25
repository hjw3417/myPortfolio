<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maketeam.css">
  <title>maketeam</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="./image/logo.png">
    </div>
    <div>
      <span><a href="#">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="#">마이페이지</a></span>
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
        <li><a href="#">경기 목록</a></li>
        <li><a href="#">경기장 목록</a></li>
        <li><a href="#">랭킹</a></li>
        <li><a href="#">게시판</a></li>
      </ul>
    </div>
  </header>
  <main style="text-align: center; height: 800px;">
    <div>　</div>
    <div>
      <div class="maketeam">
        <div>
          팀 만들기
        </div>
        <div>
          <form name="maketeam" method="post" action="maketeam" enctype="utf-8">
            <div>
              <input type="file" name="t_logo">
            </div>
            <div>
              <input type="text" name="t_name" size="12" maxlength="12" placeholder="팀 이름을 입력해주세요" required>
              <input type="button" value="팀이름 중복">
            </div>
            <div>
              <select name="t_region">
                <option value="" disabled selected>지역</option>
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
            </div>
            <div>
              <select>
                <option value="t_minage" disabled selected>시작나이</option>
              </select>
              <select>
                <option value="t_maxage" disabled selected>끝나이</option>
              </select>
            </div>
            <div>
              <input type="text" name="t_phone" size="12" maxlength="12" placeholder="전화번호">
            </div>
            <div>
              <input type="text" name="t_info" size="20" maxlength="20" placeholder="팀 소개">
            </div>
            <div>
              <a href="myteam.html"> <input type="button" value="팀 만들기"> </a>
              <!--submit또는 버튼 태그로 변경해야됨-->
              <input type="reset" value="취소">
              <!--reset또는 버튼 태그로 변경해야됨-->
            </div>
          </form>
        </div>
      </div>
    </div>
  </main>


  <!--footer-->
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