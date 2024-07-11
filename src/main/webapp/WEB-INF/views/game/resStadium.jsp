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
    <title>경기 만들기</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.js"></script>
</head>
<body class="resStadiumBody">
        <div class="resStadium-content">
            <!-- 검색 바 시작 -->
          <form class="findForm" id="resStadium-findForm">
                <select name="sRegion" id="sRegion">
                    <option value="">전체</option>
                    <option value="A">서울</option>
                    <option value="B">경기</option>
                    <option value="C">인천</option>
                    <option value="D">강원</option>
                    <option value="E">충남</option>
                    <option value="F">충북</option>
                    <option value="G">대전</option>
                    <option value="H">경북</option>
                    <option value="I">대구</option>
                    <option value="J">경남</option>
                    <option value="K">울산</option>
                    <option value="L">부산</option>
                    <option value="M">광주</option>
                    <option value="N">전북</option>
                    <option value="O">전남</option>
                    <option value="P">제주</option>
                </select>
                <input type="text" class="search" name="search" id="search" placeholder="경기장 이름 검색">
                <input type="submit" class="findFormSubmit" id="findFormSubmit" value="검색" >
            </form>
            <!-- 검색 바 끝 -->
            <!-- 경기장 정보 시작 -->
            <div class="stadiumContainer">
                <!-- 경기장 List 시작 -->
                <div class="stadiumList">
                    <label><경기장 목록></label>
                    <ul id="stadiumList">
                        <!-- game/resStadium.do 에서 전달 받은 stadiumList.sName 표시(ajax, mav 모두 같은 값 반환 -->
                        <c:forEach var="stadiumVO" items="${stadiumList}" varStatus="status">
                            <li >
                                <form id="stadiumDetailForm" class="stadiumDetailForm">
                                    <input type="hidden" name="sID" id="sID" value="${stadiumVO.sID}" />
                                    <button id="sName">${status.index + 1}. ${stadiumVO.sName}</button>
                                </form>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <!-- 경기장 List 끝 -->
                <!-- 경기장 form 시작 -->
                <form id="stadiumResConForm">
                    <!-- 경기장
                    디테일 시작 -->
                    <div class="stadiumDetail">
                        <label><상세정보></label>
                        <div id="message">경기장을 선택해주세요.</div>
                        <ul id="stadiumDetailInfo">
                            <input type="hidden" name="sId" id="sIDInput">
                            <input type="hidden" name="sName" id="sNameInput">
                            <li>경기장 명 : <span id="sNameDetail"></span></li>

                            <input type="hidden" name="sAddr" id="sAddrInput">
                            <li>주소 : <span id="sAddrDetail"></span></li>

                            <input type="hidden" name="sOwner" id="sOwnerInput">
                            <li>관리자 : <span id="sOwnerDetail"></span></li>

                            <input type="hidden" name="sPhone" id="sPhoneInput">
                            <li>연락처 : <span id="sPhoneDetail"></span></li>
                        </ul>
                    </div>
                    <!-- 경기장 디테일 끝 -->
            </div>
            <!-- 경기장 정보 끝 -->
            <!-- 예약 정보 시작 -->
            <table class="resInfoContainer">
                <tr>
                    <td>예약일 : </td>
                    <td><input type="date" name="sResDate" id="sResDate"></td>
                </tr>
                <tr>
                    <td>시작 시간 : </td>
                    <td>
                        <select  name="sResSTime" id="sResSTime">
                            <option selected disabled>시작 시간 선택</option>
                            <option value="8">08 : 00</option>
                            <option value="9">09 : 00</option>
                            <option value="10">10 : 00</option>
                            <option value="11">11 : 00</option>
                            <option value="12">12 : 00</option>
                            <option value="13">01 : 00</option>
                            <option value="14">02 : 00</option>
                            <option value="15">03 : 00</option>
                            <option value="16">04 : 00</option>
                            <option value="17">05 : 00</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>종료 시간 : </td>
                    <td>
                        <select name="sResETime" id="sResETime">
                            <option selected disabled>종료 시간 선택</option>
                            <option value="8">08 : 00</option>
                            <option value="9">09 : 00</option>
                            <option value="10">10 : 00</option>
                            <option value="11">11 : 00</option>
                            <option value="12">12 : 00</option>
                            <option value="13">01 : 00</option>
                            <option value="14">02 : 00</option>
                            <option value="15">03 : 00</option>
                            <option value="16">04 : 00</option>
                            <option value="17">05 : 00</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>경기장 선택 : </td>
                    <td>
                        <select name="sResNum" id="sResNum">
                            <option disabled selected>경기장 선택하기</option>
                        </select>
                    </td>
                </tr>
            </table>
            <!-- 예약 정보 종료 -->
            <!-- 버튼 영역 시작 -->
            <div class="buttonContainer">
                <a onclick="closeWindow()">취소하기</a>
                <input type="submit" value="선택완료">
            </div>
            <!-- 버튼 영역 끝 -->
            </form>
            <!-- form 영역 끝 -->
        </div>
        <!-- 컨텐트 영역 종료 -->
      </div>
</body>
</html>


