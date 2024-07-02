package dc.human.whosthebest.main.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("mainDAO")
public interface MainDAO {
    List<String> mainRanking(String tName) throws DataAccessException;
    List<String> mainGameList(String gTitle) throws DataAccessException;
}
