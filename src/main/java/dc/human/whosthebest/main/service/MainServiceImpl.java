package dc.human.whosthebest.main.service;

import dc.human.whosthebest.main.dao.MainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mainService")
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDAO mainDAO;

    @Override
    public List<String> mainRanking(String tName) throws Exception{
        List<String> mainRanking;
        mainRanking = mainDAO.mainRanking(tName);
        return mainRanking;
    }

    @Override
    public List<String> mainGameList(String gTitle) throws Exception{
        List<String> mainGameList;
        mainGameList = mainDAO.mainGameList(gTitle);
        return  mainGameList;
    }
}
