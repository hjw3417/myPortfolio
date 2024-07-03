package dc.human.whosthebest.main.controller;

import dc.human.whosthebest.main.service.MainService;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller("mainController")
@RestController
public class MainControllerImpl implements MainController {

    @Autowired
    private MainService mainService;

    @Override
    @RequestMapping(value="/serviceMain" ,method = RequestMethod.GET)
    public ModelAndView mainInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<TeamInfoVO> mRanking = mainService.mainRanking();
        List<GameListVO> mGameList = mainService.mainGameList();
        ModelAndView mav = new ModelAndView("/main/serviceMain");
        mav.addObject("mRanking", mRanking);
        mav.addObject("mGameList", mGameList);
        System.out.println("메인 랭킹 시스아웃"+mRanking);
        System.out.println(mGameList);
        return mav;
    }

}
