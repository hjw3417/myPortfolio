package dc.human.whosthebest.admin.controller;

import dc.human.whosthebest.admin.service.AdminService;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("adminController")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private UserInfoVO userVO;

    @Autowired
    private AdminService adminService;



    @Override
    @RequestMapping(value = "/admin/userList.do", method = RequestMethod.GET)
    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List usersList = adminService.listUsers();
        ModelAndView mav = new ModelAndView("/admin/userList");
        mav.addObject("usersList", usersList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/admin/teamList.do", method = RequestMethod.GET)
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List teamsList = adminService.listTeams();
        System.out.println("팀 컨트롤러 성공");
        ModelAndView mav = new ModelAndView("/admin/teamList");
        mav.addObject("teamsList", teamsList);
        return mav;
    }

    @Override
    @RequestMapping(value = "admin/gameList.do", method = RequestMethod.GET)
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List gameList = adminService.listGames();
        System.out.println("게임 컨트롤러 성공");
        ModelAndView mav = new ModelAndView("/admin/gameList");
        mav.addObject("gameList", gameList);
        return mav;
    }






}
