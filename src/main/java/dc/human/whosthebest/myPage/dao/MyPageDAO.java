package dc.human.whosthebest.myPage.dao;

import dc.human.whosthebest.vo.MyPageInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("myPageDAO")
public interface MyPageDAO {

    MyPageInfoVO selectMyPageInfo(String uID) throws DataAccessException;


}
