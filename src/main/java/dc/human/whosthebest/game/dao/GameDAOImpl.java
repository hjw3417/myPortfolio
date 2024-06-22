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

import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gameDAO")
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
}
