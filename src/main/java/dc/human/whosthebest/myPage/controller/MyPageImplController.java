package dc.human.whosthebest.myPage.controller;

import dc.human.whosthebest.myPage.serivce.MyPageService;

import dc.human.whosthebest.vo.MyPageInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("myPageController")
public class MyPageImplController {

    @Autowired
    private MyPageService myPageService;

    @RequestMapping(value= "/myPage", method = RequestMethod.GET)
    public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        String uID = (String) session.getAttribute("hong");
        MyPageInfoVO myPageInfo = myPageService.getUserinfo(uID);
        ModelAndView mav = new ModelAndView("/myPage/myPage");
        mav.addObject("myPageInfo", myPageInfo);
        System.out.println("마이페이지컨트롤러 성공");
        return mav;
    }
}