package dc.human.whosthebest.main.controller;

import ch.qos.logback.core.model.Model;
import dc.human.whosthebest.vo.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface MainController {
    public ModelAndView mainInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView mainBoard(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView mainBoardWrite(@SessionAttribute(name = "loginId", required = false) String loginId, BoardVO boardVO) throws Exception;
    public String read(@ModelAttribute("boardVO")BoardVO boardVO) throws  Exception;
    public ModelAndView mainBoardDetail(@RequestParam("bID") int bID) throws Exception;
    public ModelAndView showBoardModify(@RequestParam("bID") int bID) throws Exception;
    public ModelAndView mainBoardModify(@SessionAttribute(name = "loginId", required = false) String loginId, @RequestParam("bID") int bID, BoardVO boardVO) throws Exception;
    public  ModelAndView mainBoardDelete(int bID) throws Exception;
}
