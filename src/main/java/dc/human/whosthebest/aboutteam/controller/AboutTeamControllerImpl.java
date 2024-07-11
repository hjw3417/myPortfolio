package dc.human.whosthebest.aboutteam.controller;

import dc.human.whosthebest.aboutteam.service.AboutteamService;
import dc.human.whosthebest.team.service.TeamService;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameRecordVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("aboutteamController")
public class AboutTeamControllerImpl implements AboutTeamController {
    @Autowired
    private AboutteamService aboutteamService;

    @Autowired
    private TeamService teamService;

    @Override
    @GetMapping("/team/gameSchedule.do")
    public ModelAndView gameSchedulleInfo(@SessionAttribute(name = "loginId", required = false) String loginId,
                                          @RequestParam(value="tID", required = false, defaultValue = "0") int tID
                                          ) throws Exception {
        ModelAndView mav = new ModelAndView();
        int pageNum = 1;
        int rowNum = 0;
        List<GameListVO> gameListVO = aboutteamService.selectGameSchedule(pageNum, rowNum, tID);
        List<TeamInfoVO> myTeams = teamService.getTeamsByUserId(loginId);
        if(gameListVO != null) {
            mav.addObject("gameListVO", gameListVO);
            System.out.println("controller gameListVO.size() : " + gameListVO.size());
        }
        if(myTeams != null) {
            mav.addObject("myTeams", myTeams);
        }
        mav.addObject("tID", tID);
        mav.setViewName("/aboutteam/gameSchedule");
        return mav;
    }

    @Override
    @PostMapping("/team/paging/gameSchedule.do")
    @ResponseBody
    public List<GameListVO> pagingGameSchedulleInfo(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum,
                                                    @RequestParam(value="rowNum", required = false, defaultValue = "0") int rowNum,
                                                    @RequestParam(value="tID", required = false, defaultValue = "0") int tID) throws Exception {
        List<GameListVO> gameListVO = aboutteamService.selectGameSchedule(pageNum, rowNum, tID);
        System.out.println("RestFullcontroller gameListVO.size() : " + gameListVO.size());
        return gameListVO;
    }

    @Override
    @GetMapping("/team/gameRecord.do")
    public ModelAndView selectGameRecordInfo(@SessionAttribute(name = "loginId", required = false) String loginId,
                                             @RequestParam(value="tID", required = false, defaultValue = "0") int tID)
                                             throws Exception {
        ModelAndView mav = new ModelAndView();
        GameRecordVO gameRecordVO = new GameRecordVO();
        String resultType = null;
        int pageNum =1;
        int rowNum = 0;
        gameRecordVO = aboutteamService.selectGameRecordInfo(pageNum, rowNum, tID, resultType);
        List<TeamInfoVO> myTeams = teamService.getTeamsByUserId(loginId);

        if(gameRecordVO.getGameRecordInfoListVO().size() != 0) {
            System.out.println("gameRecordVO.getGameRecordInfoListVO().get(0).getgID(): " + gameRecordVO.getGameRecordInfoListVO().get(0).getgID());
        }
        System.out.println("Service myTeamName : " + gameRecordVO.gettName());
        mav.addObject("gameRecordVO", gameRecordVO);
        if(myTeams != null) {
            mav.addObject("myTeams", myTeams);
        }
        mav.addObject("tID", tID);
        mav.setViewName("aboutteam/gameRecord");
        return mav;
    }

    @Override
    @PostMapping("/team/filter/gameRecord.do")
    @ResponseBody
    public GameRecordVO filterGameRecordInfo(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum,
                                             @RequestParam(value="rowNum", required = false, defaultValue = "0") int rowNum,
                                             @RequestParam(value="resultType", required = false) String resultType,
                                             @RequestParam(value="tID", required = false, defaultValue = "0") int tID
                                             ) throws Exception {
        GameRecordVO gameRecordVO = new GameRecordVO();
        if(resultType == "" || resultType == null) {
            resultType = null;
        }
        gameRecordVO = aboutteamService.selectGameRecordInfo(pageNum, rowNum, tID, resultType);
        if(gameRecordVO.getGameRecordInfoListVO() != null) {
            System.out.println("restFullController gameRecordVO.getGameRecordInfoListVO().get(0).getgID(): " + gameRecordVO.getGameRecordInfoListVO().get(0).getgID());
        }
        return gameRecordVO;
    }
}
