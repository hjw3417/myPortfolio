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
    public GameVO selectGameMaker(int gID) throws DataAccessException;
    public int insertSquad(SquadVO squadVO) throws  DataAccessException;
    public List<GameListVO> selectGameList(@Param("pageNum") int pageNum,
                                           @Param("rowNum") int rowNum,
                                           @Param("sRegion") String sRegion,
                                           @Param("search") String search,
                                           @Param("uID") String uID
                                           ) throws DataAccessException;
    public GameInfoVO selectGameInfo(int gID) throws DataAccessException;
    public  List<GameMemberListVO> selectGameTMemmber(SquadVO squadVO) throws DataAccessException;
    public List<GCommentVO> selectComments(int gID) throws  DataAccessException;
    public int insertComments(GCommentVO gCommentVO) throws DataAccessException;
    public int checkDuplicateSquad(SquadVO squadVO) throws DataAccessException;
}
