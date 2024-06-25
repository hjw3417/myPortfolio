package dc.human.whosthebest.user.controller;

import dc.human.whosthebest.user.service.JoinService;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinControllerImpl implements JoinController {

    @Autowired
    private JoinService joinService;

    @Override
    @RequestMapping(method = RequestMethod.POST, value="/join.do")
    public ModelAndView join(@ModelAttribute("info") UserInfoVO userInfoVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        int result = 0;
        result = joinService.insertJoin(userInfoVO);
        ModelAndView mav = new ModelAndView("redirect:/login.do");
        return mav;

    }


}
