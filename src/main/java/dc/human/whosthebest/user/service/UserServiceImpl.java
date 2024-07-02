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
    public int insertJoin(UserInfoVO userInfoVO){
        userInfoVO.setCreatedID(userInfoVO.getuID());
        userInfoVO.setCreatedDate(sqlDate.toString());
        return userDAO.insertJoin(userInfoVO);
    }

    @Override
    public int checkId (String uID) throws Exception{
        return userDAO.checkID(uID);
    }

    @Override
    public int loginUser (String uID, String uPW) throws Exception{
        return userDAO.loginUser(uID, uPW);
    }

    @Override
    public String findID (String uName, String uBday, String uPhone) throws Exception{
        System.out.println("uName: " + uName + " uBday: " + uBday + " uPhone: " + uPhone);
        return userDAO.findID(uName, uBday, uPhone);
    }

    @Override
    public String findPW (String uName, String uBday, String uPhone, String uID) throws Exception{
        System.out.println("uName: " + uName + " uBday: " + uBday + " uPhone: " + uPhone + " uId: " + uID);
        return userDAO.findPW(uName, uBday, uPhone, uID);
    }


}
