package dc.human.whosthebest.user.service;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.catalina.User;

public interface UserService {
    public int insertJoin(UserInfoVO userInfoVO);
    public int checkId (String uID) throws Exception;
    public int loginUser (String uID, String uPW) throws Exception;
    public int findID (String uName, String uBday, String uPhone) throws Exception;
}
