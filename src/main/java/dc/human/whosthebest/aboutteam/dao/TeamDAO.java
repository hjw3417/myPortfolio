package dc.human.whosthebest.aboutteam.dao;

import dc.human.whosthebest.vo.GameListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("TeamDAO")
public interface TeamDAO {
    public List<GameListVO> selectGameSchedule(int tID) throws DataAccessException;
}
