package dc.human.whosthebest.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

    //회원관리-회원 목록조회
    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //팀관리-팀 목록조회
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //경기관리-경기 목록조회
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //관리자메인
    public ModelAndView adminMain(HttpServletRequest request, HttpServletResponse response) throws  Exception;

    //회원 상세보기
    public ModelAndView detailUser(@PathVariable("uID") String uID, HttpServletRequest request, HttpServletResponse response) throws  Exception;

    //팀 상세보기
    public ModelAndView detailTeam(@PathVariable("tID") String tID, HttpServletRequest request, HttpServletResponse response) throws Exception;

    //경기 상세보기
    public ModelAndView detailGame(@PathVariable("gID") String gID, HttpServletRequest request, HttpServletResponse response) throws  Exception;

    //로그아웃
    public String logout(HttpServletRequest request) throws  Exception;
}
