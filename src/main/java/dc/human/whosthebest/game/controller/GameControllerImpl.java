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
import dc.human.whosthebest.vo.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        session.setAttribute("uID", "MOON");
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
    public ModelAndView createGame(@RequestParam(value="gTeamID", required = false) String gTeamID,
                                   @RequestParam(value="gTitle", required = false) String gTitle,
                                   @RequestParam(value="gTag", required = false) String gTag,
                                   @RequestParam(value="gMinMember", required = false, defaultValue = "1") int gMinMember,
                                   @RequestParam(value="gInfo", required = false) String gInfo,
                                   @RequestParam(value="sID", required = false, defaultValue = "1") int sID,
                                   @RequestParam(value="sNum", required = false, defaultValue = "1") int sNum,
                                   @RequestParam(value="gTime", required = false, defaultValue = "1") int gTime,
                                   @RequestParam(value="gResDate", required = false) String gResDate) throws Exception {
        GameVO gameVO = new GameVO();
        System.out.println("controller tID : " + gTeamID);
        int gTeamIDInt = Integer.parseInt(gTeamID);
        gameVO.setgTeamID(gTeamIDInt);
        gameVO.settUserID("MOON");
        gameVO.setCreatedID("MOON");
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
        String IMakeGameuID = null;
        String IPartiGameuID = null;
        String sRegion = request.getParameter("sRegion");
        String search = request.getParameter("search");
        List<GameListVO> gameList = null;
        gameList = gameService.selectGameList(defaultPageNum, defaultRowNum, sRegion, search, IMakeGameuID, IPartiGameuID);
        // 리스트의 첫 번째 값 가져오기
        if (!gameList.isEmpty()) {
            System.out.println("controller gameList 0 번째 gID : " + gameList.get(0).getgID());
            System.out.println("controller gameList의 길이 : " + gameList.size());
            System.out.println("controller stadiumList : " + gameList.get(0).getsName());
        } else {
            System.out.println("controller 리스트가 비어 있습니다.");
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("uID", "hong");
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
                                           @RequestParam(value = "IMakeGameuID", required = false) String IMakeGameuID,
                                           @RequestParam(value = "IPartiGameuID", required = false) String IPartiGameuID
                                            ) throws Exception{
        List<GameListVO> gameList = null;
        System.out.println("RESTfull controller parameter pageNum : " + pageNum);
        System.out.println("RESTfull controller parameter rowNum : " + rowNum);
        gameList = gameService.selectGameList(pageNum, rowNum, sRegion, search, IMakeGameuID, IPartiGameuID);

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

    @Override
    @GetMapping(value = "/gameInfo.do")
    public ModelAndView selectGameInfo(@RequestParam(value="gID", required = false, defaultValue = "1") int gID) throws Exception {
        String uID = "heo";
        ModelAndView mav = new ModelAndView();
        GameInfoVO gameInfoVO = new GameInfoVO();
        GameAwayTeamInfoVO gameAwayTeamInfoVO = new GameAwayTeamInfoVO();
        SquadVO squadVO = new SquadVO();
        gameInfoVO = gameService.selectGameInfo(gID, uID);
        if(gameInfoVO != null) {
            System.out.println("controller gameInfo.getSRegion: " + gameInfoVO.getsRegion());
            System.out.println("controller gameMemberList 첫 번째 uName : " + gameInfoVO.getGameMemberList().get(0).getuName());
            mav.addObject("gameInfoVO", gameInfoVO);
        }
        if(gameInfoVO.gettAwayID() != 0) {
            gameAwayTeamInfoVO = gameService.selectAwayTeam(gID, gameInfoVO.gettAwayID());
            System.out.println("gID : " + gID + "gameInfoVO.gettAwayID() : " + gameInfoVO.gettAwayID());
            mav.addObject("gameAwayTeamInfoVO", gameAwayTeamInfoVO);
            System.out.println("gameAwayTeamInfoVO : " + gameAwayTeamInfoVO.getAwayTeamName());
        }
        mav.setViewName("/game/gameInfo");
        return mav;
    }

    @Override
    @PostMapping(value="/comment/gameInfo.do")
    @ResponseBody
    public List<GCommentVO> insertComments(@ModelAttribute("gCommentVO") GCommentVO gCommentVO) throws Exception {
        String uID = "heo";
        gCommentVO.setuID(uID);
        gCommentVO.setComCreatedID(uID);
        List<GCommentVO> insertCommentsResult = null;
        System.out.println("Controller 입력된 gCommentVO.getgID() : " + gCommentVO.getgID());
        insertCommentsResult = gameService.insertComments(gCommentVO);
        System.out.println("gCommentsList.get(0).getuName() : " + insertCommentsResult.get(0).getuName());
        return insertCommentsResult;
    }
    @Override
    @PostMapping(value="/partiHome/gameInfo.do")
    @ResponseBody
    public  List<GameMemberListVO> partiHomeTeam(@RequestParam(value="gID", required = false, defaultValue = "1") int gID,
                                                 @RequestParam(value="gTeamID", required = false, defaultValue = "1") int gTeamID
                                                ) throws Exception {
        SquadVO squadVO = new SquadVO();
        squadVO.setgID(gID);
        squadVO.settID(gTeamID);
        squadVO.setuID("insi");
        squadVO.setCreatedID("insi");
        List<GameMemberListVO> gameMemberList = gameService.insertAndSelectHomeTeam(squadVO);
        System.out.println("gameMemberList.isEmpty() : " + gameMemberList.isEmpty());
        return gameMemberList;
    }

    @Override
    @PostMapping(value="/partiAway/gameInfo.do")
    @ResponseBody
    public GameAwayTeamInfoVO insertAndSelectAwayTeam(@RequestParam(value="gID", required = false, defaultValue = "0") int gID,
                                                      @RequestParam(value="tAwayID", required = false, defaultValue = "0") int tAwayID
                                                         ) throws Exception {
        GameAwayTeamInfoVO gameAwayTeamInfoVO = new GameAwayTeamInfoVO();

        SquadVO squadVO = new SquadVO();
        squadVO.setgID(gID);
        squadVO.settID(tAwayID);
        squadVO.setuID("baba");
        squadVO.setCreatedID("baba");


        gameAwayTeamInfoVO = gameService.awayTeamIntoGame(squadVO);


        System.out.println("controller gameAwayTeamInfoVO : " + gameAwayTeamInfoVO.getAwayTeamName());

        gameAwayTeamInfoVO.settAwayID(tAwayID);
        return gameAwayTeamInfoVO;
    }

    @Override
    @PostMapping(value="/partiAwayMember/gameInfo.do")
    @ResponseBody
    public GameAwayTeamInfoVO insertawayTeamMembr(@RequestParam(value="gID", required = false, defaultValue = "0") int gID,
                                                  @RequestParam(value="tAwayID", required = false, defaultValue = "0") int tAwayID
                                                 ) throws Exception {
        GameAwayTeamInfoVO gameAwayTeamInfoVO = new GameAwayTeamInfoVO();

        SquadVO squadVO = new SquadVO();
        squadVO.setgID(gID);
        squadVO.settID(tAwayID);
        squadVO.setuID("baba");
        squadVO.setCreatedID("baba");

        if(tAwayID != 0) {
            gameAwayTeamInfoVO = gameService.insertawayTeamMembr(squadVO);
        }
        return gameAwayTeamInfoVO;
    }

    @Override
    @PostMapping(value = "/gameResult.do")
    public String  intoGameResult(@RequestParam(value="gID", required = false, defaultValue = "0") int gID,
                                       @RequestParam(value="sRegion", required = false) String sRegion,
                                       @RequestParam(value="gTitle", required = false)  String gTitle,
                                       @RequestParam(value="gTeamID", required = false, defaultValue = "0") int gTeamID,
                                       @RequestParam(value="tAwayID", required = false, defaultValue = "0") int tAwayID,
                                        RedirectAttributes redirectAttributes) throws Exception {
        String uID = "heo";
        ModelAndView mav = new ModelAndView();
        String homeTeamName = gameService.selectAwayTeamName(gTeamID);
        String awayTeamName = gameService.selectAwayTeamName(tAwayID);
        System.out.println("1 gID : " + gID);
        System.out.println("1 tAwayID : " + tAwayID);
        redirectAttributes.addAttribute("gID", gID);
        redirectAttributes.addAttribute("sRegion", sRegion);
        redirectAttributes.addAttribute("gTitle", gTitle);
        redirectAttributes.addAttribute("gTeamID", gTeamID);
        redirectAttributes.addAttribute("tAwayID", tAwayID);

        return "redirect:/game/gameResultView";
    }
    @Override
    @GetMapping("/gameResultView")
    public ModelAndView intoGameResultHadler(@RequestParam(value="gID", required = false, defaultValue = "0") int gID,
                                             @RequestParam(value="sRegion", required = false) String sRegion,
                                             @RequestParam(value="gTitle", required = false)String gTitle,
                                             @RequestParam(value="gTeamID", required = false) int gTeamID,
                                             @RequestParam(value="tAwayID", required = false) int tAwayID
                                                ) throws Exception {
        String uID = "heo";
        ModelAndView mav = new ModelAndView("/game/gameResult");
        String homeTeamName = gameService.selectAwayTeamName(gTeamID);
        String awayTeamName = gameService.selectAwayTeamName(tAwayID);
        System.out.println("2 gID : " + gID);
        System.out.println("2 tAwayID : " + tAwayID);
        mav.addObject("uID", uID);
        mav.addObject("gID", gID);
        mav.addObject("sRegion", sRegion);
        mav.addObject("gTitle", gTitle);
        mav.addObject("gTeamID", gTeamID);
        mav.addObject("tAwayID", tAwayID);
        mav.addObject("homeTeamName", homeTeamName);
        mav.addObject("awayTeamName", awayTeamName);
        return mav;
    }

    @Override
    @PostMapping(value = "insert/gameResult.do")
    public ModelAndView insertGameResult(@RequestParam(value="gID", required = false, defaultValue = "0") int gID,
                                         @RequestParam(value="gTeamID", required = false, defaultValue = "0") int gTeamID,
                                         @RequestParam(value="tAwayID", required = false, defaultValue = "0") int tAwayID,
                                         @RequestParam(value="homeTeamScoreHidden", required = false, defaultValue = "0") int homeTeamScore,
                                         @RequestParam(value="awayTeamScoreHidden", required = false, defaultValue = "0") int awayTeamScore,
                                         @RequestParam(value="uID", required = false) String uID
                                         ) throws Exception {

        ModelAndView mav = new ModelAndView("redirect:/game/gameList");
        System.out.println("3 gID : " + gID);
        System.out.println("3 tAwayID : " + tAwayID);
        GResultVO gResultVO = new GResultVO();
        gResultVO.setgID(gID);
        gResultVO.settHomeID(gTeamID);
        gResultVO.settAwayID(tAwayID);
        gResultVO.setHomeGoal(homeTeamScore);
        gResultVO.setAwayGoal(awayTeamScore);
        gResultVO.setuID(uID);
        gResultVO.setCreatedID(uID);
        gameService.insertGameResult(gResultVO);
        return mav;
    }
    @Override
    @GetMapping(value="/stadiumList.do")
    public ModelAndView selectStadiumInfo() throws Exception {
        String sRegion = null;
        String search = null;
        ModelAndView mav = new ModelAndView("/game/stadiumList");
        List<StadiumVO> stadiumVO = gameService.selectStadiumInfo(sRegion, search);
        mav.addObject("stadiumVO", stadiumVO);
        return mav;
    }

    @Override
    @PostMapping(value="/search/stadiumList.do")
    @ResponseBody
    public List<StadiumVO> searchStadiumInfo(@RequestParam(value="sRegion", required = false) String sRegion,
                                             @RequestParam(value="search", required = false) String search
                                            ) throws Exception{
        List<StadiumVO> stadiumList = gameService.selectStadiumInfo(sRegion, search);
        return stadiumList;
    }
}
