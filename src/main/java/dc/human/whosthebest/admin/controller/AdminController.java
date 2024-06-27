package dc.human.whosthebest.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

    //회원 목록
    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //팀 목록
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //경기목록
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //관리자메인
    public ModelAndView adminMain(HttpServletRequest request, HttpServletResponse response) throws  Exception;

    //회원 상세보기
    public ModelAndView detailUser(@PathVariable("uID") String uID, HttpServletRequest request, HttpServletResponse response) throws  Exception;

}
