package dc.human.whosthebest.team.service;

import dc.human.whosthebest.team.dao.TeamDAO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("teamService")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDAO teamDAO;

    @Override
    public int addTeam(TeamInfoVO team) throws Exception {
        return teamDAO.insertTeamInfo(team);
    }
}
