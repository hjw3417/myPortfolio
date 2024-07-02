package dc.human.whosthebest.user.controller;

import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface UserController {

    public ModelAndView login(@RequestParam("uID") String uID,
                              @RequestParam("uPW") String uPW, HttpServletRequest request, HttpServletResponse response) throws Exception;
}