package dc.human.whosthebest.aboutteam.service;

import dc.human.whosthebest.aboutteam.dao.AboutTeamDAO;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameRecordInfoListVO;
import dc.human.whosthebest.vo.GameRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("aboutteamService")
@Transactional(propagation = Propagation.REQUIRED)
public class AboutTeamServiceImpl implements AboutteamService {
    @Autowired
    private AboutTeamDAO aboutTeamDAO;

    @Override
    public List<GameListVO> selectGameSchedule(int pageNum, int rowNum, int tID) throws Exception {
        List<GameListVO> gameListVO = aboutTeamDAO.selectGameSchedule(pageNum, rowNum, tID);
        System.out.println("service gameListVO.size() : " + gameListVO.size());
        return gameListVO;
    }

    @Override
    public GameRecordVO selectGameRecordInfo(int pageNum, int rowNum, int tID, String resultType) throws Exception {
        GameRecordVO gameRecordVO = new GameRecordVO();
        List<GameRecordInfoListVO> gameResultInfoList = new ArrayList<>();

        gameRecordVO = aboutTeamDAO.getMatchCount(tID);
        gameResultInfoList = aboutTeamDAO.selectGResultInfo(pageNum, rowNum, tID, resultType);
        String myTeamName = aboutTeamDAO.myTeamName(tID).gettHomeName();
        if(gameRecordVO != null) {
            gameRecordVO.setGameRecordInfoListVO(gameResultInfoList);
            if(myTeamName != null) {
                gameRecordVO.settName(myTeamName);
                System.out.println("Service myTeamName : " + myTeamName);
            }
        }
        return gameRecordVO;
    }
}
