package dc.human.whosthebest.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface AdminTeamListController {
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
