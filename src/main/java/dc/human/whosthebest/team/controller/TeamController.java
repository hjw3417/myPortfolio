package dc.human.whosthebest.team.controller;

import dc.human.whosthebest.vo.TeamInfoVO;
import dc.human.whosthebest.vo.TeamMemberVO;
import dc.human.whosthebest.vo.TeamProfileVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public interface TeamController {

    public String teamMakePage();
    //팀멤버 임시
    public ModelAndView teamMembersPage(@RequestParam("tID") int tID);
    public ModelAndView myTeamPage();

    public ResponseEntity<Map<String, Object>> getTeamProfile(@RequestParam("tID") int tID);

    public ModelAndView insertTeamInfo(@ModelAttribute("teamInfo") TeamInfoVO teamInfo) throws Exception;

    public ModelAndView insertTeamMember(@RequestParam("tID") int tID) throws Exception;

    public ModelAndView listTeams() throws Exception;


    public ModelAndView Ranking() throws Exception;



}
