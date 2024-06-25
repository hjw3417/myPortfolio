package dc.human.whosthebest.user.service;

import dc.human.whosthebest.user.dao.JoinDAO;
import dc.human.whosthebest.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("joinService")
@Transactional(propagation = Propagation.REQUIRED)
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinDAO joinDAO;

    @Override
    public int insertJoin(UserInfoVO userInfoVO) throws Exception{

        return joinDAO.insertJoin(userInfoVO);
    }
}
