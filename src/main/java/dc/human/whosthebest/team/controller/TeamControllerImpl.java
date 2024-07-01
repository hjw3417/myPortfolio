package dc.human.whosthebest.team.controller;

import dc.human.whosthebest.team.dao.TeamDAO;
import dc.human.whosthebest.team.service.TeamService;
import dc.human.whosthebest.team.service.TeamServiceImpl;
import dc.human.whosthebest.vo.TeamInfoVO;
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
    @GetMapping("/teamList")
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List teamsList = teamService.listTeams();
        ModelAndView mav = new ModelAndView("/team/teamList");
        mav.addObject("teamsList", teamsList);
        return mav;
    }

    @Override
    @RequestMapping(value="/addTeam" ,method = RequestMethod.POST)
    public ModelAndView addTeam(@ModelAttribute("team") TeamInfoVO team,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();

        try {
            int result = teamService.addTeam(team);
            String viewName = "";

            if (result < 1) {
                mav.addObject("errorMsg", "정상적으로 입력이 되지 않았습니다");
                viewName = "team/teamMake";
            } else {
                viewName = "redirect:/teamList";
            }
            mav.setViewName(viewName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mav;
        //제대로 저장되는지 예외 처리 필요
        //최소나이 최대나이 처리 필요
        //중복 기능 따로 만들기
    }

    @Override
    @GetMapping("/teamMake")
    public String index() {
        return "/team/teamMake";
    }

}
