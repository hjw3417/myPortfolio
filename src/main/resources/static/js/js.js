//폼 제출 시 Ajax 요청을 통해 서버로부터 경기장 목록 조회 및 표시
//동적으로 생성된 폼에 대해 이벤트 핸들러를 설정하여 선택한 경기장의 세부 정보 조회 및 표시
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

function openResStadium(contextPath) {
        var url = contextPath + '/game/resStadium.do';
        var popupWindow = window.open(url, 'resStadium', 'width=600,height=400,scrollbars=yes');
        if (popupWindow) {
            popupWindow.focus();
        } else {
            alert('Popup blocked. Please allow popups for this site.');
        }
    }