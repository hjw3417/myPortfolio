<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/maketeam.css">
  <title>myteam</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="${contextPath}/image/logo.png">
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
          <div>팀</div>
          <ul>
            <li><a href="${contextPath}/teamList">팀 목록</a></li>
            <li><a href="#">나의 팀</a></li>
            <li><a href="${contextPath}/teamMake">팀 만들기</a></li>
          </ul>
        </div>
      </div>
      <div class="myteam">
        <section class="sec1">
          <div class="teamprofile">
            <div>
              <div>
                <div>
                  <img src="${contextPath}/image/우사기.jpg">
                </div>
                <div>
                  <span>platinum</span>
                  <span>1900</span>
                </div>
              </div>
              <div>
                <div>
                  <span>팀 이름 : </span>
                  <span>문주군단</span>
                </div>
                <div>
                  <span>전적 : </span>
                  <span>47전 33승 14패</span>
                </div>
                <div>
                  <span>팀원 수 : </span>
                  <span>50명</span>
                </div>
                <div>
                  <span>창단일 : </span>
                  <span>2024.05.05</span>
                </div>
              </div>
            </div>
          </div>
          <div class="record">
            <div>
              <span>전적</span>
              <span><a href="teamrecord.html">+ 더보기</a></span>
            </div>
            <div>
              <ul>
                <li>
                  <span>문주군단</span>
                  <span>&nbsp;3&nbsp;</span>
                  <span>:</span>
                  <span>&nbsp;2&nbsp;</span>
                  <span>문주군단</span>
                  <span>승</span>
                </li>
                <li>
                  <span>문주군단</span>
                  <span>&nbsp;2&nbsp;</span>
                  <span>:</span>
                  <span>&nbsp;3&nbsp;</span>
                  <span>김반박이</span>
                  <span>패</span>
                </li>
                <li>
                  <span>문주군단</span>
                  <span>&nbsp;3&nbsp;</span>
                  <span>:</span>
                  <span>&nbsp;2&nbsp;</span>
                  <span>개발냥발</span>
                  <span>승</span>
                </li>
                <li>
                  <span>문주군단</span>
                  <span>&nbsp;3&nbsp;</span>
                  <span>:</span>
                  <span>&nbsp;5&nbsp;</span>
                  <span>성환FC</span>
                  <span>패</span>
                </li>
              </ul>
            </div>
          </div>
        </section>
        <section class="sec2">
          <div class="schedule">
            <div>
              <span>경기 일정</span>
              <span><a href="#">+ 더보기</a></span>
            </div>
            <div>
              <ul>
                <li>06.19 17:00  문주군단 : 김반박이</li>
                <li>참여</li>
              </ul>
              <ul>
                <li>06.20 17:00  문주군단 : 성환FC</li>
                <li>참여</li>
              </ul>
              <ul>
                <li>06.25 17:00  문주군단 : 개발냥발</li>
                <li>참여</li>
              </ul>
              <ul>
                <li>06.25 17:00  문주군단 : 개발냥발</li>
                <li>참여</li>
              </ul>
            </div>
          </div>
          <div class="teamboard">
            <div>
              <span>팀 게시판</span>
              <span><a href="#">+ 더보기</a></span>
            </div>
            <div>
              <ul>
                <li>안녕하세요.</li>
                <li>안전게임하세요!</li>
                <li>다 이겨버리자고!</li>
                <li>뿌르르르르르</li>
              </ul>
            </div>
          </div>
        </section>
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