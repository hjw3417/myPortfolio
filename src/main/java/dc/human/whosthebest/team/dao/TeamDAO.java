package dc.human.whosthebest.team.dao;


import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("teamDAO")
public interface TeamDAO {
    public List selectTeamList() throws DataAccessException;
    public int insertTeamInfo(TeamInfoVO teamInfoVO) throws DataAccessException;
}
