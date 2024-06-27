package dc.human.whosthebest.team.controller;

import dc.human.whosthebest.team.dao.TeamDAO;
import dc.human.whosthebest.team.service.TeamService;
import dc.human.whosthebest.vo.MemberVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller("teamController")
public class TeamControllerImpl implements TeamController{

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamInfoVO temaInfoVO;

    @Override
    @RequestMapping(value="/addTeam" ,method = RequestMethod.POST)
    public ModelAndView addTeam(@ModelAttribute("team") TeamInfoVO team,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        int result = 0;
        result = teamService.addTeam(team);
        ModelAndView mav = new ModelAndView("redirect:/team/teamMake");
        return mav;
        //제대로 저장되는지 예외 처리 필요
        //최소나이 최대나이 처리 필요
        //중복 기능 따로 만들기 필요
    }
    @Override
    @GetMapping("/teamMake")
    public String index() {
        return "/team/teamMake";
    }

}
