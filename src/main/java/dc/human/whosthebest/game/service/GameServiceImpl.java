/*
PROJECT        : whosthebest
PROGRAM ID    :  GameService.java
PROGRAM NAME    : game Service
DESCRIPTION    : game 관련 DB 데이터 전송
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
======================================================
*/
package dc.human.whosthebest.game.service;

import dc.human.whosthebest.game.dao.GameDAO;
import dc.human.whosthebest.vo.StadiumVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("gameService")
@Transactional(propagation = Propagation.REQUIRED)
public class GameServiceImpl implements  GameService {
    @Autowired
    private GameDAO gameDAO;

    /**
     * 사용자 ID에 해당하는 팀 정보를 로드합니다.
     *
     * @param uID 사용자 ID를 나타내는 문자열.
     * @return 사용자 ID에 해당하는 팀 정보 리스트.
     * @throws Exception 데이터 로드 중 발생할 수 있는 예외.
     */
    @Override
    public List<TeamInfoVO> loadMyTeam(String uID) throws Exception {
        List<TeamInfoVO> teamNameList = null;
        teamNameList = gameDAO.loadMyTeam(uID);
        return teamNameList;
    }

    @Override
    public List<StadiumVO> selectStadium(String sRegion, String search) throws  Exception {
        List<StadiumVO> stadiumList = null;
        System.out.println("service sRegion : " + sRegion);
        System.out.println("service search : " + search);
        stadiumList = gameDAO.selectStadium(sRegion, search);
        return stadiumList;
    }

    @Override
    public List<StadiumVO> stadiumDetil(int sID) throws  Exception {
        List<StadiumVO> stadiumDetilList = null;
        System.out.println("service sID : " + sID);
        stadiumDetilList = gameDAO.stdiumDetail(sID);
        return stadiumDetilList;
    }
}
