package dc.human.whosthebest.admin.controller;

import dc.human.whosthebest.admin.service.AdminService;
import dc.human.whosthebest.vo.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private AdminService adminService;


    //회원관리- 회원목록 조회
    @Override
    @RequestMapping(value = "/userList.do", method = RequestMethod.GET)
    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<UserInfoVO> usersList = adminService.listUsers();
        for(UserInfoVO user : usersList){
            if(user.getuGender() ==null){
                user.setuGender(" ");
            }
            if(user.getuBday() ==null){
                user.setuBday(" ");
            }
            if(user.getuAddr1()==null){
                user.setuAddr1(" ");
            }
            if(user.getuAddr2() == null){
                user.setuAddr2(" ");
            }
            if(user.getuEmail() ==null){
                user.setuEmail(" ");
            }
        }
        ModelAndView mav = new ModelAndView("/admin/userList");
        mav.addObject("usersList", usersList);
        return mav;
    }

    //팀 관리- 팀 목록 조회
    @Override
    @RequestMapping(value = "/teamList.do", method = RequestMethod.GET)
    public ModelAndView listTeams(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List teamsList = adminService.listTeams();
        ModelAndView mav = new ModelAndView("/admin/teamList");
        mav.addObject("teamsList", teamsList);
        return mav;
    }

    //경기 관리 - 경기 목록 조회
    @Override
    @RequestMapping(value = "/gameList.do", method = RequestMethod.GET)
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<GameStadiumVO> gameList = adminService.listGames();

        ModelAndView mav = new ModelAndView("/admin/gameList");
        mav.addObject("gameList", gameList);
        return mav;
    }

    //관리자메인화면
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


    //회원목록- 회원 상세보기
    @Override
    @RequestMapping(value = "/userDetail/{uID}", method = RequestMethod.GET)
    public ModelAndView detailUser(@PathVariable("uID") String uID,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        UserInfoVO userDetail = adminService.getUserDetailById(uID);
        ModelAndView mav = new ModelAndView("/admin/userDetail");
        mav.addObject("userInfo", userDetail);
        return mav;
    }

    //팀목록- 팀 상세보기
    @Override
    @RequestMapping(value="/teamDetail/{tID}", method = RequestMethod.GET)
    public ModelAndView detailTeam(@PathVariable("tID") String tID,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception{
        TeamInfoVO teamDetail = adminService.getTeamById(tID);
        List<RecentGameVO> teamGame = adminService.getTeamGameById(tID);
        ModelAndView mav = new ModelAndView(("/admin/teamDetail"));
        mav.addObject("teamInfo", teamDetail);
        mav.addObject("teamGame", teamGame);
        return  mav;
    }

    //경기목록- 경기 상세보기
    @Override
    @RequestMapping(value = "/gameDetail/{gID}", method = RequestMethod.GET)
    public ModelAndView detailGame(@PathVariable("gID") String gID,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception{
        AdminGameListVO gameDetail = adminService.getGameById(gID);
        System.out.println("게임 상세보기 컨트롤러 성공");
        ModelAndView mav = new ModelAndView("/admin/gameDetail");
        mav.addObject("gameInfo", gameDetail);
        return mav;
    }

    //로그아웃
    @Override
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) throws  Exception{
        HttpSession session = request.getSession();

        // 세션에서 저장된 정보 삭제
        session.removeAttribute("uID");  // 예시로 userId라는 세션 속성을 삭제하는 것을 가정

        // 세션 전체를 삭제하려면 아래 코드를 사용
        // session.invalidate();

        // 로그인 페이지로 리다이렉트
        return "redirect:/login";  // 로그인 페이지 URL로 변경
    }
}
