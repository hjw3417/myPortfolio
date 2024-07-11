package dc.human.whosthebest.myPage.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface MyPageController {
    //마이페이지 메인
    public ModelAndView myPage( @SessionAttribute(name = "loginId", required = false) String loginId,
                                HttpServletRequest request,
                               HttpServletResponse response) throws Exception;

    //마이페이지 - 내가 참여한 경기 결과
    public ModelAndView myGameRecord( @SessionAttribute(name = "loginId", required = false) String loginId,
                                      HttpServletRequest request,
                                     HttpServletResponse response) throws Exception;


    //마이페이지- 회원정보수정 전 비밀번호 확인
    public ModelAndView pwCheck( @SessionAttribute(name = "loginId", required = false) String loginId,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception;
    public  ModelAndView pwCheck(@RequestParam("uID") String uID,
                       @RequestParam("uPW") String uPW) throws  Exception;

    //마이페이지 - 회원정보수정
    public ModelAndView loadInfo( @SessionAttribute(name = "loginId", required = false) String loginId,
                                  HttpServletRequest request,
                                 HttpServletResponse response) throws Exception;

    public String updateMyInfo( @SessionAttribute(name = "loginId", required = false)String loginId,
                                @RequestParam("uID") String uID,
                               @RequestParam("uName") String uName,
                               @RequestParam("uBday") String uBday,
                               @RequestParam("uAddr1") String uAddr1,
                               @RequestParam("uAddr2") String uAddr2,
                               @RequestParam("uEmail") String uEmail,
                               @RequestParam("uPhone") String uPhone,
                               @RequestParam("uPW") String uPW) throws Exception;


    //로그아웃
    public String logout(HttpServletRequest request) throws  Exception;
}
