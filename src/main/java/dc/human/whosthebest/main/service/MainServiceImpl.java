package dc.human.whosthebest.main.service;

import dc.human.whosthebest.main.dao.MainDAO;
import dc.human.whosthebest.vo.GameListVO;
import dc.human.whosthebest.vo.TeamInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mainService")
public class MainServiceImpl implements MainService {

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
}
