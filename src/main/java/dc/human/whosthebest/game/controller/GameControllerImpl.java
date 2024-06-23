/*
PROJECT        : whosthebest
PROGRAM ID    :  GameControllerImpl.java
PROGRAM NAME    : game Controller
DESCRIPTION    : game 관련 views 데이터 전송
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
======================================================
*/
package dc.human.whosthebest.game.controller;

import dc.human.whosthebest.game.service.GameService;
import dc.human.whosthebest.vo.StadiumVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("gameController")
@RequestMapping("/game")
public class GameControllerImpl implements GameController {
    @Autowired
    private GameService gameService;

    @Override
    @RequestMapping(value = "/gameMake.do", method = RequestMethod.GET)
    public ModelAndView gameMake(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("uID", "heo");
        String uID = (String) session.getAttribute("uID");
        List<TeamInfoVO> teamNameList = gameService.loadMyTeam(uID);
        ModelAndView mav = new ModelAndView("/game/gameMake");
        mav.addObject("teamNameList", teamNameList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/resStadium.do", method = RequestMethod.GET, params = "!responseType")
    public ModelAndView selectStadium(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sRegion = request.getParameter("sRegion");
        String search = request.getParameter("search");

        System.out.println("MAV controller sRegion : " + sRegion);
        System.out.println("MAV controller search : " + search);
        List<StadiumVO> stadiumList = gameService.selectStadium(sRegion, search);
        ModelAndView mav = new ModelAndView("/game/resStadium");
        mav.addObject("stadiumList", stadiumList);
        mav.addObject("isAjaxRequest", false);
        return mav;
    }

    @Override
    @RequestMapping(value = "/resStadium.do", method = RequestMethod.GET, params = "responseType=json")
    @ResponseBody
    public List<StadiumVO> searchStadiumName(@RequestParam(value = "sRegion", required = false) String sRegion,
                                             @RequestParam(value = "search", required = false) String search) throws Exception {
        System.out.println("RESTful controller sRegion : " + sRegion);
        System.out.println("RESTful controller search : " + search);
        return gameService.selectStadium(sRegion, search);
    }
}
