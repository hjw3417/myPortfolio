package dc.human.whosthebest.user.service;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public int insertJoin(UserInfoVO userInfoVO);
    public int checkId (String uID) throws Exception;
    public int loginUser (String uID, String uPW) throws Exception;
    public String findID (String uName, String uBday, String uPhone) throws Exception;
    public String findPW (String uName, String uBday, String uPhone, String uID) throws Exception;
}
