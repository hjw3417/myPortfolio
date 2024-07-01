package dc.human.whosthebest.team.controller;

import dc.human.whosthebest.team.dao.TeamDAO;
import dc.human.whosthebest.team.service.TeamService;
import dc.human.whosthebest.team.service.TeamServiceImpl;
import dc.human.whosthebest.vo.TeamInfoVO;
import dc.human.whosthebest.vo.TeamMemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("teamController")
public class TeamControllerImpl implements TeamController{

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamInfoVO temaInfoVO;

    @Override
    @GetMapping("/teamMake")
    public String teamMakePage() {
        return "/team/teamMake";
    }

    @Override
    @RequestMapping(value="/insertTeamInfo" ,method = RequestMethod.POST)
    public ModelAndView insertTeamInfo(@ModelAttribute("teamInfo") TeamInfoVO teamInfo,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        teamInfo.setCreatedID("HONG");
        try {
            int result = teamService.insertTeamInfo(teamInfo);
            String viewName = "";

            if (result < 1) {
                mav.addObject("errorMsg", "정상적으로 입력이 되지 않았습니다");
                viewName = "team/teamList";
            } else {
                viewName = "redirect:/teamList";
            }
            mav.setViewName(viewName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;
        //최소나이 최대나이 처리 필요
        //중복 기능 따로 만들기
    }

    @Override
    @RequestMapping(value="/insertTeamMember" ,method = RequestMethod.POST)
    public ModelAndView insertTeamMember(@RequestParam("tID") int tID,
                                         HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();

        try {
            String viewName = "";
            TeamMemberVO teamMember = new TeamMemberVO();
            teamMember.setCreatedID("MOON");
            teamMember.setuID("MOON");
            teamMember.settID(tID);
            int insertTeamMemberResult = teamService.insertTeamMember(teamMember);


            if(insertTeamMemberResult<1) {
                mav.addObject("errorMsg", "팀 가입 실패");
                viewName = "team/teamList";
            } else {
                viewName = "redirect:/teamMake";
            }
            mav.setViewName(viewName);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return mav;
    }


    @Override
    @GetMapping("/teamList")
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List teamsList = teamService.listTeams();
        ModelAndView mav = new ModelAndView("/team/teamList");
        mav.addObject("teamsList", teamsList);
        return mav;
    }



}
