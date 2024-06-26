package dc.human.whosthebest.team.dao;


import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("teamDAO")
public interface TeamDAO {

    public int insertTeamInfo(TeamInfoVO teamInfoVO) throws DataAccessException;
}
