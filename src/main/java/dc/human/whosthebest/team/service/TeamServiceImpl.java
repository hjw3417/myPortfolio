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

    @Override
    public int insertTeamInfo(TeamInfoVO team) throws Exception {
        return teamDAO.insertTeamInfo(team);
    }

    @Override
    public int insertTeamMember(TeamMemberVO teamMemberVO) throws Exception {
        return teamDAO.insertTeamMember(teamMemberVO);
    };

    @Override
    public List ranking() throws Exception {
        List ranking = null;
        ranking = teamDAO.selectRanking();
        return ranking;
    };

}
