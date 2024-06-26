package dc.human.whosthebest.admin.service;

import dc.human.whosthebest.admin.dao.AdminGameListDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminGameListService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminGameListServiceImpl implements AdminGameListService{
    @Autowired
    private AdminGameListDAO adminGameListDAO;

    @Override
    public List listGames() throws Exception{
        System.out.println("게임 서비스 완료");
        List gamesList = null;
        gamesList = adminGameListDAO.selectGameList();
        return gamesList;
    }


}
