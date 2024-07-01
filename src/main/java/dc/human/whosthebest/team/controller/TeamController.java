package dc.human.whosthebest.team.controller;

import dc.human.whosthebest.vo.TeamInfoVO;
import dc.human.whosthebest.vo.TeamMemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface TeamController {

    public String teamMakePage();

    public ModelAndView insertTeamInfo(@ModelAttribute("teamInfo") TeamInfoVO teamInfo,
                                HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView insertTeamMember(@RequestParam("tID") int tID,
                                         HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception;



}
