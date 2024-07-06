package dc.human.whosthebest.aboutteam.controller;

import dc.human.whosthebest.aboutteam.service.TeamService;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("teamController")
public class TeamControllerImpl implements TeamController {
    @Autowired
    private TeamService teamService;

    @Override
    @GetMapping("/team/gameSchedule.do")
    public ModelAndView gameSchedulleInfo(@RequestParam(value="tID", required = false, defaultValue = "1") int tID) throws Exception {
        ModelAndView mav = new ModelAndView();
        tID = 1000000001;
        int pageNum = 1;
        int rowNum = 0;
        List<GameListVO> gameListVO = teamService.selectGameSchedule(pageNum, rowNum, tID);
        System.out.println("controller gameListVO.size() : " + gameListVO.size());
        mav.addObject("gameListVO", gameListVO);
        mav.setViewName("/team/gameSchedule");
        return mav;
    }

    @Override
    @PostMapping("/team/paging/gameSchedule.do")
    @ResponseBody
    public List<GameListVO> pagingGameSchedulleInfo(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum,
                                                    @RequestParam(value="rowNum", required = false, defaultValue = "0") int rowNum,
                                                    @RequestParam(value="tID", required = false, defaultValue = "0") int tID)
                                                    throws Exception {
        tID = 1000000001;
        List<GameListVO> gameListVO = teamService.selectGameSchedule(pageNum, rowNum, tID);
        System.out.println("RestFullcontroller gameListVO.size() : " + gameListVO.size());
        return gameListVO;
    }

    @Override
    @GetMapping("/team/gameRecord.do")
    public ModelAndView selectGameRecordInfo(@RequestParam(value="tID", required = false, defaultValue = "0") int tID) throws Exception {
        ModelAndView mav = new ModelAndView();
        GameRecordVO gameRecordVO = new GameRecordVO();
        tID = 1000000001;
        String resultType = null;
        int pageNum =1;
        int rowNum = 0;
        gameRecordVO = teamService.selectGameRecordInfo(pageNum, rowNum, tID, resultType);
        if(gameRecordVO.getGameRecordInfoListVO().size() != 0) {
            System.out.println("gameRecordVO.getGameRecordInfoListVO().get(0).getgID(): " + gameRecordVO.getGameRecordInfoListVO().get(0).getgID());
        }
        mav.setViewName("team/gameRecord");
        mav.addObject("gameRecordVO", gameRecordVO);
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
        tID = 1000000001;
        if(resultType == "" || resultType == null) {
            resultType = null;
        }
        gameRecordVO = teamService.selectGameRecordInfo(pageNum, rowNum, tID, resultType);
        if(gameRecordVO.getGameRecordInfoListVO() != null) {
            System.out.println("restFullController gameRecordVO.getGameRecordInfoListVO().get(0).getgID(): " + gameRecordVO.getGameRecordInfoListVO().get(0).getgID());
        }
        return gameRecordVO;
    }
}
