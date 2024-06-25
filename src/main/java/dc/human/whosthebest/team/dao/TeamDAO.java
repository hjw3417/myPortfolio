package dc.human.whosthebest.team.dao;

import dc.human.whosthebest.vo.MemberVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("memberDAO")
public interface TeamDAO {

    public int insertTeam(TeamInfoVO teamInfoVO) throws DataAccessException;
}
