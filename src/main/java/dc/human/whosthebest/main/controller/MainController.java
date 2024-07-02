package dc.human.whosthebest.main.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface MainController {
    public ModelAndView mainInfo(String tName, String gTitle, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
