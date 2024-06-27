package dc.human.whosthebest.admin.service;

import dc.human.whosthebest.admin.dao.AdminDAO;
import dc.human.whosthebest.vo.UserInfoVO;
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
        List gamesList = null;
        gamesList = adminDAO.selectGameList();
        return gamesList;
    }

    //관리자메인- 최근회원목록
    @Override
    public List newUserList() throws Exception{
        List newUserList = null;
        newUserList = adminDAO.selectNewUserList();
        return newUserList;
    }

    //관리자메인-최근팀목록
    @Override
    public List newTeamList() throws Exception{
        List newTeamList = null;
        newTeamList = adminDAO.selectNewTeamList();
        return newTeamList;
    }

    //회원 상세보기
    @Override
    public UserInfoVO getUserDetailById(String uID) throws Exception {
        System.out.println("상세보기 서비스 성공");
        return adminDAO.selectUserDetailById(uID);
    }

}
