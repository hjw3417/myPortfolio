package dc.human.whosthebest.admin.service;

import dc.human.whosthebest.admin.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminServiceImpl implements  AdminService{

    @Autowired
    private AdminDAO adminDAO;
    
    //회원목록
    @Override
    public List listUsers() throws Exception{
        System.out.println("서비스 돌아감");
        List usersList = null;
        usersList = adminDAO.selectAllUserList();
        return usersList;
    }
    
    //팀목록
    @Override
    public List listTeams() throws Exception{
        List teamsList = null;
        teamsList = adminDAO.selectAllTeamList();
        return teamsList;
    }
    
    //경기목록
    @Override
    public List listGames() throws Exception{
        System.out.println("게임 서비스 완료");
        List gamesList = null;
        gamesList = adminDAO.selectGameList();
        return gamesList;
    }
}
