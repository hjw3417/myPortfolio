/*
PROJECT        : whosthebest
PROGRAM ID    :  GameDAO.java
PROGRAM NAME    : game DAO Interface
DESCRIPTION    : game 관련 DB 연동 Interface
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
======================================================
*/
package dc.human.whosthebest.game.dao;

import dc.human.whosthebest.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Mapper
@Repository("GameDAO")
public interface GameDAO {

    /**
     * 주어진 사용자 ID에 해당하는 팀 정보를 로드합니다.
     *
     * @param uID 사용자 ID를 나타내는 문자열
     * @return 주어진 사용자 ID에 해당하는 {@link TeamInfoVO} 객체의 리스트
     * @throws DataAccessException 데이터 액세스 중 예외가 발생한 경우
     */
    public List<TeamInfoVO> loadMyTeam(String uID) throws DataAccessException;
    /**
     * 주어진 지역과 검색어에 해당하는 경기장 정보를 조회합니다.
     *
     * @param sRegion 지역을 나타내는 문자열
     * @param search 검색어를 나타내는 문자열
     * @return 주어진 지역과 검색어에 해당하는 {@link StadiumVO} 객체의 리스트
     * @throws DataAccessException 데이터 액세스 중 예외가 발생한 경우
     */
    public List<StadiumVO> selectStadium(String sRegion, String search) throws DataAccessException;
    /**
     * 주어진 경기장 ID에 해당하는 경기장 세부 정보를 조회합니다.
     *
     * @param sID 경기장 ID를 나타내는 정수
     * @return 주어진 경기장 ID에 해당하는 {@link StadiumVO} 객체
     * @throws DataAccessException 데이터 액세스 중 예외가 발생한 경우
     */
    public StadiumVO stadiumDetail(int sID) throws DataAccessException;
    /**
     * 주어진 GameVO 객체를 사용하여 새로운 경기를 생성합니다.
     * 이 메서드는 데이터베이스에 새로운 경기 레코드를 삽입합니다.
     *
     * @param gameVO 생성할 경기의 세부 정보를 담고 있는 GameVO 객체.
     * @return 경기 생성 작업의 결과를 나타내는 정수.
     * @throws DataAccessException 데이터 접근 중 오류가 발생한 경우.
     */
    public int createGame(GameVO gameVO) throws DataAccessException;
    /**
     * 주어진 게임 ID를 기반으로 게임 생성자를 조회합니다.
     *
     * @param gID  조회할 게임의 ID
     * @return     조회된 게임 생성자의 정보가 담긴 GameVO 객체
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public GameVO selectGameMaker(int gID) throws DataAccessException;
    /**
     * 새로운 스쿼드 레코드를 데이터베이스에 삽입합니다.
     *
     * @param squadVO  삽입할 스쿼드의 세부 정보
     * @return         새로 삽입된 스쿼드 레코드의 ID
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int insertSquad(SquadVO squadVO) throws  DataAccessException;
    /**
     * 게임 목록을 조회합니다.
     *
     * @param pageNum        조회할 페이지 번호
     * @param rowNum         페이지당 표시할 행 수
     * @param sRegion        조회할 지역
     * @param search         검색할 키워드
     * @param IMakeGameuID   사용자가 만든 게임의 사용자 ID
     * @param IPartiGameuID  사용자가 참여한 게임의 사용자 ID
     * @return               조회된 게임 목록이 담긴 GameListVO 객체의 리스트
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public List<GameListVO> selectGameList(@Param("pageNum") int pageNum,
                                           @Param("rowNum") int rowNum,
                                           @Param("sRegion") String sRegion,
                                           @Param("search") String search,
                                           @Param("IMakeGameuID") String IMakeGameuID,
                                           @Param("IPartiGameuID") String IPartiGameuID
                                           ) throws DataAccessException;
    /**
    /**
     * 주어진 게임 ID를 기반으로 게임 정보를 조회합니다.
     *
     * @param gID  조회할 게임의 ID
     * @return     조회된 게임 정보가 담긴 GameInfoVO 객체
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public GameInfoVO selectGameInfo(int gID) throws DataAccessException;
    /**
     * 주어진 스쿼드 정보를 기반으로 게임 팀 멤버 목록을 조회합니다.
     *
     * @param squadVO  조회할 스쿼드의 정보
     * @return         조회된 게임 팀 멤버 목록이 담긴 GameMemberListVO 객체의 리스트
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public  List<GameMemberListVO> selectGameTMemmber(SquadVO squadVO) throws DataAccessException;
    /**
     * 주어진 게임 ID를 기반으로 게임 댓글 목록을 조회합니다.
     *
     * @param gID  조회할 게임의 ID
     * @return     조회된 게임 댓글 목록이 담긴 GCommentVO 객체의 리스트
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public List<GCommentVO> selectComments(int gID) throws  DataAccessException;
    /**
     * 새로운 게임 댓글을 데이터베이스에 삽입합니다.
     *
     * @param gCommentVO  삽입할 게임 댓글의 세부 정보
     * @return            삽입된 댓글의 ID
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int insertComments(GCommentVO gCommentVO) throws DataAccessException;
    /**
     * 주어진 게임 ID를 기반으로 현재 참여 중인 멤버 수를 조회합니다.
     *
     * @param gID  조회할 게임의 ID
     * @return     현재 참여 중인 멤버 수
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int nowPartiMemberNum(int gID) throws DataAccessException;
    /**
     * 주어진 스쿼드 정보에 따라 중복 스쿼드 여부를 확인합니다.
     *
     * @param squadVO  확인할 스쿼드의 정보
     * @return         중복된 스쿼드가 있으면 1, 없으면 0
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int checkDuplicateSquad(SquadVO squadVO) throws DataAccessException;
    /**
     * 주어진 게임 정보에 따라 원정 팀의 존재 여부를 확인합니다.
     *
     * @param gameVO  확인할 게임의 정보
     * @return        원정 팀이 존재하면 1, 존재하지 않으면 0
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int checkAwayTeamExist(GameVO gameVO) throws DataAccessException;
    /**
     * 주어진 팀 ID를 기반으로 원정 팀의 이름을 조회합니다.
     *
     * @param tID  조회할 팀의 ID
     * @return     원정 팀의 이름
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public String selectAwayTeamName(int tID) throws DataAccessException;
    /**
     * 주어진 스쿼드 정보를 기반으로 원정 팀 ID를 업데이트합니다.
     *
     * @param squadVO  업데이트할 스쿼드의 정보
     * @return         업데이트된 행의 수
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int updateAwayTeamID(SquadVO squadVO) throws DataAccessException;
    /**
     * 새로운 게임 결과를 데이터베이스에 삽입합니다.
     *
     * @param gResultVO  삽입할 게임 결과의 세부 정보
     * @return           삽입된 게임 결과의 ID
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int insertGameResult(GResultVO gResultVO) throws DataAccessException;
    /**
     * 주어진 조건을 기반으로 경기장 정보를 조회합니다.
     *
     * @param pageNum  조회할 페이지 번호
     * @param rowNum   페이지당 표시할 행 수
     * @param sRegion  조회할 지역
     * @param search   검색할 키워드
     * @return         조회된 경기장 정보가 담긴 StadiumVO 객체의 리스트
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public List<StadiumVO> selectStadiumInfo(@Param("pageNum") int pageNum,
                                             @Param("rowNum") int rowNum,
                                             @Param("sRegion") String sRegion,
                                             @Param("search") String search
                                             ) throws DataAccessException;
    /**
     * 주어진 게임 ID를 기반으로 수정할 게임 정보를 조회합니다.
     *
     * @param gID  조회할 게임의 ID
     * @return     조회된 게임 정보가 담긴 GameVO 객체
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public GameVO selectForModGame(int gID) throws  DataAccessException;
    /**
     * 주어진 게임 ID를 기반으로 게임을 삭제합니다.
     *
     * @param gID  삭제할 게임의 ID
     * @return     삭제된 행의 수
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int deleteGame(int gID) throws DataAccessException;
    /**
     * 주어진 게임 정보를 기반으로 게임을 수정합니다.
     *
     * @param gameVO  수정할 게임의 세부 정보
     * @return        수정된 행의 수
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int modGame(GameVO gameVO) throws DataAccessException;
    /**
     * 주어진 게임 ID와 상태를 기반으로 게임 상태를 업데이트합니다.
     *
     * @param gID      업데이트할 게임의 ID
     * @param gStatus  새로운 게임 상태
     * @return         업데이트된 행의 수
     * @throws DataAccessException 데이터베이스 접근 중 오류가 발생한 경우
     */
    public int updateGameState(@Param("gID") int gID,
                               @Param("gStatus") int gStatus
                               ) throws DataAccessException;
}
