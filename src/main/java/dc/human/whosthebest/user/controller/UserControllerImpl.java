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
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @Override
    @RequestMapping(value="/login" , method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(@RequestParam("uID") String uID,
                              @RequestParam("uPW") String uPW,HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();

        try{
            String msg = "";
            String viewName = "";
            int userCount = userService.loginUser(uID, uPW);

            if (userCount > 0) {
                viewName = "main/serviceMain";
                session.setAttribute("loginId", uID); // 세션에 사용자 ID 저장
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



}
