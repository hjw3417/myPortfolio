package dc.human.whosthebest.aboutteam.controller;

import org.springframework.web.servlet.ModelAndView;

public interface TeamController {
    public ModelAndView gameSchedulleInfo() throws Exception;
    public ModelAndView selectGameRecordInfo() throws Exception;
}
