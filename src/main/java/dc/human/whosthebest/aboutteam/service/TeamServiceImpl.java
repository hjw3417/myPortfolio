package dc.human.whosthebest.aboutteam.service;

import dc.human.whosthebest.aboutteam.dao.TeamDAO;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("aboutteamService")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDAO teamDAO;

    @Override
    public List<GameListVO> selectGameSchedule(int tID) throws Exception {
        List<GameListVO> gameList = teamDAO.selectGameSchedule(tID);
        return gameList;
    }

    @Override
    public GameRecordVO selectGaameRecordInfo(int tID) throws Exception {
        GameRecordVO gameRecordVO = new GameRecordVO();
        int getTotalMatchCountResult = teamDAO.getTotalMatchCount(tID);
        gameRecordVO.setTotalMatchCount(getTotalMatchCountResult);
        return gameRecordVO;
    }
}
