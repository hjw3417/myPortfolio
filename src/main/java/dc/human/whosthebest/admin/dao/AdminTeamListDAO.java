package dc.human.whosthebest.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository("adminTeamListDAO")
public interface AdminTeamListDAO {
    public List selectAllTeamList() throws DataAccessException;

}
