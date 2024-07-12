$(document).ready(function() {
  // 팀 이름을 클릭했을 때의 처리
  $('#teamNameList .team-link').click(function(e) {
    e.preventDefault();
    var tID = $(this).data('tid');
    var url = contextPath+'/api/teamInfo?tID=' + tID; // Spring MVC에서 URL 매핑을 사용할 수 있는 방법

    $.ajax({
      url: url,
      type: 'GET',
      dataType: 'json',
      success: function(response) {
        var teamProfile = response.teamProfile;
        var gameList = response.gameList;

        updateTeamProfile(teamProfile);
        updateTeamRecord(teamProfile.gameRecordVO.gameRecordInfoListVO);
        updateTeamSchedule(gameList);
      },
      error: function(xhr, status, error) {
        console.error('Error:', error);
      }
    });
  });

  function updateTeamProfile(teamProfile) {
    $('#teamprofile').empty();

    var teamProfileHtml =`
      <div>
        <div>
          <div>
            <img src="${contextPath}/image/우사기.jpg">
          </div>
          <div>
            <span>${teamProfile.rankName}</span>
            <span>${teamProfile.tRankScore}</span>
          </div>
        </div>
        <div>
          <div>
            <span>${teamProfile.tName}</span>
          </div>
          <div>
            <span>전적 : </span>
            <span>${teamProfile.gameRecordVO.totalCount}전
                  ${teamProfile.gameRecordVO.winCount}승
                  ${teamProfile.gameRecordVO.loseCount}패
            </span>
          </div>
          <div>
            <span>팀원 수 : </span>
            <span>${teamProfile.tMember}명</span>
          </div>
          <div>
            <span>창단일 : </span>
            <span>${teamProfile.createdDate}</span>
          </div>
        </div>
      </div>
      `;
      $('#teamprofile').html(teamProfileHtml);
  }

  function updateTeamRecord(gameRecordInfoList) {
    $('#record ul').empty(); // 기존 목록 비우기

    gameRecordInfoList.slice(0, 4).forEach(function(match) {
      var matchHtml = `
        <li>
          <span>${match.tHomeName}</span>
          <span>&nbsp;${match.homeGoal}&nbsp;</span>
          <span>:</span>
          <span>&nbsp;${match.awayGoal}&nbsp;</span>
          <span>${match.tAwayName}</span>
          <span>${match.resultType}</span>
        </li>
      `;
      $('#record ul').append(matchHtml);
    });
  }

  // 팀 스케줄 업데이트 함수
  function updateTeamSchedule(gameList) {
    $('#schedule ul').empty(); // 기존 목록 비우기

        gameList.slice(0, 4).forEach(function(game) {
          var gameHtml = `
              <li>
                <span>${game.gResDate} ${game.sName}</span>
              </li>
          `;
          $('#schedule ul').append(gameHtml);
        });
  }

});
