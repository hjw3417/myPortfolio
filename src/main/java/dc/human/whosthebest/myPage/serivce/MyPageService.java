package dc.human.whosthebest.myPage.serivce;

import dc.human.whosthebest.vo.MyPageInfoVO;
import dc.human.whosthebest.vo.RecentGameVO;
import dc.human.whosthebest.vo.UserInfoVO;

import java.util.List;

public interface MyPageService {

    public List<MyPageInfoVO> getUserinfo(String uID) throws Exception;
    public List<RecentGameVO> getRecentGame(String uID) throws Exception;

    //마이페이지 - 내가 참여한 경기 결과



    //마이페이지 - 회원정보수정 전 비밀번호 확인
   public int checkInfo(String uID, String uPW) throws  Exception;


    public List<UserInfoVO> loadUserInfo(String uID) throws Exception;

    public void updateInfo(String uID, String uName, String uBday,
                        String uAddr1, String uAddr2, String uEmail,
                        String uPhone, String uPW) throws Exception;
}
