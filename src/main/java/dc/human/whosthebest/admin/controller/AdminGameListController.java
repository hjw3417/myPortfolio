package dc.human.whosthebest.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public interface AdminGameListController {
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
