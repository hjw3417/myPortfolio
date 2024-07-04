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
      success: function(teamProfile) {
        updateTeamInfo(teamProfile);
      },
      error: function(xhr, status, error) {
        console.error('Error:', error);
      }
    });
  });

  function updateTeamInfo(teamProfile) {
      $('#teamprofile').empty();

      var teamProfileHtml = `<div>
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
                             </div>`

      $('#teamprofile').html(teamProfileHtml);
    }
});