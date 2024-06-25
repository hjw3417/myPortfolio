package dc.human.whosthebest.team.service;

import dc.human.whosthebest.dao.MemberDAO;
import dc.human.whosthebest.service.MemberService;
import dc.human.whosthebest.team.dao.TeamDAO;
import dc.human.whosthebest.vo.MemberVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDAO teamDAO;

    @Override
    public int addTeam(TeamInfoVO team) throws Exception {
        return teamDAO.insertTeam(team);
    }
}
