package dc.human.whosthebest.myPage.serivce;

import dc.human.whosthebest.vo.MyPageInfoVO;
import dc.human.whosthebest.vo.UserInfoVO;

import java.util.List;

public interface MyPageService {

    public List<MyPageInfoVO> getUserinfo(String uID) throws Exception;

}
