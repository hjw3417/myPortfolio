package dc.human.whosthebest.user.dao;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("joinDAO")
public interface JoinDAO {
    public int insertJoin (UserInfoVO userInfoVO) throws DataAccessException;
}
