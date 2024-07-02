package dc.human.whosthebest.user.service;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.catalina.User;

public interface UserService {

    public int loginUser (String uID, String uPW) throws Exception;

}
