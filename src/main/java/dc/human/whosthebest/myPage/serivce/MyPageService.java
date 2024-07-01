package dc.human.whosthebest.myPage.serivce;

import dc.human.whosthebest.vo.MyPageInfoVO;
import dc.human.whosthebest.vo.UserInfoVO;

public interface MyPageService {

    public  MyPageInfoVO getUserinfo(String uID) throws Exception;

}
