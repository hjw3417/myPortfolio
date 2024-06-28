package dc.human.whosthebest.user.dao;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userDAO")
public interface UserDAO {
    public int insertJoin (UserInfoVO userInfoVO) throws DataAccessException;
    public int checkID (String uID) throws DataAccessException;
    public int loginUser (String uID, String uPW) throws DataAccessException;
    public int findID (String uID, String uBday, String uPhone) throws DataAccessException;
}
