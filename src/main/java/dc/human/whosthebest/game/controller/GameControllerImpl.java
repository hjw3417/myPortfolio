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
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("gameController")
public class GameControllerImpl implements GameController {
    @Autowired
    private GameService gameService;

    @Override
    @RequestMapping(value = "/game/gameMake.do", method = RequestMethod.GET)
    public ModelAndView gameMake(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        session.setAttribute("uID", "heo");
        String uID = (String) session.getAttribute("uID");
        List<TeamInfoVO> teamNameList = gameService.loadMyTeam(uID);
        ModelAndView mav = new ModelAndView("/game/gameMake");
        mav.addObject("teamNameList", teamNameList);
        return mav;
    }
}
