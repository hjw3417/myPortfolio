package dc.human.whosthebest.aboutteam.controller;

import dc.human.whosthebest.vo.GameRecordVO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface TeamController {
    public ModelAndView gameSchedulleInfo() throws Exception;
    public ModelAndView selectGameRecordInfo() throws Exception;
    public GameRecordVO filterGameRecordInfo(@RequestParam(value="resultType", required = false) String resultType ) throws Exception;
}
