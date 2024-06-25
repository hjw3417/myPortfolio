/*
PROJECT        : whosthebest
PROGRAM ID    :  GameController.java
PROGRAM NAME    : game Controller Interface
DESCRIPTION    : game 관련 views 데이터 전송 인터페이스
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
======================================================
*/
package dc.human.whosthebest.game.controller;

import dc.human.whosthebest.vo.StadiumResInfoVO;
import dc.human.whosthebest.vo.StadiumResRawVO;
import dc.human.whosthebest.vo.StadiumVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface GameController {
    public ModelAndView gameMake(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView selectStadium(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public List<StadiumVO> searchStadiumName(@RequestParam(value = "sRegion", required = false) String sRegion,
                                             @RequestParam(value = "search", required = false) String search) throws Exception;

    public StadiumVO stadiumDetail(@RequestParam(value = "sID", required = false) String sID) throws Exception;

    public ModelAndView insertSRes(@ModelAttribute("stadiumResRawVO") StadiumResRawVO stadiumResRawVO,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception;

}