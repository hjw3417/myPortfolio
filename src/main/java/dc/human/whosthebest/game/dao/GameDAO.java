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

import dc.human.whosthebest.vo.StadiumVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository("GameDAO")
public interface GameDAO {
    public List<TeamInfoVO> loadMyTeam(String uID) throws DataAccessException;
    public List<StadiumVO> selectStadium(String sRegion, String search) throws DataAccessException;
    public StadiumVO stadiumDetail(int sID) throws DataAccessException;
}
