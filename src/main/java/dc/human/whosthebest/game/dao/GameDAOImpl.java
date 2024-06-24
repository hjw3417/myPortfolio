/*
PROJECT        : whosthebest
PROGRAM ID    :  GameDAOImpl.java
PROGRAM NAME    : game DAO
DESCRIPTION    : game 관련 DB 연동
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
======================================================
*/
package dc.human.whosthebest.game.dao;

import dc.human.whosthebest.vo.StadiumVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("gameDAOImpl")
public class GameDAOImpl implements GameDAO {
    @Autowired
    private SqlSession sqlSession;

    /**
     * 사용자 ID에 해당하는 팀명을 로드합니다.
     *
     * @param uID 사용자 ID를 나타내는 문자열.
     * @return 사용자 ID에 해당하는 팀명 리스트.
     * @throws DataAccessException 데이터 액세스 중 발생할 수 있는 예외.
     */
    @Override
    public List<TeamInfoVO> loadMyTeam(String uID) throws DataAccessException {
        List<TeamInfoVO> teamInfoList = null;
        teamInfoList = sqlSession.selectList("mapper.game.loadMyTeam", uID);
        return teamInfoList;
    }
    /**
     * 지역과 검색어를 기반으로 경기장 목록을 검색합니다.
     * 이 메서드는 데이터베이스에서 주어진 지역과 검색어에 맞는 경기장 목록을 조회합니다.
     *
     * @param sRegion 선택한 지역
     * @param search  검색어
     * @return 경기장 목록을 포함하는 List<StadiumVO>
     * @throws DataAccessException 데이터 접근 중 오류가 발생할 경우 예외를 던집니다
     */
    @Override
    public List<StadiumVO> selectStadium(String sRegion, String search) throws DataAccessException {
        System.out.println("dao sRegion : " + sRegion);
        System.out.println("dao search : " + search);
        Map<String, Object> params = new HashMap<>();
        params.put("sRegion", sRegion);
        params.put("search", search);
        List<StadiumVO> stadiumList = null;
        stadiumList = sqlSession.selectList("mapper.game.selectStadium", params);
        return stadiumList;
    }

    @Override
    public List<StadiumVO> stdiumDetail(int sID) throws DataAccessException {
        System.out.println("dao sID : " + sID);
        List<StadiumVO> stadiumDetailList = null;
        stadiumDetailList = sqlSession.selectList("mapper.game.selectStadium", sID);
        return stadiumDetailList;
    }
}
