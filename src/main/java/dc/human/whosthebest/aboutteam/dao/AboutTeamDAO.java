package dc.human.whosthebest.aboutteam.dao;

import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameRecordInfoListVO;
import dc.human.whosthebest.vo.GameRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("TeamDAO")
public interface TeamDAO {
    public List<GameListVO> selectGameSchedule(int tID) throws DataAccessException;
    public GameRecordVO getMatchCount(int tID) throws DataAccessException;
    public List<GameRecordInfoListVO> selectGResultInfo(@Param("tID") int tID,
                                                        @Param("resultType") String resultType
                                                        ) throws DataAccessException;
}
