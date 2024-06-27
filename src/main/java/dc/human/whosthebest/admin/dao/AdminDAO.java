package dc.human.whosthebest.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("adminDAO")
public interface AdminDAO {

    //회원목록 조회
    public List selectAllUserList() throws DataAccessException;

    //팀목록 조회
    public List selectAllTeamList() throws DataAccessException;

    //경기목록 조회
    public List selectGameList() throws DataAccessException;
}
