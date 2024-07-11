package dc.human.whosthebest.admin.dao;

import dc.human.whosthebest.vo.AdminGameListVO;

import dc.human.whosthebest.vo.TeamInfoVO;
import dc.human.whosthebest.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
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

    //관리자메인페이지 - 최근 회원 목록 조회
    public List selectNewUserList() throws  DataAccessException;

    //관리자메인페이지 - 최근 팀 목록 조회
    public List selectNewTeamList() throws DataAccessException;

    //회원 상세보기
    UserInfoVO selectUserDetailById(@Param("uID") String uID) throws DataAccessException;

    //팀 상세보기
    TeamInfoVO selectTeamDetailById(@Param("tID")String tID) throws DataAccessException;

    //게임 상세보기
    AdminGameListVO selectGameDetailById(@Param("gID")String gID) throws DataAccessException;
}
