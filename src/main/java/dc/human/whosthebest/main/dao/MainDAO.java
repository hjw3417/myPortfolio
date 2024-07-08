package dc.human.whosthebest.main.dao;

import dc.human.whosthebest.vo.BoardVO;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("mainDAO")
public interface MainDAO {

    List<TeamInfoVO> mainRanking() throws DataAccessException;
    List<GameListVO> mainGameList() throws DataAccessException;
    List<BoardVO> mainBoardList() throws DataAccessException;
    List<BoardVO> mainServiceBoard() throws DataAccessException;
    int mainBoardWrite(BoardVO boardVO) throws DataAccessException;
    BoardVO mainBoardDetail(int bID) throws DataAccessException;
}
