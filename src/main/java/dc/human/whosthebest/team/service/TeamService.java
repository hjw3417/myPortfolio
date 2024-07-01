package dc.human.whosthebest.team.service;

import dc.human.whosthebest.vo.MemberVO;
import dc.human.whosthebest.vo.TeamInfoVO;

import java.util.List;

public interface TeamService {
    public List listTeams() throws Exception;
    public int addTeam(TeamInfoVO teamInfoVO) throws Exception;
}
