package dc.human.whosthebest.user.service;

import dc.human.whosthebest.user.dao.UserDAO;
import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service("joinService")
public class UserServiceImpl implements UserService {

    java.util.Date now = new java.util.Date();
    Date sqlDate = new Date(now.getTime());

    @Autowired
    private UserDAO userDAO;


    @Override
    public int loginUser(String uID, String uPW) throws Exception {
        return userDAO.loginUser(uID, uPW);
    }


}
