package dc.human.whosthebest.admin.dao;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("adminUserListDAO")
public interface AdminUserListDAO {
    public List selectAllUserList() throws DataAccessException;


}
