package dc.human.whosthebest.user.service;

import dc.human.whosthebest.vo.UserInfoVO;

public interface UserService {
    public int insertJoin(UserInfoVO userInfoVO);
    public int checkId (String uID) throws Exception;
    public int loginUser (String uID, String uPW) throws Exception;
}
