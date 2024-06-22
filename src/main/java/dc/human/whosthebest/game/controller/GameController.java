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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface GameController {
    public ModelAndView gameMake(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
