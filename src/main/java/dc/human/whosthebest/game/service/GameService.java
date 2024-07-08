/*
PROJECT        : whosthebest
PROGRAM ID    :  GameService.java
PROGRAM NAME    : game Service Interface
DESCRIPTION    : game 관련 DB 데이터 전송 Interface
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
======================================================
*/
package dc.human.whosthebest.game.service;

import dc.human.whosthebest.vo.*;

import java.util.List;

public interface GameService {
    public List<TeamInfoVO> loadMyTeam(String uID) throws Exception;
    public List<StadiumVO> selectStadium(String sRegion, String search) throws  Exception;
    public StadiumVO stadiumDetail(int sID) throws  Exception;
    public int createGame(GameVO gameVO) throws  Exception;
    public List<GameListVO> selectGameList(int pageNum,
                                           int rowNum,
                                           String sRegion,
                                           String search,
                                           String IMakeGameuID,
                                           String IPartiGameuID
                                           ) throws Exception;
    public GameInfoVO selectGameInfo(int gID, String uID) throws Exception;
    public List<GCommentVO> insertComments(GCommentVO gCommentVO) throws Exception;
    public List<GameMemberListVO> insertAndSelectHomeTeam(SquadVO squadVO) throws  Exception;
    public GameAwayTeamInfoVO selectAwayTeam(int gID, int tID) throws  Exception;
    public GameAwayTeamInfoVO awayTeamIntoGame(SquadVO squadVO) throws  Exception;
    public GameAwayTeamInfoVO insertawayTeamMembr(SquadVO squadVO) throws Exception;
    public String selectAwayTeamName(int tID) throws Exception;
    public int insertGameResult(GResultVO gResultVO) throws Exception;
    public List<StadiumVO> selectStadiumInfo(int pageNum, int rowNum, String sRegion, String search) throws  Exception;
    public GameVO selectForModGame(int gID) throws Exception;
    public int deleteGame(int gID) throws Exception;
    public int modGame(GameVO gameVO) throws  Exception;
    public int updateGameState(int gID, int gStatus) throws Exception;
}
