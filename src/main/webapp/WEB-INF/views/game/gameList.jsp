<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/style.css">
  <title>경기 목록</title>
  <script src="../../../../../../../../../2차포트폴리오/웹페이지/js/js.js" defer></script>
</head>
<body>
  <header>
    <div class="logo">
      <img src="../../../../../../../../../2차포트폴리오/웹페이지/image/logo.png">
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
        <li><a href="../../../../../../../../../2차포트폴리오/웹페이지/html/stadiumList.html">경기장 목록</a></li>
        <li><a href="rankWatch.html">랭킹</a></li>
        <li><a href="#">게시판</a></li>
      </ul>
    </div>
  </header>
  <main id="main">
    <div>　</div>
    <div class="gameListAllContent">
      <div class="gameList-side">
        <div>
          <div>　</div>
          <div>전체 경기</div>
          <div>내가 만든 경기</div>
          <div>내가 참여 중인 경기</div>
        </div>
      </div>
      <div class="gameList-content">
          <form class="findForm">
            <select name="sRegion">
              <option value="전체"<% if(sRegion.equals("전체")) out.print("seleteted"); %>전체</option>
              <option value="서울"<% if(sRegion.equals("서울")) out.print("seleteted"); %>서울</option>
              <option value="인천"<% if(sRegion.equals("인천")) out.print("seleteted"); %>인천</option>
              <option value="경기"<% if(sRegion.equals("경기")) out.print("seleteted"); %>경기</option>
              <option value="충남"<% if(sRegion.equals("충남")) out.print("seleteted"); %>충남</option>
              <option value="충북"<% if(sRegion.equals("충북")) out.print("seleteted"); %>충북</option>
              <option value="대전"<% if(sRegion.equals("대전")) out.print("seleteted"); %>대전</option>
              <option value="대구"<% if(sRegion.equals("대구")) out.print("seleteted"); %>대구</option>
              <option value="경북"<% if(sRegion.equals("경북")) out.print("seleteted"); %>경북</option>
              <option value="경남"<% if(sRegion.equals("경남")) out.print("seleteted"); %>경남</option>
              <option value="울산"<% if(sRegion.equals("울산")) out.print("seleteted"); %>울산</option>
              <option value="부산"<% if(sRegion.equals("부산")) out.print("seleteted"); %>부산</option>
              <option value="전남"<% if(sRegion.equals("전남")) out.print("seleteted"); %>전남</option>
              <option value="전북"<% if(sRegion.equals("전북")) out.print("seleteted"); %>전북</option>
              <option value="광주"<% if(sRegion.equals("광주")) out.print("seleteted"); %>광주</option>
              <option value="강원"<% if(sRegion.equals("강원")) out.print("seleteted"); %>강원</option>
            </select>
            <input type="text" class="search" name="search" name="search" placeholder="경기장 이름 검색">
            <input type="submit" class="findFormSubmit" value="검색" >
          </form>
        <!-- 경기만들기 이동 링크 시작 -->
        <div class="makeGameBtnContainer">
          <a href="gameMake.html">경기 만들기</a>
        </div>
        <!-- 카드 시작 -->
        <div class="cardContainer">
          <!-- 카드 몸체 시작 -->
          <div class="card">
            <!-- profile 시작 -->
            <div onclick="openModal()" class="teamProfileContainer" id="teamProfileContainer" name="teamProfileContainer" >
              <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
              <div class="tName" id="tName" name="tName"> 김허반박이 </div>
            </div>
            <!-- profile 종료 -->
            <!-- 프로필과 카드 본문 나누는 세로선 -->
            <div class="verticalLine"></div>
            <!-- 본문 테이블 시작-->
            <div class="tableContainer">
              <table>
                <tr>
                  <td>경기명 : </td>
                  <td>진짜 뒤지고 싶은 분~~!</td>
                  <td>
                    경기 생성일 :
                  </td>
                  <td>
                    2024-06-11
                  </td>
                </tr>
                <tr>
                  <td>경기장 : </td>
                  <td>천안 축구센터 1 경기장</td>
                </tr>
                <tr>
                  <td>경기장 주소 : </td>
                  <td>두정동 1975</td>
                </tr>
                <tr>
                  <td>경기일시 : </td>
                  <td>2024-06-11 08 : 00 (2 시간)</td>
                </tr>
              </table>
            </div>
            <!-- 본문 테이블 종료-->
          </div>
          <!-- 카드 몸체 종료 -->
          <!-- 카드 submit 시작 -->
          <div>
            <!-- 임시 폼 -->
            <form action="gameInfo.html">
              <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
            </form>
            <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
          </div>
          <!-- 카드 submit 종료 -->
        </div>
        <!-- 카드 종료 -->

        <!-- 카드 시작 -->
        <div class="cardContainer">
          <!-- 카드 몸체 시작 -->
          <div class="card">
            <!-- profile 시작 -->
            <div onclick="openModal()" class="teamProfileContainer" id="teamProfileContainer" name="teamProfileContainer" >
              <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
              <div class="tName" id="tName" name="tName"> 김허반박이 </div>
            </div>
            <!-- profile 종료 -->
            <!-- 프로필과 카드 본문 나누는 세로선 -->
            <div class="verticalLine"></div>
            <!-- 본문 테이블 시작-->
            <div class="tableContainer">
              <table>
                <tr>
                  <td>경기명 : </td>
                  <td>진짜 뒤지고 싶은 분~~!</td>
                  <td>
                    경기 생성일 :
                  </td>
                  <td>
                    2024-06-11
                  </td>
                </tr>
                <tr>
                  <td>경기장 : </td>
                  <td>천안 축구센터 1 경기장</td>
                </tr>
                <tr>
                  <td>경기장 주소 : </td>
                  <td>두정동 1975</td>
                </tr>
                <tr>
                  <td>경기일시 : </td>
                  <td>2024-06-11 08 : 00 (2 시간)</td>
                </tr>
              </table>
            </div>
            <!-- 본문 테이블 종료-->
          </div>
          <!-- 카드 몸체 종료 -->
          <!-- 카드 submit 시작 -->
          <div>
            <!-- 임시 폼 -->
            <form action="gameInfo.html">
              <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
            </form>
            <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
          </div>
          <!-- 카드 submit 종료 -->
        </div>
        <!-- 카드 종료 -->

        <!-- 카드 시작 -->
        <div class="cardContainer">
          <!-- 카드 몸체 시작 -->
          <div class="card">
            <!-- profile 시작 -->
            <div onclick="openModal()" class="teamProfileContainer" id="teamProfileContainer" name="teamProfileContainer" >
              <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
              <div class="tName" id="tName" name="tName"> 김허반박이 </div>
            </div>
            <!-- profile 종료 -->
            <!-- 프로필과 카드 본문 나누는 세로선 -->
            <div class="verticalLine"></div>
            <!-- 본문 테이블 시작-->
            <div class="tableContainer">
              <table>
                <tr>
                  <td>경기명 : </td>
                  <td>진짜 뒤지고 싶은 분~~!</td>
                  <td>
                    경기 생성일 :
                  </td>
                  <td>
                    2024-06-11
                  </td>
                </tr>
                <tr>
                  <td>경기장 : </td>
                  <td>천안 축구센터 1 경기장</td>
                </tr>
                <tr>
                  <td>경기장 주소 : </td>
                  <td>두정동 1975</td>
                </tr>
                <tr>
                  <td>경기일시 : </td>
                  <td>2024-06-11 08 : 00 (2 시간)</td>
                </tr>
              </table>
            </div>
            <!-- 본문 테이블 종료-->
          </div>
          <!-- 카드 몸체 종료 -->
          <!-- 카드 submit 시작 -->
          <div>
            <!-- 임시 폼 -->
            <form action="gameInfo.html">
              <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
            </form>
            <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
          </div>
          <!-- 카드 submit 종료 -->
        </div>
        <!-- 카드 종료 -->

        <!-- 카드 시작 -->
        <div class="cardContainer">
          <!-- 카드 몸체 시작 -->
          <div class="card">
            <!-- profile 시작 -->
            <div onclick="openModal()" class="teamProfileContainer" id="teamProfileContainer" name="teamProfileContainer" >
              <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
              <div class="tName" id="tName" name="tName"> 김허반박이 </div>
            </div>
            <!-- profile 종료 -->
            <!-- 프로필과 카드 본문 나누는 세로선 -->
            <div class="verticalLine"></div>
            <!-- 본문 테이블 시작-->
            <div class="tableContainer">
              <table>
                <tr>
                  <td>경기명 : </td>
                  <td>진짜 뒤지고 싶은 분~~!</td>
                  <td>
                    경기 생성일 :
                  </td>
                  <td>
                    2024-06-11
                  </td>
                </tr>
                <tr>
                  <td>경기장 : </td>
                  <td>천안 축구센터 1 경기장</td>
                </tr>
                <tr>
                  <td>경기장 주소 : </td>
                  <td>두정동 1975</td>
                </tr>
                <tr>
                  <td>경기일시 : </td>
                  <td>2024-06-11 08 : 00 (2 시간)</td>
                </tr>
              </table>
            </div>
            <!-- 본문 테이블 종료-->
          </div>
          <!-- 카드 몸체 종료 -->
          <!-- 카드 submit 시작 -->
          <div>
            <!-- 임시 폼 -->
            <form action="gameInfo.html">
              <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
            </form>
            <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
          </div>
          <!-- 카드 submit 종료 -->
        </div>
        <!-- 카드 종료 -->

        <!-- 카드 시작 -->
        <div class="cardContainer">
          <!-- 카드 몸체 시작 -->
          <div class="card">
            <!-- profile 시작 -->
            <div onclick="openModal()" class="teamProfileContainer" id="teamProfileContainer" name="teamProfileContainer" >
              <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
              <div class="tName" id="tName" name="tName"> 김허반박이 </div>
            </div>
            <!-- profile 종료 -->
            <!-- 프로필과 카드 본문 나누는 세로선 -->
            <div class="verticalLine"></div>
            <!-- 본문 테이블 시작-->
            <div class="tableContainer">
              <table>
                <tr>
                  <td>경기명 : </td>
                  <td>진짜 뒤지고 싶은 분~~!</td>
                  <td>
                    경기 생성일 :
                  </td>
                  <td>
                    2024-06-11
                  </td>
                </tr>
                <tr>
                  <td>경기장 : </td>
                  <td>천안 축구센터 1 경기장</td>
                </tr>
                <tr>
                  <td>경기장 주소 : </td>
                  <td>두정동 1975</td>
                </tr>
                <tr>
                  <td>경기일시 : </td>
                  <td>2024-06-11 08 : 00 (2 시간)</td>
                </tr>
              </table>
            </div>
            <!-- 본문 테이블 종료-->
          </div>
          <!-- 카드 몸체 종료 -->
          <!-- 카드 submit 시작 -->
          <div>
            <!-- 임시 폼 -->
            <form action="gameInfo.html">
              <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
            </form>
            <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
          </div>
          <!-- 카드 submit 종료 -->
        </div>
        <!-- 카드 종료 -->

        <!-- 카드 시작 -->
        <div class="cardContainer">
          <!-- 카드 몸체 시작 -->
          <div class="card">
            <!-- profile 시작 -->
            <div onclick="openModal()" class="teamProfileContainer" id="teamProfileContainer" name="teamProfileContainer" >
              <image class="tLogo" id="tLogo" name="tLogo" src="image/teamLogo.png"></image>
              <div class="tName" id="tName" name="tName"> 김허반박이 </div>
            </div>
            <!-- profile 종료 -->
            <!-- 프로필과 카드 본문 나누는 세로선 -->
            <div class="verticalLine"></div>
            <!-- 본문 테이블 시작-->
            <div class="tableContainer">
              <table>
                <tr>
                  <td>경기명 : </td>
                  <td>진짜 뒤지고 싶은 분~~!</td>
                  <td>
                    경기 생성일 :
                  </td>
                  <td>
                    2024-06-11
                  </td>
                </tr>
                <tr>
                  <td>경기장 : </td>
                  <td>천안 축구센터 1 경기장</td>
                </tr>
                <tr>
                  <td>경기장 주소 : </td>
                  <td>두정동 1975</td>
                </tr>
                <tr>
                  <td>경기일시 : </td>
                  <td>2024-06-11 08 : 00 (2 시간)</td>
                </tr>
              </table>
            </div>
            <!-- 본문 테이블 종료-->
          </div>
          <!-- 카드 몸체 종료 -->
          <!-- 카드 submit 시작 -->
          <div>
            <!-- 임시 폼 -->
            <form action="gameInfo.html">
              <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
            </form>
            <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
          </div>
          <!-- 카드 submit 종료 -->
        </div>
        <!-- 카드 종료 -->
        <!-- pagination 시작 -->
        <div class="paginationContainer">
          <ul class="pagination">
            <li><a href="#">이전</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">다음</a></li>
          </ul>
        </div>
        <!-- pagination 종료 -->
      </div>
      <!-- 컨텐트 종료 지점 -->
    </div>
    <!-- 이름없는 div 종료 -->
  </main>
  <!-- 팀 정보 모달 시작 -->
  <div id="teamInfoModal" class="teamInfoModal">

    <div class="teamprofile-modal">
      <div onclick="closeModal()" class="closebtn">&times;</div>
      <div>
        <img src="image/우사기.jpg">
        <img src="image/축구공.png">
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
  </div>
  <!-- 팀 정보 모달 끝 -->
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