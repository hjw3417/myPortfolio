/*
PROJECT        : whosthebest
PROGRAM ID    :  GameControllerImpl.java
PROGRAM NAME    : game Controller
DESCRIPTION    : game 관련 views 데이터 전송
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
======================================================
*/
package dc.human.whosthebest.game.controller;

import dc.human.whosthebest.game.service.GameService;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.GameVO;
import dc.human.whosthebest.vo.StadiumVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("gameController")
@RequestMapping("/game")
public class GameControllerImpl implements GameController {
    @Autowired
    private GameService gameService;

    /**
     * 게임 생성 GET 요청을 처리합니다.
     * 이 메서드는 사용자의 팀 정보를 가져와서 게임 생성 페이지를 표시합니다.
     *
     * @param request  클라이언트가 서블릿에 요청한 내용을 포함하는 HttpServletRequest 객체
     * @param response 서블릿이 클라이언트에게 보내는 응답을 포함하는 HttpServletResponse 객체
     * @return 뷰 이름과 모델 데이터를 포함하는 ModelAndView 객체
     * @throws Exception 오류가 발생할 경우 예외를 던집니다
     */
    @Override
    @RequestMapping(value = "/gameMake.do", method = RequestMethod.GET)
    public ModelAndView gameMake(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("uID", "heo");
        String uID = (String) session.getAttribute("uID");
        List<TeamInfoVO> teamNameList = gameService.loadMyTeam(uID);
        // 리스트의 첫 번째 값의 tID 출력
        if (!teamNameList.isEmpty()) {
            int firstTeamTID = teamNameList.get(0).gettID();
            System.out.println("controller 첫 번째 팀의 tID: " + firstTeamTID);
        } else {
            System.out.println("팀 정보 리스트가 비어 있습니다.");
        }
        ModelAndView mav = new ModelAndView("/game/gameMake");
        mav.addObject("teamNameList", teamNameList);
        return mav;
    }

    /**
     * 경기장을 선택하는 GET 요청을 처리합니다.
     * 이 메서드는 사용자가 선택한 지역과 검색어에 따라 경기장 목록을 가져와서 경기장 예약 페이지를 표시합니다.
     *
     * @param request  클라이언트가 서블릿에 요청한 내용을 포함하는 HttpServletRequest 객체
     * @param response 서블릿이 클라이언트에게 보내는 응답을 포함하는 HttpServletResponse 객체
     * @return 뷰 이름과 모델 데이터를 포함하는 ModelAndView 객체
     * @throws Exception 오류가 발생할 경우 예외를 던집니다
     */
    @Override
    @RequestMapping(value = "/resStadium.do", method = RequestMethod.GET)
    public ModelAndView selectStadium(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sRegion = request.getParameter("sRegion");
        String search = request.getParameter("search");

        System.out.println("MAV controller sRegion : " + sRegion);
        System.out.println("MAV controller search : " + search);
        List<StadiumVO> stadiumList = gameService.selectStadium(sRegion, search);
        System.out.println("MAV controller stadiumList : " + stadiumList.get(0).getsName());
        ModelAndView mav = new ModelAndView("/game/resStadium");
        mav.addObject("stadiumList", stadiumList);
        mav.addObject("isAjaxRequest", false);
        return mav;
    }

    /**
     * RESTful 컨트롤러 메서드로, 경기장을 이름으로 검색하는 GET 요청을 처리합니다.
     * 이 메서드는 선택한 지역과 검색어에 따라 경기장 목록을 JSON 형식으로 반환합니다.
     *
     * @param sRegion 선택한 지역 (필수 아님)
     * @param search  검색어 (필수 아님)
     * @return 경기장 목록을 포함하는 List<StadiumVO>
     * @throws Exception 오류가 발생할 경우 예외를 던집니다
     */
    @Override
    @RequestMapping(value = "/search/resStadium.do", method = RequestMethod.GET, params = "responseType=json")
    @ResponseBody
    public List<StadiumVO> searchStadiumName(@RequestParam(value = "sRegion", required = false) String sRegion,
                                             @RequestParam(value = "search", required = false) String search) throws Exception {
        System.out.println("RESTful controller sRegion : " + sRegion);
        System.out.println("RESTful controller search : " + search);
        List<StadiumVO> stadiumList = gameService.selectStadium(sRegion, search);
        // 리스트의 첫 번째 값 가져오기
        if (!stadiumList.isEmpty()) {
            System.out.println("RESTful controller stadiumList : " + stadiumList.get(0).getsName());
        } else {
            System.out.println("리스트가 비어 있습니다.");
        }
        return stadiumList;
    }

    /**
     * RESTful 컨트롤러 메서드로, 주어진 경기장 ID에 해당하는 경기장 세부 정보를 반환합니다.
     *
     * @param sID 경기장 ID를 나타내는 문자열 (선택 사항)
     * @return 주어진 경기장 ID에 해당하는 {@link StadiumVO} 객체
     * @throws Exception 예외가 발생한 경우
     */
    @Override
    @RequestMapping(value = "/stadiumDetail.do", method = RequestMethod.GET)
    @ResponseBody
    public StadiumVO stadiumDetail(@RequestParam(value = "sID", required = false) String sID) throws Exception {
        System.out.println("RESTful  controller sID : " + sID);
        int sIDInt = Integer.parseInt(sID);
        StadiumVO stadiumDetail = gameService.stadiumDetail(sIDInt);
        return stadiumDetail;
    }

    /**
     * 주어진 팀 ID를 기반으로 경기를 생성하는 메서드.
     *
     * @param gTeamID    게임을 생성하는 팀의 ID (문자열 형태).
     * @param gTitle     경기 제목.
     * @param gTag       경기 태그.
     * @param gMinMember 경기 시작에 필요한 최소 인원.
     * @param gInfo      경기 정보.
     * @param sID        경기장이 열릴 경기장의 ID.
     * @param sNum       경기장의 번호.
     * @param gTime      경기 시간.
     * @param gResDate   경기장 예약 날짜 (문자열 형태).
     * @return 게임 생성 프로세스의 결과를 나타내는 ModelAndView 객체.
     * @throws Exception 게임 생성 과정에서 오류가 발생한 경우.
     */
    @Override
    @RequestMapping(value = "/createGame.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView createGame(@RequestParam("gTeamID") String gTeamID,
                                   @RequestParam("gTitle") String gTitle,
                                   @RequestParam("gTag") String gTag,
                                   @RequestParam("gMinMember") int gMinMember,
                                   @RequestParam("gInfo") String gInfo,
                                   @RequestParam("sID") int sID,
                                   @RequestParam("sNum") int sNum,
                                   @RequestParam("gTime") int gTime,
                                   @RequestParam("gResDate") String gResDate) throws Exception {
        GameVO gameVO = new GameVO();
        System.out.println("controller tID : " + gTeamID);
        int gTeamIDInt = Integer.parseInt(gTeamID);
        gameVO.setgTeamID(gTeamIDInt);
        gameVO.settID("heo");
        gameVO.setCreatedID("heo");
        gameVO.setgTitle(gTitle);
        gameVO.setgTag(gTag);
        gameVO.setgMinMember(gMinMember);
        gameVO.setgInfo(gInfo);
        gameVO.setsID(sID);
        gameVO.setsNum(sNum);
        gameVO.setgTime(gTime);
        gameVO.setgResDate(gResDate);
        int gameMakeresult = gameService.createGame(gameVO);
        System.out.println("controller gTeamIDINT : " + gameVO.getgTeamID());
        ModelAndView mav = new ModelAndView();
        if (gameMakeresult < 0) {
            mav.setViewName("redirect:/game/gameMake.do");
        } else {
            mav.setViewName("redirect:/game/gameList.do");
            //mav.setViewName("redirect:/game/gameMake.do");
        }
        mav.addObject("gameMakeresult", gameMakeresult);
        return mav;
    }

    @Override
    @RequestMapping(value = "/gameList.do", method = RequestMethod.GET)
    public ModelAndView selectGameList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int defaultPageNum = 1;
        int defaultRowNum = 0;
        String uID = null;
        String sRegion = request.getParameter("sRegion");
        String search = request.getParameter("search");
        List<GameListVO> gameList = null;
        gameList = gameService.selectGameList(defaultPageNum, defaultRowNum, sRegion, search, uID);
        // 리스트의 첫 번째 값 가져오기
        if (!gameList.isEmpty()) {
            System.out.println("controller gameList 0 번째 gID : " + gameList.get(0).getgID());
            System.out.println("controller gameList의 길이 : " + gameList.size());
            System.out.println("controller stadiumList : " + gameList.get(0).getsName());
        } else {
            System.out.println("controller 리스트가 비어 있습니다.");
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("uID", "df");
        mav.addObject("gameList", gameList);
        mav.addObject("defaultPageNum", defaultPageNum);
        mav.setViewName("/game/gameList");
        return mav;
    }

    @Override
    @RequestMapping(value = "/filter/gameList.do", method = RequestMethod.POST, params = "responseType=json")
    @ResponseBody
    public List<GameListVO> selectGameList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                           @RequestParam(value = "rowNum", required = false, defaultValue = "0") int rowNum,
                                           @RequestParam(value = "sRegion", required = false) String sRegion,
                                           @RequestParam(value = "search", required = false) String search,
                                           @RequestParam(value = "uID", required = false) String uID
                                           ) throws Exception {
        List<GameListVO> gameList = null;
        String validID = "heo";
        System.out.println("RESTfull controller parameter pageNum : " + pageNum);
        System.out.println("RESTfull controller parameter rowNum : " + rowNum);
        gameList = gameService.selectGameList(pageNum, rowNum, sRegion, search, uID);

        // 리스트의 첫 번째 값 가져오기
        if (!gameList.isEmpty()) {
            System.out.println("RESTfull controller gameList 0 번째 gID : " + gameList.get(0).getgID());
            System.out.println("RESTfull controller gameList의 길이 : " + gameList.size());
            System.out.println("RESTful controller stadiumList : " + gameList.get(0).getsName());
        } else {
            System.out.println("RESTfull controller 리스트가 비어 있습니다.");
        }
        return gameList;
    }
}
