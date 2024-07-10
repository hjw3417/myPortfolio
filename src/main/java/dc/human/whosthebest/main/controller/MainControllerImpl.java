package dc.human.whosthebest.main.controller;

import ch.qos.logback.core.model.Model;
import dc.human.whosthebest.main.service.MainService;
import dc.human.whosthebest.vo.BoardVO;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.MaingameListVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller("mainController")
@RestController
public class MainControllerImpl implements MainController {

    @Autowired
    private MainService mainService;

    @Override
    @RequestMapping(value="/serviceMain" ,method = RequestMethod.GET)
    public ModelAndView mainInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
        session.getAttribute("loginId");

        String name = (String) session.getAttribute("loginId");

        System.out.println("=============================================");
        System.out.println("세션에 저장된 변수 : " + name);
        System.out.println("=============================================");

        ModelAndView mav = new ModelAndView("/main/serviceMain");

        List<TeamInfoVO> mRanking = mainService.mainRanking();
        List<MaingameListVO> mGameList = mainService.mainGameList();
        List<BoardVO> mBoardList = mainService.mainBoardList();

        mav.addObject("mRanking", mRanking);
        mav.addObject("mGameList", mGameList);
        mav.addObject("mBoardList", mBoardList);
        System.out.println("메인 랭킹 시스아웃" + mRanking);
        System.out.println(mGameList);

        return mav;
    }

    @Override
    @RequestMapping(value = "/mainBoard", method = RequestMethod.GET)
    public ModelAndView mainBoard(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
        session.getAttribute("loginID");

        String name = (String) session.getAttribute("loginId");

        System.out.println("=============================================");
        System.out.println("세션에 저장된 변수 : " + name);
        System.out.println("=============================================");

        List<BoardVO> mBoard = mainService.mainBoardList();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main/boardList");
        mav.addObject("mBoard", mBoard);
        return mav;
    }

    @Override
    @RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
    public ModelAndView mainBoardWrite(BoardVO boardVO) throws Exception{
        int result = 0;
        try{
            result = mainService.mainBoardWrite(boardVO);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/mainBoard");
        return mav;
    }

    @Override
    @RequestMapping(value = "/boardDetail/read", method = RequestMethod.GET)
    public String read(@ModelAttribute("boardVO")BoardVO boardVO) throws  Exception{
        return "/boardDetail/read";
    }

    @Override
    @RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
    public ModelAndView mainBoardDetail(@RequestParam("bID") int bID) throws Exception{

        BoardVO mBoard = mainService.mainBoardDetail(bID);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main/boardDetail");
        mav.addObject("mBoard", mBoard);

        return mav;

    }

}
