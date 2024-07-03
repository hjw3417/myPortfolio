package dc.human.whosthebest.main.dao;

import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("mainDAO")
public interface MainDAO {
    List<TeamInfoVO> mainRanking() throws DataAccessException;
    List<GameListVO> mainGameList() throws DataAccessException;
}
