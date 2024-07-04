<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/myPage.css">

  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
      //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
      function sample4_execDaumPostcode() {
          new daum.Postcode({
              oncomplete: function(data) {
                  // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                  // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                  // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                  var roadAddr = data.roadAddress; // 도로명 주소 변수
                  var extraRoadAddr = ''; // 참고 항목 변수

                  // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                  // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                  if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                      extraRoadAddr += data.bname;
                  }
                  // 건물명이 있고, 공동주택일 경우 추가한다.
                  if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                  }
                  // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                  if(extraRoadAddr !== ''){
                      extraRoadAddr = ' (' + extraRoadAddr + ')';
                  }

                  // 우편번호와 주소 정보를 해당 필드에 넣는다.
                  document.getElementById('postcode').value = data.zonecode;
                  document.getElementById("roadAddress").value = roadAddr;
                  document.getElementById("jibunAddress").value = data.jibunAddress;

                  // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                  if(roadAddr !== ''){
                      document.getElementById("extraAddress").value = extraRoadAddr;
                  } else {
                      document.getElementById("extraAddress").value = '';
                  }

                  var guideTextBox = document.getElementById("guide");
                  // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                  if(data.autoRoadAddress) {
                      var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                      guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                      guideTextBox.style.display = 'block';

                  } else if(data.autoJibunAddress) {
                      var expJibunAddr = data.autoJibunAddress;
                      guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                      guideTextBox.style.display = 'block';
                  } else {
                      guideTextBox.innerHTML = '';
                      guideTextBox.style.display = 'none';
                  }
              }
          }).open();
      }
  </script>
  <title>회원정보수정</title>
</head>
<body>
  <header>
    <header>
      <div class="logo">
        <img src="../image/logo.png">
        <!-- <div>누가 잘차</div> -->
      </div>

    <div>
      <span><a href="#">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="myPage.html">마이페이지</a></span>
    </div>
    <div>
      <ul></ul>
    </div>
  </header>


  <main >
    <h1> 회원정보 수정</h1>
    <!-- 사이드 바 -->
    <div class="side">

      <ul style="list-style-type: none;">
        <li> <a href="myPage.html"> 마이페이지 </a> </li>
        <li> <a href="myTeamGameRecord.html"> 경기 결과 </a> </li>
        <li><a href="updateMyInfoPage.html">정보 수정 </a> </li>
      </ul>
  </div>
    <div>　</div>
    <div>
      <section class="updateMyInfo">
        <div></div> <!--삭제 x-->
        <div>
          <form name="updateMyInfo" method="post" action="/myPage/updateMyInfo" onsubmit="return validatePassword()" enctype="utf-8">
            <c:forEach items="${allMyInfo}" var="all">
            <div>
                <input type="text" name="uID" size="12" maxlength="12" value="${all.uID}" readonly>
              <input type="button" value="아이디 중복" disabled >
            </div>
            <div>
              <input type="password" id="uPW" name="update_pw" size="20" minlength="9" maxlength="20" placeholder="변경할 비밀번호를 입력해주세요."  required>
              <div>
                영문, 숫자, 특수문자 사용하여 9글자 이상 20글자 이내로 작성바랍니다.
              </div>
            </div>
            <div>
              <input type="password" id="confirmPw" name="update_pw_con" size="20" minlength="9" maxlength="20" placeholder="비밀번호를 확인해주세요.">
            </div>
             <script type="text/javascript">
                        function validatePassword() {
                            var password = document.getElementById("uPW").value;
                            var confirmPassword = document.getElementById("confirmPw").value;

                            if (password != confirmPassword) {
                                alert("비밀번호가 일치하지 않습니다.");
                                return false;
                            }
                            return true;
                        }
                    </script>
            <div>
              <input type="text" name="uName"  value="${all.uName}" placeholder="이름을 입력해주세요."  readonly>
            </div>
            <div>
              <input type="text" name="uBday" value="${all.uBday}" placeholder="생년월일 8자리를 입력해주세요.">
            </div>
            <div></div> <!--삭제 x-->
            <div>
              <!--api 출처 https://postcode.map.daum.net/guide-->
              <input type="text" name="update_postcode" id="postcode" placeholder="우편번호">
              <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
            </div>
            <div>
              <input type="text" name="uAddr1" id="roadAddress" value="${all.uAddr1}" placeholder="도로명주소">
              <input type="text" name="update_jibunAddress" id="jibunAddress"  placeholder="지번주소">
            </div>
            <div>
              <input type="text" name="uAddr2" id="detailAddress" value="${all.uAddr2}" placeholder="상세주소를 입력해주세요.">
            </div>
            <div>
              <input type="email" name="uEmail" value="${all.uEmail}" placeholder="이메일 주소를 입력해주세요.">
            </div>
            <div>
              <input type="text" name="uPhone" size="11" maxlength="11" value="${all.uPhone}" placeholder="휴대폰 번호를 입력해주세요.">
            </div>
           </c:forEach>
            <div>
              <input type="submit" value="수정하기">
              <button type="button" > 취소 </button>
            </div>

          </form>
        </div>
      </section>
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