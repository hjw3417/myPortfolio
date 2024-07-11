package dc.human.whosthebest.myPage.controller;

import dc.human.whosthebest.myPage.serivce.MyPageService;

import dc.human.whosthebest.vo.MyPageInfoVO;
import dc.human.whosthebest.vo.RecentGameVO;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("myPageController")
public class MyPageControllerImpl implements  MyPageController {
//셔ㅑㄱ샤ㅕㄱ샷갸
    @Autowired
    private MyPageService myPageService;

    //마이페이지 메인
    @Override
    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public ModelAndView myPage(@SessionAttribute(name = "loginId", required = false) String loginId,
                               HttpServletRequest request, HttpServletResponse response) throws Exception {


        String uID = loginId;
        List<MyPageInfoVO> myPageInfo = myPageService.getUserinfo(uID);
        List<RecentGameVO> recentGame = myPageService.getRecentGame(uID);
        ModelAndView mav = new ModelAndView("/myPage/myPage");
        mav.addObject("myPageInfo", myPageInfo);
        mav.addObject("recentGame", recentGame);
        return mav;
    }

    //마이페이지 - 내가 참여한 경기결과
    @Override
    @RequestMapping(value = "/myPage/myGameRecord")
    public ModelAndView myGameRecord(@SessionAttribute(name = "loginId", required = false) String loginId,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws Exception{

        String uID = loginId;
        List<RecentGameVO> myGameRecord = myPageService.getRecentGame(uID);
        ModelAndView mav = new ModelAndView("/myPage/myGameRecord");
        mav.addObject("recentGame", myGameRecord);
        return  mav;
    }


  /*  마이페이지 - 회원정보수정 전 비밀번호 확인 */
    @Override
    @RequestMapping(value= "/myPage/updatePwCheck" , method = RequestMethod.GET)
    public ModelAndView pwCheck(@SessionAttribute(name = "loginId", required = false) String loginId,
                                HttpServletRequest request,
                                HttpServletResponse response) throws Exception{
        String uID = loginId;
        ModelAndView mav = new ModelAndView("/myPage/updatePwCheck");
        mav.addObject("uID",uID);
        return mav;
      }

    @Override
    @RequestMapping(value = "myPage/updatePwCheck" , method = RequestMethod.POST)
    public  ModelAndView pwCheck(@RequestParam("uID") String uID,
                           @RequestParam("uPW") String uPW) throws  Exception{

        System.out.println(uID);
        System.out.println(uPW);
        int a =0;
        a=myPageService.checkInfo(uID, uPW);
        System.out.println(a);
        ModelAndView mav = new ModelAndView();
        if(a>0){
            mav.setViewName("redirect:/myPage/updateMyInfoPage");
        }
        else{
            mav.addObject("uID", uID);
            mav.addObject("errorMessage", "비밀번호를 다시 입력해주세요.");
            mav.setViewName("/myPage/updatePwCheck");

        }
        return mav;
    }

    
    /*마이페이지  - 회원정보수정*/
    @Override
    @RequestMapping(value = "/myPage/updateMyInfoPage" ,  method = {RequestMethod.GET, RequestMethod.POST})
    public  ModelAndView loadInfo(@SessionAttribute(name = "loginId", required = false) String loginId,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
        String uID = loginId;
        List<UserInfoVO> allMyInfo = myPageService.loadUserInfo(uID);
        ModelAndView mav = new ModelAndView("/myPage/updateMyInfo");
        mav.addObject("allMyInfo", allMyInfo);
        return  mav;
    }

    @Override
    @RequestMapping(value = "/myPage/updateMyInfo" ,method=RequestMethod.POST)
    public String updateMyInfo(@SessionAttribute(name = "loginId", required = false) String loginId,
                               @RequestParam("uID") String uID,
                               @RequestParam("uName") String uName,
                               @RequestParam("uBday") String uBday,
                               @RequestParam("uAddr1") String uAddr1,
                               @RequestParam("uAddr2") String uAddr2,
                               @RequestParam("uEmail") String uEmail,
                               @RequestParam("uPhone") String uPhone,
                               @RequestParam("uPW") String uPW) throws Exception {

        myPageService.updateInfo(uID,uName,uBday,uAddr1,uAddr2, uEmail, uPhone, uPW);
        return "redirect:/myPage";
    }

    //로그아웃
    @Override
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) throws  Exception{
        HttpSession session = request.getSession();

        // 세션에서 저장된 정보 삭제
        session.removeAttribute("uID");  // 예시로 userId라는 세션 속성을 삭제하는 것을 가정

        // 세션 전체를 삭제하려면 아래 코드를 사용
        // session.invalidate();

        // 로그인 페이지로 리다이렉트
        return "redirect:/login";  // 로그인 페이지 URL로 변경
    }

}


