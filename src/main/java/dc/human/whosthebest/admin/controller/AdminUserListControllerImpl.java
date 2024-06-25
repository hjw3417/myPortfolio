package dc.human.whosthebest.admin.controller;

import dc.human.whosthebest.admin.service.AdminUserListService;
import dc.human.whosthebest.vo.UserInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("adminUserListController")
public class AdminUserListControllerImpl implements  AdminUserListController{
    @Autowired
    private AdminUserListService userListService;

    @Autowired
    private UserInfoVO userVO;

    @Override
    @RequestMapping(value = "/admin/userList.do", method = RequestMethod.GET)
    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List usersList = userListService.listUsers();
        ModelAndView mav = new ModelAndView("/admin/userList");
        mav.addObject("usersList", usersList);  // usersList를 ModelAndView에 추가
        return mav;
    }


}
