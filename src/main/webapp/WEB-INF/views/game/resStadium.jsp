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
    <script>
        $(document).ready(function() {
            // 첫 번째 Ajax 요청: 경기장 목록 가져오기
            $("#findForm").submit(function(event) {
                event.preventDefault(); // 폼의 기본 제출 동작을 막습니다.

                var sRegion = $("#sRegion").val(); // sRegion 입력 필드의 값을 가져옵니다.
                var search = $("#search").val(); // search 입력 필드의 값을 가져옵니다.

                $.ajax({
                    url: '/game/search/resStadium.do', // 요청할 URL을 설정합니다.
                    type: 'GET', // 요청 방식을 GET으로 설정합니다.
                    data: {
                        sRegion: sRegion, // sRegion 값을 데이터로 전송합니다.
                        search: search, // search 값을 데이터로 전송합니다.
                        responseType: 'json' // 응답 형식을 JSON으로 설정합니다.
                    },
                    success: function(response) {
                        // 요청이 성공하면 실행될 함수를 정의합니다.

                        var stadiumList = response;
                        var html = '';
                        if (stadiumList.length === 0) {
                            // 리스트가 비어 있는 경우
                            html = '<p>경기장 정보가 없습니다.</p>';
                        } else {
                            // 리스트가 비어 있지 않은 경우
                            for (var i = 0; i < stadiumList.length; i++) {
                                // 각 경기장을 목록 항목으로 추가합니다.
                                html += '<form id="stadiumDetailForm-' + i + '" class="stadiumDetailForm">' +
                                            '<input type="hidden" name="sID" value="' + stadiumList[i].sID + '" />' +
                                            '<button type="submit">' + (i + 1) + '. ' + stadiumList[i].sName + '</button>' +
                                        '</form>';
                            }
                        }
                        $("#stadiumDetailInfo").hide();
                        $("#message").show();
                        $("#stadiumList").html(html); // HTML 목록에 경기장 목록을 추가합니다.
                    },
                    error: function(error) {
                        // 요청이 실패하면 실행될 함수를 정의합니다.
                        console.log("Error:", error); // 에러 메시지를 콘솔에 출력합니다.
                    }
                });
            });

            // 이벤트 위임을 사용하여 동적으로 생성된 폼에 이벤트 핸들러를 바인딩합니다.
            $(document).on('submit', '.stadiumDetailForm', function(event) {
                event.preventDefault(); // 폼의 기본 제출 동작을 막습니다.
                var sID = $(this).find("input[name='sID']").val(); // sID 값을 가져옵니다.

                $.ajax({
                    url: '/game/stadiumDetail.do',  // 요청할 URL을 설정
                    type: 'GET',                    // 요청 방식을 GET으로 설정
                    data: { sID: sID },             // sID 값을 데이터로 전송
                    success: function(response) {
                        // 요청이 성공하면 실행될 함수를 정의
                        $("#message").hide();
                        $("#stadiumDetailInfo").show();
                        var stadiumDetail = response;
                        $('#sNameDetail').html(stadiumDetail.sName ? stadiumDetail.sName : '없음');
                        $('#sAddrDetail').html(stadiumDetail.sAddr ? stadiumDetail.sAddr : '없음');
                        $('#sOwnerDetail').html(stadiumDetail.sOwner ? stadiumDetail.sOwner : '없음');
                        $('#sPhoneDetail').html(stadiumDetail.sPhone ? stadiumDetail.sPhone : '없음');

                        var html = '<option disabled selected>경기장 선택하기</option>';
                        for (var i = 1; i <= stadiumDetail.sNum; i++) {
                            html += '<option value="' + i + '">' + i + ' 경기장</option>';
                        }
                        $("#sNumDetail").html(html);
                    },
                    error: function(error) {
                        // 요청이 실패하면 실행될 함수를 정의
                        console.log("Error:", error); // 에러 메시지를 콘솔에 출력합니다.
                    }
                });
            });
        });
    </script>
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
        <!-- 컨텐트 영역 시작 -->
        <div class="resStadium-content">
            <!-- 검색 바 시작 -->
          <form class="findForm" id="findForm">
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
                <form method="get" action="commitstadium">
                    <!-- 경기장 디테일 시작 -->
                    <div class="stadiumDetail">
                        <label><상세정보></label>
                        <div id="message">경기장을 선택해주세요.</div>
                        <ul id="stadiumDetailInfo">
                            <input type="hidden" name="sName" value="1">
                            <li>경기장 명 : <span id="sNameDetail"></span></li>

                            <input type="hidden" name="sAddr" value="1">
                            <li>주소 : <span id="sAddrDetail"></span></li>

                            <input type="hidden" name="sOwner" value="1">
                            <li>관리자 : <span id="sOwnerDetail"></span></li>

                            <input type="hidden" name="sPhone" value="1">
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
                    <td><input type="date" name="gResDate"></td>
                </tr>
                <tr>
                    <td>시작 시작 : </td>
                    <td>
                        <select  name="sTime">
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
                    <td>종료 시작 : </td>
                    <td>
                        <select name="eTime">
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
                        <select name="sNum" id="sNumDetail">
                            <option disabled selected>경기장 선택하기</option>
                        </select>
                    </td>
                </tr>
            </table>
            <!-- 예약 정보 종료 -->
            <!-- 버튼 영역 시작 -->
            <div class="buttonContainer">
                <a href="gameMake.html">취소하기</a>
                <a href="gameMake.html">선택 완료</a>
            </div>
            <!-- 버튼 영역 끝 -->
            </form>
            <!-- form 영역 끝 -->
        </div>
        <!-- 컨텐트 영역 종료 -->
    </div>
    <!-- 이름 없는 div 끝 -->
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


