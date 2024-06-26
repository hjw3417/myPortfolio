package dc.human.whosthebest.admin.controller;

import dc.human.whosthebest.admin.service.AdminGameListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("adminGameListController")
public class AdminGameListControllerImpl implements AdminGameListController {

    @Autowired
    private AdminGameListService gameListService;

    @Override
    @RequestMapping(value = "admin/gameList.do", method = RequestMethod.GET)
    public ModelAndView listGames(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List gameList = gameListService.listGames();
        System.out.println("게임 컨트롤러 성공");
        ModelAndView mav = new ModelAndView("/admin/gameList");
        mav.addObject("gameList", gameList);
        return mav;
    }

}
