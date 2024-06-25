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
import dc.human.whosthebest.vo.StadiumResInfoVO;
import dc.human.whosthebest.vo.StadiumResRawVO;
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
    /**
     * 지역과 검색어를 기반으로 경기장 목록을 검색합니다.
     * 이 메서드는 데이터 접근 객체(DAO)를 사용하여 주어진 지역과 검색어에 맞는 경기장 목록을 조회합니다.
     *
     * @param sRegion 선택한 지역
     * @param search  검색어
     * @return 경기장 목록을 포함하는 List<StadiumVO>
     * @throws Exception 오류가 발생할 경우 예외를 던집니다
     */
    @Override
    public List<StadiumVO> selectStadium(String sRegion, String search) throws  Exception {
        List<StadiumVO> stadiumList = null;
        System.out.println("service sRegion : " + sRegion);
        System.out.println("service search : " + search);
        stadiumList = gameDAO.selectStadium(sRegion, search);
        return stadiumList;
    }
    /**
     * 주어진 경기장 ID에 해당하는 경기장 세부 정보를 조회합니다.
     *
     * @param sID 경기장 ID를 나타내는 정수
     * @return 주어진 경기장 ID에 해당하는 {@link StadiumVO} 객체
     * @throws Exception 예외가 발생한 경우
     */
    @Override
    public StadiumVO stadiumDetail(int sID) throws  Exception {
        StadiumVO stadiumDetil = null;
        System.out.println("service sID : " + sID);
        stadiumDetil = gameDAO.stadiumDetail(sID);
        return stadiumDetil;
    }
}
