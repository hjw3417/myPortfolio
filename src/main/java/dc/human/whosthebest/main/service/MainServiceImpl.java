package dc.human.whosthebest.main.service;

import dc.human.whosthebest.main.dao.MainDAO;
import dc.human.whosthebest.vo.BoardVO;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("mainService")
public class MainServiceImpl implements MainService {

    java.util.Date now = new java.util.Date();
    Date sqlDate = new Date(now.getTime());

    @Autowired
    private MainDAO mainDAO;

    @Override
    public List<TeamInfoVO> mainRanking() throws Exception{
        List<TeamInfoVO> mainRanking;
        mainRanking = mainDAO.mainRanking();
        System.out.println("메인랭킹 서비스 시스아웃"+mainRanking);
        return mainRanking;
    }

    @Override
    public List<GameListVO> mainGameList() throws Exception{
        List<GameListVO> mainGameList;
        mainGameList = mainDAO.mainGameList();
        return  mainGameList;
    }

    @Override
    public List<BoardVO> mainBoardList() throws Exception{
        List<BoardVO> mainBoardList;
        mainBoardList = mainDAO.mainBoardList();

        return mainBoardList;
    }

    @Override
    public List<BoardVO> mainServiceBoard() throws Exception{
        List<BoardVO> mainServiceBoard;
        mainServiceBoard = mainDAO.mainServiceBoard();

        return mainServiceBoard;
    }

    @Override
    public int mainBoardWrite(BoardVO boardVO) throws Exception{
        boardVO.setCreatedDate(sqlDate.toString());
        boardVO.setCreatedID("hong");
        return mainDAO.mainBoardWrite(boardVO);
    }

    @Override
    public BoardVO mainBoardDetail(int bID) throws Exception{
        return mainDAO.mainBoardDetail(bID);
    }

}
