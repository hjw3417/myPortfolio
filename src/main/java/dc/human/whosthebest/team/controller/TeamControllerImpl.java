package dc.human.whosthebest.team.controller;

import dc.human.whosthebest.team.dao.TeamDAO;
import dc.human.whosthebest.team.service.TeamService;
import dc.human.whosthebest.vo.MemberVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    }
    @Override
    @GetMapping("/teamMake")
    public String index() {
        return "/team/teamMake";
    }

}
