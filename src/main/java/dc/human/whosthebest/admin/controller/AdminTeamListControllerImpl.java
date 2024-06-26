package dc.human.whosthebest.admin.controller;

import dc.human.whosthebest.admin.service.AdminTeamListService;
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller("adminTeamListController")
public class AdminTeamListControllerImpl  implements  AdminTeamListController{

    @Autowired
    private AdminTeamListService teamListService;


    @Override
    @RequestMapping(value = "/admin/teamList.do", method = RequestMethod.GET)
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List teamsList = teamListService.listTeams();
        System.out.println("팀 컨트롤러 성공");
        ModelAndView mav = new ModelAndView("/admin/teamList");
        mav.addObject("teamsList", teamsList);
        return mav;
    }





}
