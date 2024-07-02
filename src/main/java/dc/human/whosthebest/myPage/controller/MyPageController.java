package dc.human.whosthebest.myPage.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface MyPageController {

    public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) throws Exception;


}
