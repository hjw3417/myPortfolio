package dc.human.whosthebest.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

    //회원 목록
    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //팀 목록
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //경기목록
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
