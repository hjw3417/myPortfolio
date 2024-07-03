package dc.human.whosthebest.aboutteam.controller;

import dc.human.whosthebest.aboutteam.service.TeamService;
import dc.human.whosthebest.vo.GameListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("teamController")
public class TeamControllerImpl implements TeamController {
    @Autowired
    private TeamService teamService;

    @Override
    @GetMapping("/team/gameSchedule.do")
    public ModelAndView gameSchedulleInfo() throws Exception {
        ModelAndView mav = new ModelAndView();
        int tID = 1000000001;
        List<GameListVO> gameListVO = teamService.selectGameSchedule(tID);
        mav.addObject("gameListVO", gameListVO);
        mav.setViewName("/team/gameSchedule");
        return mav;
    }
}
