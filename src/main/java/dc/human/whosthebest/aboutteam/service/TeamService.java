package dc.human.whosthebest.aboutteam.service;

import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameRecordVO;

import java.util.List;

public interface TeamService {
    public List<GameListVO> selectGameSchedule(int pageNum, int rowNum, int tID) throws Exception;
    public GameRecordVO selectGameRecordInfo(int pageNum, int rowNum, int tID, String resultType) throws Exception;
}
