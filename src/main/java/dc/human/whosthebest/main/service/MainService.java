package dc.human.whosthebest.main.service;

import dc.human.whosthebest.vo.BoardVO;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.MaingameListVO;
import dc.human.whosthebest.vo.TeamInfoVO;

import java.util.List;

public interface MainService {
    public List<TeamInfoVO> mainRanking() throws Exception;
    public List<MaingameListVO> mainGameList() throws Exception;
    public List<BoardVO> mainBoardList() throws Exception;
    public List<BoardVO> mainServiceBoard() throws Exception;
    public int mainBoardWrite(BoardVO boardVO) throws Exception;
    public BoardVO mainBoardDetail(int bID) throws Exception;
}
