package dc.human.whosthebest.admin.service;



import dc.human.whosthebest.admin.dao.AdminUserListDAO;
import dc.human.whosthebest.service.MemberService;
import dc.human.whosthebest.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminUserListService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminUserListServiceImpl implements AdminUserListService {
    @Autowired
    private AdminUserListDAO adminUserListDAO;

    @Override
    public List listUsers() throws Exception{
        System.out.println("서비스 돌아감");
        List usersList = null;
        usersList = adminUserListDAO.selectAllUserList();
        return usersList;
    }
}
