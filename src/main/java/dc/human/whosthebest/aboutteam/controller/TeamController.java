package dc.human.whosthebest.aboutteam.controller;

import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameRecordVO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface TeamController {
    public ModelAndView gameSchedulleInfo(@RequestParam(value="tID", required = false, defaultValue = "0") int tID) throws Exception;
    public List<GameListVO> pagingGameSchedulleInfo(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum,
                                                    @RequestParam(value="rowNum", required = false, defaultValue = "0") int rowNum,
                                                    @RequestParam(value="tID", required = false, defaultValue = "0") int tID) throws Exception;
    public ModelAndView selectGameRecordInfo(@RequestParam(value="tID", required = false, defaultValue = "0") int tID) throws Exception;
    public GameRecordVO filterGameRecordInfo(@RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum,
                                             @RequestParam(value="rowNum", required = false, defaultValue = "0") int rowNum,
                                             @RequestParam(value="resultType", required = false) String resultType,
                                             @RequestParam(value="tID", required = false, defaultValue = "0") int tID
                                             ) throws Exception;
}
