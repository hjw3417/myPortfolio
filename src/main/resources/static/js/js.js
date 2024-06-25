// 문서가 준비되면 실행될 코드를 정의합니다.
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
                // input 요소에 값을 설정
                $('#sIDInput').val(stadiumDetail.sID);
                $('#sNameInput').val(stadiumDetail.sName);
                $('#sAddrInput').val(stadiumDetail.sAddr);
                var html = '<option disabled selected>경기장 선택하기</option>';
                for (var i = 1; i <= stadiumDetail.sNum; i++) {
                    html += '<option value="' + i + '">' + i + ' 경기장</option>';
                }
                $("#sResNum").html(html);
            },
            error: function(error) {
                // 요청이 실패하면 실행될 함수를 정의
                console.log("Error:", error); // 에러 메시지를 콘솔에 출력합니다.
            }
        });
    });
});

//gameMake.do에서 resStadium.do popup창 오픈
function openResStadium(contextPath) {
        var url = contextPath + '/game/resStadium.do';
        var popupWindow = window.open(url, 'resStadium', 'width=630,height=600,scrollbars=yes');
        if (popupWindow) {
            popupWindow.focus();
        } else {
            alert('Popup blocked. Please allow popups for this site.');
        }
    }
//resStadium.do popup창 클로즈
function closeWindow() {
         window.close();
     }
$(document).ready(function() {
    $('#stadiumResConForm').submit(function(event) {
        alert("전송 on")
        event.preventDefault();

        // 값 변수에 저장
        var sID = $('#sIDInput').val();
        var sName = $('#sNameInput').val();
        var sAddr = $('#sAddrInput').val();
        var sResDate = $('#sResDate').val();
        var sResSTime = $('#sResSTime').val();
        var sResETime = $('#sResETime').val();
        var sResNum = $('#sResNum').val();

        // 변수 값들을 alert로 표시
        alert('ID: ' + sID + '\n' +
              'Name: ' + sName + '\n' +
              'Address: ' + sAddr + '\n' +
              'Reservation Date: ' + sResDate + '\n' +
              'Start Time: ' + sResSTime + '\n' +
              'End Time: ' + sResETime + '\n' +
              'Reservation Number: ' + sResNum);
        // null 또는 빈 문자열인지 확인하는 함수
        function isEmpty(value) {
            return value === null || value.trim() === '';
        }

        // 값이 null인지 또는 빈 문자열인지 확인
        if (isEmpty(sID) || isEmpty(sName) || isEmpty(sAddr) || isEmpty(sResSTime) || isEmpty(sResETime) || isEmpty(sResNum)) {
            alert('입력되지 않은 사항이 있습니다.');
            return;
        }

        // 정수로 변환
        sResSTime = parseInt(sResSTime, 10);
        sResETime = parseInt(sResETime, 10);
        var gTime = sResETime - sResSTime;
        // 종료 시간이 더 큰지 확인
        if (gTime <= 0) {
            alert("시간 다시 선택 해주세요.");
            return;
        }

        // 시간을 HH:MM:SS 형식으로 변환
        function formatTime(hour) {
            var hours = hour.toString().padStart(2, '0');
            return hours + ':00';
        }

        // 조합하여 최종 문자열 생성
        var gResDate = sResDate + ' ' + formatTime(sResSTime);

        var stadiumResConFormDate = {
            sID: sID,
            sName: sName,
            sAddr: sAddr,
            gResDate: gResDate,
            gTime: gTime,
            sResNum: sResNum
        };
        //gameMake.do 창으로 데이터 전송
        window.opener.receiveData(stadiumResConFormDate);
        // 팝업 창 닫기
        window.close();
    });
});

function receiveData(stadiumResConFormDate) {

    $('#sID').val(stadiumResConFormDate.sID);
    $('#sName').val(stadiumResConFormDate.sName);
    $('#sAddr').val(stadiumResConFormDate.sAddr);
    $('#gResDate').val(stadiumResConFormDate.gResDate);
    $('#gTime').val(stadiumResConFormDate.gTime);
    $('#sNum').val(stadiumResConFormDate.sResNum);

    $('#sNameText').text(stadiumResConFormDate.sName);
    $('#sAddrText').text(stadiumResConFormDate.sAddr);
    $('#gResDateText').text(stadiumResConFormDate.gResDate);
    $('#gTimeText').text(stadiumResConFormDate.gTime + " 시간");
    $('#sNumText').text(stadiumResConFormDate.sResNum + " 경기장");

    // stadiumResConFormDate 객체의 값을 alert로 표시
    alert('ID: ' + stadiumResConFormDate.sID + '\n' +
          'Name: ' + stadiumResConFormDate.sName + '\n' +
          'Address: ' + stadiumResConFormDate.sAddr + '\n' +
          'Reservation Date: ' + stadiumResConFormDate.gResDate + '\n' +
          'Time: ' + stadiumResConFormDate.gTime + '\n' +
          'Reservation Number: ' + stadiumResConFormDate.sResNum);
    $("#hidden1, #hidden2, #hidden3, #hidden4, #hidden5").hide()
}