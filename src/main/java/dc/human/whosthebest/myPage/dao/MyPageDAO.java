package dc.human.whosthebest.myPage.dao;

import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("myPageDAO")
public interface MyPageDAO {

   public List selectMyPageInfo(String uID) throws DataAccessException;
   public List selectRecentGame(String uID) throws  DataAccessException;

   public UserInfoVO selectMyInfo(String uID, String uPW) throws  DataAccessException;

   public List selectAllMyInfo(String uID) throws DataAccessException;

   public void updateInfo(String uID, String uName, String uBday,
                          String uAddr1, String uAddr2, String uEmail,
                          String uPhone, String uPW) throws DataAccessException;


 }
