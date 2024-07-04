package dc.human.whosthebest.myPage.serivce;

import dc.human.whosthebest.myPage.dao.MyPageDAO;
import dc.human.whosthebest.vo.MyPageInfoVO;
import dc.human.whosthebest.vo.RecentGameVO;
import dc.human.whosthebest.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("myPageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MyPageServiceImpl implements MyPageService{

    @Autowired
    private MyPageDAO myPageDAO;

    //마이페이지 메인
    @Override
    public List getUserinfo(String uID) throws Exception{
        return myPageDAO.selectMyPageInfo(uID);

    }

    @Override
    public List<RecentGameVO> getRecentGame(String uID) throws Exception{
        return myPageDAO.selectRecentGame(uID);
    }

    //마이페이지 - 회원정보수정 전 비밀번호 확인
/*    public  int checkPwRight(String uID, String uPW) throws  Exception{
        return myPageDAO.selectCheckPW(uID,uPW);
    }*/

    public List<UserInfoVO> loadUserInfo() throws Exception{
        return myPageDAO.selectAllMyInfo();
    }

    public void updateInfo(String uID, String uName, String uBday,
                        String uAddr1, String uAddr2, String uEmail,
                        String uPhone) throws Exception{
         myPageDAO.updateInfo(uID,uName,uBday,uAddr1,uAddr2, uEmail, uPhone);
    }

}
