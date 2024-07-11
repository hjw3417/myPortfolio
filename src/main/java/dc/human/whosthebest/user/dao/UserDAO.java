package dc.human.whosthebest.user.dao;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userDAO")
public interface UserDAO {
    int insertJoin (UserInfoVO userInfoVO) throws DataAccessException;
    int checkID (String uID) throws DataAccessException;
    int loginUser (String uID, String uPW) throws DataAccessException;
    String findID (String uName, String uBday, String uPhone) throws DataAccessException;
    String findPW (String uName, String uBday, String uPhone, String uID) throws DataAccessException;
}
