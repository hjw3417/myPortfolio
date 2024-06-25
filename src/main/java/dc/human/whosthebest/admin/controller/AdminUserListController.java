package dc.human.whosthebest.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminUserListController {

    public ModelAndView listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception;





}
