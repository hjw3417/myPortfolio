package dc.human.whosthebest.admin.service;

import dc.human.whosthebest.admin.dao.AdminTeamListDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service("adminTeamListService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminTeamListServiceImpl implements AdminTeamListService {
    @Autowired
    private AdminTeamListDAO adminTeamListDAO;

    @Override
    public List listTeams() throws Exception{
        List teamsList = null;
        teamsList = adminTeamListDAO.selectAllTeamList();
        return teamsList;
    }

}
