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
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/js.js"></script>
  <script>
      <!-- restStadium popup용 contextPath 변수 설정 -->
      var contextPath = '${pageContext.request.contextPath}';
      <!-- game/createGame.do 실패 시 알림-->
  </script>
  <title>경기 만들기</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="../image/logo.png">
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
        <li><a href="${contextPath}/game/gameList.do">경기 목록</a></li>
        <li><a href="${contextPath}/game/stadiumList.do">경기장 목록</a></li>
        <li><a href="/ranking">랭킹</a></li>
        <li><a href="/mainBoard">게시판</a></li>
      </ul>
    </div>
  </header>
<main>
  <div>　</div>
  <div class="gameMake-content">
    <c:choose>
        <c:when test="${not empty gameVO.sName}">
            <form id="modGameForm" method="post" action="/game/modGame.do">
            <input type="hidden" name="gID" value="${gameVO.gID}">
        </c:when>
        <c:otherwise>
            <form id="gameMakeForm" method="post" action="/game/createGame.do">
        </c:otherwise>
    </c:choose>
    <table class="inputTable">
           <tr>
            <td colspan="3" style="background-color: white; border: 2pt solid rgb(184, 206, 146); height: 40px;">
            <c:choose>
                <c:when test="${gameVO.sID != 0}">
                    <input type="hidden" id="sID" class="sID" name="sID" value="${gameVO.sID}" />
                    <input type="hidden" id="sName" class="sName" name="sName" value="${gameVO.sName}" />
                    <button id="popupBtn"><span id="sNameText">${gameVO.sName}</span></button>
                </c:when>
                <c:otherwise>
                    <button id="hidden1">경기장 선택하기</button>
                    <input type="hidden" id="sID" class="sID" name="sID" />
                    <input type="hidden" id="sName" class="sName" name="sName" />
                    <button id="popupBtn"><span id="sNameText"></span></button>
                </c:otherwise>
            </c:choose>
            </td>
          </tr>
          <tr>
            <td style="background-color: white; border: 2pt solid rgb(184, 206, 146);  font-size: 8pt; height: 30px;">
                <c:choose>
                    <c:when test="${not empty gameVO.gResDate}">
                        <input type="hidden" id="gResDate" name="gResDate" value="${gameVO.gResDate}">
                        <span id="gResDateText">${gameVO.gResDate}</span>
                    </c:when>
                    <c:otherwise>
                        <span id="hidden2">선택 정보 없음</span>
                        <input type="hidden" id="gResDate" name="gResDate">
                        <span id="gResDateText"></span>
                    </c:otherwise>
                </c:choose>
            </td>
            <td style="background-color: white; border: 2pt solid rgb(184, 206, 146);  font-size: 8pt;height: 30px;">
              <c:choose>
                  <c:when test="${not empty gameVO.sAddr}">
                      <input type="hidden" id="sAddr" name="sAddr" value="${gameVO.sAddr}">
                      <span id="sAddrText">${gameVO.sAddr}</span>
                  </c:when>
                  <c:otherwise>
                      <span id="hidden3">선택 정보 없음</span>
                      <input type="hidden" id="sAddr" name="sAddr">
                      <span id="sAddrText"></span>
                  </c:otherwise>
              </c:choose>
            </td>
            </tr>
            <tr>
              <td style="background-color: white; border: 2pt solid rgb(184, 206, 146);  height: 30px;">
              <c:choose>
                  <c:when test="${gameVO.gTime != 0}">
                      <input type="hidden" id="gTime" name="gTime" value="${gameVO.gTime}">
                      <span id="gTimeText">${gameVO.gTime} 시간</span>
                  </c:when>
                  <c:otherwise>
                      <span id="hidden4">선택 정보 없음</span>
                      <input type="hidden" id="gTime" name="gTime">
                      <span id="gTimeText"></span>
                  </c:otherwise>
              </c:choose>
              </td>

              <td style="background-color: white; border: 2pt solid rgb(184, 206, 146);  height: 30px;">
                  <c:choose>
                      <c:when test="${gameVO.sNum != 0}">
                          <input type="hidden" id="sNum" name="sNum" value="${gameVO.sNum}">
                          <span id="sNumText">${gameVO.sNum} 경기장</span>
                      </c:when>
                      <c:otherwise>
                        <span id="hidden5">선택 정보 없음</span>
                        <input type="hidden" id="sNum" name="sNum">
                        <span id="sNumText"></span>
                      </c:otherwise>
                  </c:choose>
              </td>
            </tr>
      <tr>
        <td colspan="4">
            <select name="gTeamID" id="gTeamID">
                <c:choose>
                    <c:when test="${gameVO.gTeamID != 0}">
                        <c:forEach var="team" items="${teamNameList}">
                            <c:choose>
                                <c:when test="${team.tID eq gameVO.gTeamID}">
                                    <option value="${team.tID}" selected>${team.tName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${team.tID}">${team.tName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <option value="">팀 선택하기</option>
                        <c:forEach var="team" items="${teamNameList}">
                            <option value="${team.tID}">${team.tName}</option>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </select>
        </td>
      </tr>
      <tr>
        <td colspan="4">
         <c:choose>
             <c:when test="${not empty gameVO.gTitle}">
                 <input type="text" name="gTitle" id="gTitle" placeholder="경기 제목을 입력하세요." value="${gameVO.gTitle}">
             </c:when>
             <c:otherwise>
                 <input type="text" name="gTitle" id="gTitle" placeholder="경기 제목을 입력하세요." value="">
             </c:otherwise>
         </c:choose>
        </td>
      </tr>
      <tr>
        <td colspan="4">
          <c:choose>
              <c:when test="${not empty gameVO.gTag}">
                  <input type="text" name="gTag" id="gTag" placeholder="해시태그를 입력해주세요.(#로 구분)"
                         value="${gameVO.gTag}">
              </c:when>
              <c:otherwise>
                  <input type="text" name="gTag" id="gTag" placeholder="해시태그를 입력해주세요.(#로 구분)" value="">
              </c:otherwise>
          </c:choose>
        </td>
      </tr>

        <tr>
          <td colspan="4">
            <c:choose>
                <c:when test="${gameVO.gMinMember != 0}">
                    <input type="text" name="gMinMember" placeholder="참여 인원 설정하기" value="${gameVO.gMinMember}">
                </c:when>
                <c:otherwise>
                    <input type="text" name="gMinMember" placeholder="참여 인원 설정하기" value="">
                </c:otherwise>
            </c:choose>
          </td>
        </tr>
        <tr>
          <td colspan="4"  style="height: 300px; margin: 0;">
            <c:choose>
                <c:when test="${not empty gameVO.gInfo}">
                    <textarea id="gInfo" name="gInfo" placeholder="공지사항을 입력하기">${gameVO.gInfo}</textarea>
                </c:when>
                <c:otherwise>
                    <textarea id="gInfo" name="gInfo" placeholder="공지사항을 입력하기"></textarea>
                </c:otherwise>
            </c:choose>
          </td>
        </tr>
        <tr>
          <td style="background-color: rgb(146, 172, 101); height: 40px;">
            <a href="#">저장</a>
          </td>
          <td style="background-color: rgb(146, 172, 101); height: 40px;">
            <input class="gameMakeSubmit" type="submit" value="<c:choose><c:when test='${not empty gameVO.sName}'>수정하기</c:when><c:otherwise>게임 만들기</c:otherwise></c:choose>" />
          </td>
        </tr>
      </table>
      </form>
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
