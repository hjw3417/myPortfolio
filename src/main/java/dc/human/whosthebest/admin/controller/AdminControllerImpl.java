package dc.human.whosthebest.admin.controller;

import dc.human.whosthebest.admin.service.AdminService;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private UserInfoVO userVO;

    @Autowired
    private AdminService adminService;



    @Override
    @RequestMapping(value = "/userList.do", method = RequestMethod.GET)
    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List usersList = adminService.listUsers();
        ModelAndView mav = new ModelAndView("/admin/userList");
        mav.addObject("usersList", usersList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/teamList.do", method = RequestMethod.GET)
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List teamsList = adminService.listTeams();
        ModelAndView mav = new ModelAndView("/admin/teamList");
        mav.addObject("teamsList", teamsList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/gameList.do", method = RequestMethod.GET)
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List gameList = adminService.listGames();
        ModelAndView mav = new ModelAndView("/admin/gameList");
        mav.addObject("gameList", gameList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/main.do", method = RequestMethod.GET)
    public ModelAndView adminMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List newUserList = adminService.newUserList();
        List newTeamList = adminService.newTeamList();
        ModelAndView mav = new ModelAndView("/admin/adminMainPage");
        mav.addObject("newUser", newUserList);
        mav.addObject("newTeam", newTeamList);
        return mav;
    }


    @Override
    @RequestMapping(value = "/userDetail/{uID}", method = RequestMethod.GET)
    public ModelAndView detailUser(@PathVariable("uID") String uID,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        UserInfoVO userDetail = adminService.getUserDetailById(uID);
        System.out.println("회원 상세보기 컨트롤러 성공");
        ModelAndView mav = new ModelAndView("/admin/userDetail");
        mav.addObject("userInfo", userDetail);
        return mav;
    }






}
