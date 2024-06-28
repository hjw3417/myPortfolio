package dc.human.whosthebest.user.controller;

import dc.human.whosthebest.user.service.UserService;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller("userController")
@RestController
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
                              @RequestParam("uPW") String uPW,HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        try{
            String msg = "";
            String viewName = "";
            int userCount = userService.loginUser(uID, uPW);

            if (userCount > 0) {
                viewName = "main/serviceMain";
            } else {
                msg = "일치하는 회원 정보가 없습니다";
                viewName = "user/login";
            }

            mav.addObject("errorMsg",msg);
            mav.addObject("loginId",uID);
            mav.setViewName(viewName);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;
    }

    @Override
    @RequestMapping(value="/findId" , method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView findId(@RequestParam("uID") String uID,
                               @RequestParam("uBday") String uBday,
                               @RequestParam("uPhone") String uPhone, HttpServletRequest request, HttpServletResponse response) throws Exception{

        ModelAndView mav = new ModelAndView();

        try{
            String msgOk = "";
            String msgNo = "";
            String viewName = "";
            int userCount = userService.findID(uID, uBday, uPhone);

            if (userCount > 0) {
                msgOk = "회원님의 아이디는 "+ uID + "입니다.";
                viewName = "user/login";
            } else {
                msgNo = "아이디 또는 생년월일 또는 휴대폰 번호가 일치하지 않습니다.";
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


}
