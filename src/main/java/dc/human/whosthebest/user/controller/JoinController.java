package dc.human.whosthebest.user.controller;

import dc.human.whosthebest.vo.MemberVO;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface JoinController {

    public ModelAndView join(@ModelAttribute("info") UserInfoVO userInfoVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
    //info는 ModelAttribute의 변수명!
}
