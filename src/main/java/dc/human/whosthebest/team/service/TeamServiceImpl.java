package dc.human.whosthebest.team.service;

import dc.human.whosthebest.team.dao.TeamDAO;
import dc.human.whosthebest.vo.TeamInfoVO;
import dc.human.whosthebest.vo.TeamMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teamService")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDAO teamDAO;

    @Override
    public List listTeams() throws Exception {
        List teamsList = null;
        teamsList = teamDAO.selectTeamList();
        return teamsList;
    }

    //팀 생성 메소드
    @Override
    public int insertTeamInfo(TeamInfoVO team) throws Exception {
        return teamDAO.insertTeamInfo(team);
    }

    //팀 가입하기 메소드
    @Override
    public int insertTeamMember(TeamMemberVO teamMemberVO) throws Exception {
        return teamDAO.insertTeamMember(teamMemberVO);
    };

    //팀 생성과 동시에 팀장 정보 team_member 테이블에 저장을 위한 메소드
    //insertTeamInfo 안에 insertTeamMember 넣어 구현
    //Service 단에서 처리하기 위해서는 이러한 작업이 필요함
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int createTeamAndAddMember(TeamInfoVO teamInfo, String userID) throws Exception {
        teamInfo.setCreatedID(userID);
        int createTeamAndAddMemberResult = teamDAO.insertTeamInfo(teamInfo);

        if(createTeamAndAddMemberResult >0) {
            TeamMemberVO teamMember = new TeamMemberVO();
            teamMember.setCreatedID(userID);
            teamMember.setuID(userID);
            teamMember.settID(teamInfo.gettID());
            teamDAO.insertTeamMember(teamMember);
        } else {
            throw new Exception("Team 생성 실패");
        }
        return createTeamAndAddMemberResult;
    };

    @Override
    public List<TeamInfoVO> getTeamsByUserId(String userID) throws Exception{
        return teamDAO.selectTeamsByUserId(userID);
    };

    @Override
    public TeamInfoVO getTeamInfoById(int tID) throws Exception {
        return teamDAO.selectTeamInfoById(tID);
    }

    @Override
    public List ranking() throws Exception {
        List ranking = null;
        ranking = teamDAO.selectRanking();
        return ranking;
    };

}
