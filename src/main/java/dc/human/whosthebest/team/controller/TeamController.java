package dc.human.whosthebest.team.controller;

import dc.human.whosthebest.vo.TeamInfoVO;
import dc.human.whosthebest.vo.TeamMemberVO;
import dc.human.whosthebest.vo.TeamProfileVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface TeamController {

    public String teamMakePage();

    public ModelAndView myTeamPage();

    public TeamProfileVO getTeamInfo(@RequestParam("tID") int tID);

    public ModelAndView insertTeamInfo(@ModelAttribute("teamInfo") TeamInfoVO teamInfo) throws Exception;

    public ModelAndView insertTeamMember(@RequestParam("tID") int tID) throws Exception;

    public ModelAndView listTeams() throws Exception;


    public ModelAndView Ranking() throws Exception;



}
