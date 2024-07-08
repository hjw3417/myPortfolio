package dc.human.whosthebest.user.controller;

import dc.human.whosthebest.user.service.UserService;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller("userController")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/join.do", method = RequestMethod.POST)
    public ModelAndView join (UserInfoVO userInfoVO) throws Exception {

        int result = 0;
        try{
            result = userService.insertJoin(userInfoVO);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/login");
        return mav;
    }


    @Override
    @RequestMapping( value ="/checkId", method = RequestMethod.POST)
    @ResponseBody
    public boolean idCheck(@RequestParam("uID") String uID, HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean bCheck = false;
        System.out.println(uID);

        int userCount = userService.checkId(uID);
        System.out.println("userCount:"+userCount);
        if (userCount < 1) {
            bCheck = true;
        }
        return bCheck;
    }

    @Override
    @RequestMapping(value="/login" , method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(@RequestParam("uID") String uID,
                              @RequestParam("uPW") String uPW,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        try{
            String msg = "";
            String viewName = "";
            int userCount = userService.loginUser(uID, uPW);

            if (userCount > 0) {
                viewName = "redirect:/serviceMain";
                session.setAttribute("loginId", uID); // 세션에 사용자 ID 저장
                System.out.println("================================================");
                System.out.println("현재 로그인 유저 : " + session.getAttribute("loginId"));
                System.out.println("================================================");
            } else {
                viewName = "redirect:/login";
                msg = "일치하는 회원 정보가 없습니다";
            }

            mav.addObject("errorMsg",msg);
            mav.addObject("loginId",uID);
            mav.setViewName(viewName);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) throws Exception{

        System.out.println("logout 메서드 진입");

        HttpSession session = request.getSession();

        session.invalidate();

        return "redirect:/login";

    }



    @Override
    @RequestMapping(value="/findId" , method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView findId(@RequestParam("uName") String uName,
                               @RequestParam("uBday") String uBday,
                               @RequestParam("uPhone") String uPhone, HttpServletRequest request, HttpServletResponse response) throws Exception{

        ModelAndView mav = new ModelAndView();

        try{
            String msgOk = "";
            String msgNo = "";
            String viewName = "";

            System.out.println("uName :"+uName + "uBday: " +  uBday + "uPhone: "+ uPhone);
            String uID = userService.findID(uName, uBday, uPhone);

            System.out.println(uID);
            if (uID != null) {

//                msgOk = "회원정보가 확인됐습니다.";
                viewName = "user/idPage";
            } else {
                msgNo = "입력하신 정보가 일치하지 않습니다.";
                viewName = "user/findID";
            }

            mav.addObject("checkMsg",msgOk);
            mav.addObject("errorMsg",msgNo);
            mav.addObject("uId",uID);
            mav.setViewName(viewName);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;

    }

    @Override
    @RequestMapping(value="/findPw" , method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView findPw(@RequestParam("uName") String uName,
                               @RequestParam("uBday") String uBday,
                               @RequestParam("uPhone") String uPhone,
                               @RequestParam("uID")String uID, HttpServletRequest request, HttpServletResponse response) throws Exception{

        ModelAndView mav = new ModelAndView();

        try{
            String msgOk = "";
            String msgNo = "";
            String viewName = "";

            System.out.println("uName :"+uName + " uBday: " +  uBday + " uPhone: "+ uPhone + " uID: " + uID);
            String uPW = userService.findPW(uName, uBday, uPhone, uID);
            System.out.println("good");
            System.out.println(uPW);
            if (uPW != null) {

//                msgOk = "회원정보가 확인됐습니다.";
                viewName = "user/pwPage";
            } else {
                msgNo = "입력하신 정보가 일치하지 않습니다.";
                viewName = "user/findPW";
            }

            mav.addObject("checkMsg",msgOk);
            mav.addObject("errorMsg",msgNo);
            mav.addObject("uPW",uPW);
            mav.setViewName(viewName);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;

    }


}
