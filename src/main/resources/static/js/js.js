//resStadium.do 관련 js 코드 시작
$(document).ready(function() {
    // 첫 번째 Ajax 요청: 경기장 목록 가져오기
    $("#resStadium-findForm").submit(function(event) {
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
//resStadium.do 관련 js 코드 끝

//gameList.do 관련 js 코드 시작
$(document).ready(function() {
    //resStadium.do popup창 클로즈
    function closeWindow() {
             window.close();
         }
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
        sID = parseInt(sID, 10);
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
//gameList.do 관련 js 코드 끝

//gameMake.do에서 데이터 받는 메소드
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

//팝업 창을 여는 함수
function openResStadium(contextPath) {
    var url = contextPath + '/game/resStadium.do';
    var popupWindow = window.open(url, 'resStadium', 'width=630,height=600,scrollbars=yes');
    if (popupWindow) {
        popupWindow.focus();
    } else {
        alert('Popup blocked. Please allow popups for this site.');
    }
}

// 유효성 검사를 하는 함수
function validateForm(formData) {
    for (var key in formData) {
        if (formData.hasOwnProperty(key) && !formData[key]) {
            return false;
        }
    }
    return true;
}

//1. gameMake.do에서 resStadium.do popup 여는 기능
//2. create.do로 데이터 전송 및 유효성 검사 로직 수행
$(document).ready(function() {
    // 팝업 버튼 이벤트 리스너 설정
    $('#hidden1, #popupBtn').on('click', function(event) {
        event.preventDefault();
        openResStadium(contextPath);
    });

    // 폼 제출 시 입력값 검증
    $('#gameMakeForm').on('submit', function(event) {
        var formDataArray = $(this).serializeArray();
        var formData = {};
        $.each(formDataArray, function(_, field) {
            formData[field.name] = field.value;
        });

        // 유효성 검사 함수 호출
        if (!validateForm(formData)) {
            alert('입력되지 않은 사항이 있습니다.');
            event.preventDefault(); // form 제출 중지
            return;
        }

        // 특정 name 값을 가진 요소 찾기
        var gMinMemberField = formDataArray.find(function(field) {
            return field.name === 'gMinMember';
        });

        // gMinMember 유효성 검사
        if (gMinMemberField && (isNaN(Number(gMinMemberField.value)) ||
         !Number.isInteger(Number(gMinMemberField.value)) ||
          Number(gMinMemberField.value) < 0 ||
          Number(gMinMemberField.value) > 99
          )) {
            alert('게임 인원 설정을 다시 해주세요.(최대 인원 99명)');
            event.preventDefault(); // form 제출 중지
        }
    });
});

//gameList.do 관련 js 시작
$(document).ready(function() {
    //game 조회 ajax 모듈
    function selectGameAjax(rowNum, pageNum, sRegion, search, IMakeGameuID, IPartiGameuID) {
        $.ajax({
            url: '/game/filter/gameList.do',   //요청할 url 설정
            type: 'POST',               //요청 방식 POST로 설정
            data: {
                rowNum: rowNum,
                pageNum: pageNum,
                sRegion: sRegion,
                search: search,
                IMakeGameuID: IMakeGameuID,
                IPartiGameuID: IPartiGameuID,
                responseType: 'json' // 응답 형식을 JSON으로 설정
            },
            success: function(response) {
                var gameList = response;
                var html = '';
                // gameList가 null일 시 알림
                alert(gameList.length);
                if (gameList.length === 0) {
                    $("#gameListContainer").empty();
                    html = '<div class="nullMsg">경기 정보가 없습니다.</div>';
                    $("#gameListContainer").html(html);
                } else {
                    alert("else : " + gameList[0].gID);
                    $("#gameListContainer").empty();
                    // 새로운 DOM 업데이트
                    for (var i = 0; i < gameList.length; i++) {
                        var gameListVO = gameList[i];
//                        html += i;
                        html += `
                            <!-- 카드 시작 -->
                            <div class="cardContainer">
                                <!-- 카드 몸체 시작 -->
                                <div class="card">
                                    <!-- profile 시작 -->
                                    <div onclick="openModal()" class="teamProfileContainer">
                                        <img class="tLogo" src="image/teamLogo.png">
                                        <div class="tName" value="${gameListVO.tName}">${gameListVO.tName}</div>
                                    </div>
                                    <!-- profile 종료 -->
                                    <!-- 프로필과 카드 본문 나누는 세로선 -->
                                    <div class="verticalLine"></div>
                                    <!-- 본문 테이블 시작-->
                                    <div class="tableContainer">
                                        <table>
                                            <tr>
                                                <td>경기명 : </td>
                                                <td>${gameListVO.gTitle}</td>
                                                <td>경기 생성일 :</td>
                                                <td>${gameListVO.gCreatedDate}</td>
                                            </tr>
                                            <tr>
                                                <td>경기장 : </td>
                                                <td>${gameListVO.sName} ${gameListVO.sNum} 경기장</td>
                                            </tr>
                                            <tr>
                                                <td>경기장 주소 : </td>
                                                <td>${gameListVO.sAddr}</td>
                                            </tr>
                                            <tr>
                                                <td>경기일시 : </td>
                                                <td>${gameListVO.gResDate} (${gameListVO.gTime} 시간)</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <!-- 본문 테이블 종료-->
                                </div>
                                <!-- 카드 몸체 종료 -->
                                <!-- 카드 submit 시작 -->
                                <div>
                                    <form method="get" action="${contextPath}/game/gameInfo.do">
                                        <input type="hidden" name="gID" value="${gameListVO.gID}" />
                                        <input type="submit" class="cardSubmit" value="경기 상세 보기"/>
                                    </form>
                                    <!-- <a href="gameInfo.html">경기 상세 보기</a> -->
                                </div>
                                <!-- 카드 submit 종료 -->
                            </div>
                            <!-- 카드 시작 -->
                        `;
                    }
                    $("#gameListContainer").append(html); // 최종 HTML을 한 번에 추가
                    alert("sdfsdf");
                }
            },
            error: function(error) {
                //요청 실패 시 메세지 알림
                alert("Error: ", error);
            }
        });
    }
    //game 조회 ajax 모듈
    var defaultPageNum = 1; // 이 값을 JSP에서 받아올 수도 있습니다.

    //page 이동 버튼
    function createPageButtons() {
        $('#pageNumBtnLI').empty(); // 기존 버튼 제거
        for (var i = defaultPageNum; i <= defaultPageNum + 4; i++) {
            $('#pageNumBtnLI').append(`
                <form id="gamList-pageNumForm" class="gamList-pageNumForm">
                    <input type="hidden" class="rowNum" name="rowNum" id="rowNum" value="${i - 1}">
                    <input type="submit" class="pageNum" name="pageNum" value="${i}">
                </form>
            `);
        }
    }
    //page 이동 버튼

    // 초기 페이지 버튼 생성
    createPageButtons();

    $("#nextPage").on('click', function() {
        defaultPageNum += 5;
        createPageButtons(); // 페이지 버튼 다시 생성
    });

    $("#prevPage").on('click', function() {
        defaultPageNum -= 5;
        createPageButtons(); // 페이지 버튼 다시 생성
    });
    //page 버튼 동작 기능(해당 인덱스 버튼에 맞게 gameList 조회)
    $(document).on('submit', '#gamList-pageNumForm', function(event) {
        event.preventDefault();     //폼의 기본 제출 동작을 막습니다.
        var rowNum = $(event.originalEvent?.submitter).siblings('input[name="rowNum"]').val();
        var pageNum = $(event.originalEvent?.submitter).val();
        var sRegion = null;
        var search = null;
        var IMakeGameuID = null;
        var IPartiGameuID = null;
        selectGameAjax(rowNum, pageNum, sRegion, search, IMakeGameuID, IPartiGameuID);
    });
    //page 버튼 동작 기능(해당 인덱스 버튼에 맞게 gameList 조회)
    //side바 필터링 기능
    $('#selectAllGame').on('click', function(event) {
        event.preventDefault();     //폼의 기본 제출 동작을 막습니다.
        var rowNum = 0;
        var pageNum = 1;
        var sRegion = null;
        var search = null;
        var IMakeGameuID = null;
        var IPartiGameuID = null;
        selectGameAjax(rowNum, pageNum, sRegion, search, IMakeGameuID, IPartiGameuID);
    });
    $('#selectIMakeGame').on('click', function(event) {
        event.preventDefault();     //폼의 기본 제출 동작을 막습니다.
        var rowNum = 0;
        var pageNum = 1;
        var sRegion = null;
        var search = null;
        var IMakeGameuID = $("#selectIMakeGame").val();
        var IPartiGameuID = null;
        selectGameAjax(rowNum, pageNum, sRegion, search, IMakeGameuID, IPartiGameuID);
    });
    $('#selectIPartiGame').on('click', function(event) {
        event.preventDefault();     //폼의 기본 제출 동작을 막습니다.
        var rowNum = 0;
        var pageNum = 1;
        var sRegion = null;
        var search = null;
        var IMakeGameuID = null;
        var IPartiGameuID = $("#selectIPartiGame").val();
        selectGameAjax(rowNum, pageNum, sRegion, search, IMakeGameuID, IPartiGameuID);
    });
    //side바 필터링 기능
    //검색 기능
       $('#gameList-findForm').on('submit', function(event) {
           event.preventDefault();     //폼의 기본 제출 동작을 막습니다.
           var rowNum = 0;
           var pageNum = 1;
           var sRegion = $("#sRegion").val();
           var search = $("#search").val();
           var uID = null;
           selectGameAjax(rowNum, pageNum, sRegion, search, uID);
       });
    //검색 기능
});
//gameMake.do 관련 js 끝

//gameInfo.do 관련 js 시작
$(document).ready(function() {
    //경기 참여 Btn value 설정
    $('#startGameBtn').val("경기 참여");

    var $gComent = $('#gComent');
    $gComent.scrollTop($gComent.prop("scrollHeight"));
    // insertCommentAjax 함수 정의
    function insertCommentAjax(gameComments, gameInfoGID) {
        alert("insertCommentAjax 실행 : " + gameComments + gameInfoGID);
        $.ajax({
            url: '/game/comment/gameInfo.do',   // 요청 URL
            type: 'POST',
            data: {
                gComment: gameComments,
                gID: gameInfoGID
            },
            success: function(response) {
                var insertCommentsResult = response;
                var html = '';
                alert("insertCommentsResult.length: " + insertCommentsResult.length)
                $("#gComentConent").hide();
                if(insertCommentsResult.length === 0) {
                    html ='<div class="nullMsg">경기 정보가 없습니다.</div>';
                    $("#gComent").html(html);
                } else {
                    $.each(insertCommentsResult, function(index, gCommentList) {
                        html = `
                            <p><span>${gCommentList.uName} : </span>${gCommentList.gComment}</p>
                        `;
                        $("#gComent").append(html);
                    });
                }
                $gComent.scrollTop($gComent.prop("scrollHeight"));
            },
            error: function(error) {
                // 요청 실패 시 메세지 알림
                alert("Error: " + error);
            }
        });
    }

    //insert HomeTeam Squad Ajax
    function insertHomeTeamSquadAjax(gID, gTeamID) {
        $.ajax({
            url: '/game/partiHome/gameInfo.do',
            type: 'POST',
            data: {
                gID: gID,
                gTeamID: gTeamID
            },
            success: function(response) {
                var gameMemberList = response;
                var html = '';
                if(gameMemberList.length === 0) {
                    alert("이미 참가하였습니다.")
                } else {
                    alert(gameMemberList[0].uID)
                    $("#homeTeamMemberList").empty();
                    $.each(gameMemberList, function(index, gameMember) {
                        var html = `
                            <li>${gameMember.uName}</li>
                        `;
                        $("#homeTeamMemberList").append(html);
                    });
                }
            },
            error: function(error) {
                //요청 실패 시 메세지 알림
                alert("Error: " + error);
            }
        });
    }
    //insert AwayTeam Squad Ajax
    function insertAwayTeamSquadAjax(gID, gTeamID) {
        $.ajax({
            url: '/game/partiAway/gameInfo.do',
            type: 'POST',
            data: {
                gID: gID,
                tAwayID: gTeamID
            },
            dataType: 'json',
            success: function(response) {
                var awayTeamName = response.awayTeamName;
                var awayTeamMemberList = response.awayTeamMemberList;
                var nowPartiMemberNum = response.nowPartiMemberNum;
                var tAwayID = response.tAwayID;
                alert("tAwayID : " + tAwayID);
                var html = '';
                if(awayTeamName == null) {
                    alert("이미 참가하였습니다.")
                } else {
                    alert(awayTeamMemberList[0].uID)
                    $("#awayTeamName").html(awayTeamName);
                    $("#awayTeamMemberList").empty();
                    $.each(awayTeamMemberList, function(index, awayTeamMember) {
                        var html = `
                            <li>${awayTeamMember.uName}</li>
                        `;
                        $("#awayTeamMemberList").append(html);
                    });
                    $("#nowPartiMemberNum").html(nowPartiMemberNum);
                    $("#startGametAwayID").val(tAwayID);
                }
            },
            error: function(error) {
                //요청 실패 시 메세지 알림
                alert("Error: " + error);
            }
        });
    }

    //insert AwayTeam Member Parti ajax
    function insertAwayTeamMemberAjax(gID, gTeamID) {
        $.ajax({
            url: '/game/partiAwayMember/gameInfo.do',
            type: 'POST',
            data: {
                gID: gID,
                tAwayID: gTeamID
            },
            dataType: 'json',
            success: function(response) {
                var awayTeamName = response.awayTeamName;
                var awayTeamMemberList = response.awayTeamMemberList;
                var nowPartiMemberNum = response.nowPartiMemberNum;
                var html = '';
                if(awayTeamName == null) {
                    alert("이미 참가하였습니다.")
                } else {
                    alert(awayTeamMemberList[0].uID)
                    $("#awayTeamName").html(awayTeamName);
                    $("#awayTeamMemberList").empty();
                    $.each(awayTeamMemberList, function(index, awayTeamMember) {
                        var html = `
                            <li>${awayTeamMember.uName}</li>
                        `;
                        $("#awayTeamMemberList").append(html);
                    });
                    $("#nowPartiMemberNum").html(nowPartiMemberNum);
                }
            },
            error: function(error) {
                //요청 실패 시 메세지 알림
                alert("Error: " + error);
            }
        });
    }
    // comment 제출 함수
    $(document).on('submit', '#insertCommentForm', function(event) {
        event.preventDefault(); // 폼의 기본 제출 동작을 막습니다.
        var gameComments = $('#gameComments').val();
        var gameInfoGID = $('#gameInfoGID').val();
        alert("insertCommentForm 실행" + gameComments);
        if(gameComments === '') {
            alert('코멘트를 입력해주세요.');
        } else {
            insertCommentAjax(gameComments, gameInfoGID);
        }
    });

    $('#partiHomeTeamForm').on('submit', function(event) {
        event.preventDefault();     // 폼의 기본 제출 동작을 막습니다.
        var gID = $('#gID').val();
        var gTeamID = $('#homeTeamID').val();
        alert("gID : " + gID)
        insertAwayTeamMemberAjax(gID, gTeamID);
    });

    $('#partiAwayTeamForm').on('submit', function(event) {
            event.preventDefault();     // 폼의 기본 제출 동작을 막습니다.
            var gID = $('#awayGID').val();
            var gTeamID = $('#awayTeamID').val();
            alert("gID : " + gID)
            insertAwayTeamMemberAjax(gID, gTeamID);
        });

    $('.partiAwayTeamLeaderForm').on('submit', function(event) {
            event.preventDefault();     // 폼의 기본 제출 동작을 막습니다.
            // 이벤트가 발생한 제출 버튼의 폼을 참조
            var submitter = $(event.originalEvent.submitter);

            // 현재 폼의 데이터 가져오기
            var gID = submitter.siblings('input[name="awayLeaderGID"]').val();
            var gTeamID = submitter.siblings('input[name="awayLeaderTeamID"]').val();
            alert("gID : " + gID)
            alert("gTeamID : " + gTeamID)
            insertAwayTeamSquadAjax(gID, gTeamID);
        });

});
//gameInfo.do 관련 js 끝

function changeButtons(clickedButtonId, otherButtonId) {
    let $clickedButton = $("#" + clickedButtonId);
    let $otherButton = $("#" + otherButtonId);

    if ($clickedButton.hasClass("teamName")) {
        $clickedButton.removeClass("teamName").addClass("winner").text("승");
        $otherButton.removeClass("teamName").addClass("looser").text("패");
    } else if ($clickedButton.hasClass("winner")) {
        $clickedButton.removeClass("winner").addClass("teamName").text("문주군단");
        $otherButton.removeClass("looser").addClass("teamName").text("개발냥발");
    } else if ($clickedButton.hasClass("looser")) {
        $clickedButton.removeClass("looser").addClass("winner").text("승");
        $otherButton.removeClass("teamName").addClass("looser").text("패");
    }
}

//gameResult.do 관련 js 시작
$(document).ready(function() {
    $('#homeTeamScore').on('input', function() {
        var homeTeamScoreValue = $(this).val();
        $('#homeTeamScoreHidden').val(homeTeamScoreValue);
    });
    $('#awayTeamScore').on('input', function() {
        var awayTeamScoreValue = $(this).val();
        $('#awayTeamScoreHidden').val(awayTeamScoreValue);
    });
})
//gameResult.do 관련 js 끝

//stadiumList.do 관련 js 시작
$(document).ready(function() {
    function stadiumListSearchAjax(sRegion, search) {
        console.log("AJAX 요청 시작");
        $.ajax({
            url: '/game/search/stadiumList.do',
            type: 'POST',
            data: {
                sRegion: sRegion,
                search: search
            },
            dataType: 'json',
            success: function(response) {
                var html = "";
                var stadiumListVO = response;
                alert(stadiumListVO.length);
                if (stadiumListVO.length == 0) {
                    alert("검색 정보가 없습니다.")
                } else {
                    alert(stadiumListVO[0].sName);
                    $("#stadiumListTBody").empty();
                    for (var i = 0; i < stadiumListVO.length; i++) {
                        var stadium = stadiumListVO[i];
                        html += `
                            <tr>
                              <td>${i + 1}</td>
                              <td>${stadium.sName}</td>
                              <td>${stadium.sAddr}</td>
                              <td>${stadium.sNum}</td>
                              <td>${stadium.sOwner}</td>
                            </tr>
                        `;
                    }
                    $("#stadiumListTBody").html(html);
                }
            },
            error: function(xhr, status, error) {
                console.error("AJAX 요청 실패", status, error);
                alert("Error: " + xhr.responseText);
            }
        });
    }

    $(document).on("submit", "#stadiumList-findForm", function(event) {
        event.preventDefault();
        var sRegion = $("#sRegion").val();
        var search = $("#search").val();
        alert("sRegion: " + sRegion);
        alert("search: " + search);
        stadiumListSearchAjax(sRegion, search);
    });
});
//stadiumList.do 관련 js 끝
//gameRecord.do 관련 js 시작
$(document).ready(function() {

    function resultTypeFilterAjax(resultType) {
        alert("ajax 시작");
        $.ajax({
            url: "/team/filter/gameRecord.do",
            type: 'POST',
            data: {
                resultType: resultType
            },
            dataType: 'json',
            success: function(response) {
                alert("resultTypeFilterAjax response 성공");
                alert(response.totalCount);
                var gameRecordVO = response;
                alert(gameRecordVO.gameRecordInfoListVO.length);
                var html = "";
                if(gameRecordVO.gameRecordInfoListVO.length == 0) {
                    alert("조회 결과가 없습니다.")
                } else {
                    alert("조회 결과 출력.")
                    $("#gameRecordContainer").empty();
                    $.each(gameRecordVO.gameRecordInfoListVO, function(index, gameRecord) {
                        html += `
                            <div>
                                <span>${gameRecord.tHomeName}&nbsp;</span>
                                <span>${gameRecord.homeGoal}</span>
                                <span>:</span>
                                <span>${gameRecord.awayGoal}</span>
                                <span>&nbsp;</span>
                                <span>${gameRecord.tAwayName}</span>
                                <span>${gameRecord.gResDate}</span>
                                <span>${gameRecord.resultType}</span>
                            </div>
                        `;
                    });
                    $('#gameRecordContainer').html(html);
                }
            },
            error: function(error) {
                alert("Error: " + error);
            }
        });
    }

    $(document).on("change", "#resultType", function(event) {
        event.preventDefault();
        var resultType = $("#resultType").val();
        resultTypeFilterAjax(resultType)
    });
});
//gameRecord.do 관련 js 끝