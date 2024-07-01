package dc.human.whosthebest.myPage.serivce;

import dc.human.whosthebest.myPage.dao.MyPageDAO;
import dc.human.whosthebest.vo.MyPageInfoVO;
import dc.human.whosthebest.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("myPageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MyPageServiceImpl implements MyPageService{

    @Autowired
    private MyPageDAO myPageDAO;

    @Override
    public  MyPageInfoVO getUserinfo(String uID) throws Exception{
        return myPageDAO.selectMyPageInfo(uID);


    }

}
