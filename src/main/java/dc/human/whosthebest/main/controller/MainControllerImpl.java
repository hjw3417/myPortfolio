package dc.human.whosthebest.main.controller;

import dc.human.whosthebest.main.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView mainInfo(String tName, String gTitle, HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<String> mRanking = mainService.mainRanking(tName);
        List<String> mGameList = mainService.mainGameList(gTitle);
        ModelAndView mav = new ModelAndView("/main/serviceMain");
        mav.addObject("mRanking", mRanking);
        mav.addObject("mGameList", mGameList);
        System.out.println(mRanking);
        System.out.println(mGameList);
        return mav;
    }

}
