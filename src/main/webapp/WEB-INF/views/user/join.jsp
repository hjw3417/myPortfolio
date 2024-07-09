<!DOCTYPE html>
<html lang="ko">
<head>
  <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/main.css">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
      };

      function checkId(){
              var uId =  $("#uID").val();

        if (uId.trim() === ""){
            alert("ID를 입력하세요.");
            return;
        }
        $.ajax({
            url : "${contextPath}/checkId",
            type : "post",
            async:true,
            data : {uID : uId},
            dataType:"json",
            success:function(data, textStatus){
                if(!data){
                    alert("중복된 아이디입니다.");
                } else {
                    alert("사용 가능한 아이디입니다.");
                }
            },
            error:function(data, textStatus){
                alert("에러입니다");
            }
        });
    };



  </script>
  <title>join</title>
</head>
<body>
  <header>
    <div class="logo">
      <img src="${contextPath}/image/logo.png">
      <!-- <div>누가 잘차</div> -->
    </div>
    <div>
      <span><a href="/login">로그인</a>&nbsp;&nbsp;|&nbsp;</span>
      <span><a href="/join">회원가입</a></span>
    </div>
    <div>
      <ul></ul>
    </div>
  </header>
  <main style="text-align: center; height: 850px;">
    <div>　</div>
    <div>
      <section class="join">
        <div>
          회원가입
        </div>
        <div>
          <form name="join" method="post" action="/join.do" modelAttribute="UserInfoVO">
            <div>

              <input type="text" id="uID" name="uID" size="12" maxlength="12" placeholder="아이디를 입력해주세요." required>
              <input type="button" value="아이디 중복" id="idCheck" onclick="checkId();">
            </div>
            <div>
              <input type="password" name="uPW" size="20" minlength="9" maxlength="20" placeholder="비밀번호를 입력해주세요." required>
              <div>
                영문, 숫자, 특수문자 사용하여 9글자 이상 20글자 이내로 작성바랍니다.
              </div>
            </div>
            <div>
              <input type="password" name="join_pw_con" size="20" minlength="9" maxlength="20" placeholder="비밀번호를 확인해주세요.">
            </div>
            <div>
              <input type="text" name="uName" placeholder="이름을 입력해주세요.">
            </div>
            <div>
              <input type="text" name="uBday" placeholder="생년월일 8자리를 입력해주세요.">
            </div>
            <div>
              <div>
                <input type="radio" id="man" name="uGender" value="남자">
                <label for="man">남자</label>
              </div>
              <div>
                <input type="radio" id="woman" name="uGender" value="여자">
                <label for="woman">여자</label>
              </div>
            </div>
            <div>
              <!--api 출처 https://postcode.map.daum.net/guide-->
              <input type="text" name="join_postcode" id="postcode" placeholder="우편번호">
              <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
            </div>
            <div>
              <input type="text" name="uAddr1" id="roadAddress" placeholder="도로명주소">
              <input type="text" name="join_jibunAddress" id="jibunAddress" placeholder="지번주소">
            </div>
            <div>
              <input type="text" name="uAddr2" id="detailAddress" placeholder="상세주소를 입력해주세요.">
            </div>
            <div>
              <input type="email" name="uEmail" placeholder="이메일 주소를 입력해주세요.">
            </div>
            <div>
              <input type="text" name="uPhone" size="11" maxlength="11" placeholder="휴대폰 번호를 입력해주세요.">
            </div>
            <div>
              <input type="submit" value="가입하기">
             <input type="reset" value="취소">
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