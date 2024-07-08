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
    public List getUserinfo() throws Exception{
        return myPageDAO.selectMyPageInfo();

    }

    @Override
    public List<RecentGameVO> getRecentGame() throws Exception{
        return myPageDAO.selectRecentGame();
    }

    //마이페이지 - 회원정보수정 전 비밀번호 확인
    @Override
    public int checkInfo(String uID, String uPW) throws  Exception{
        int a=0;
        a=myPageDAO.selectMyInfo(uID,uPW).getValid();
        return a;
    }



    //마이페이지 - 회원정보수정
    @Override
    public List<UserInfoVO> loadUserInfo() throws Exception{
        return myPageDAO.selectAllMyInfo();
    }

    @Override
    public void updateInfo(String uID, String uName, String uBday,
                        String uAddr1, String uAddr2, String uEmail,
                        String uPhone, String uPW) throws Exception {
        myPageDAO.updateInfo(uID, uName, uBday, uAddr1, uAddr2, uEmail, uPhone, uPW);
    }



}
