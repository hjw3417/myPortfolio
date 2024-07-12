package dc.human.whosthebest.admin.service;

import dc.human.whosthebest.vo.*;

import java.util.List;

public interface AdminService {

    //회원목록
    public List<UserInfoVO> listUsers() throws Exception;

    //팀목록
    public List listTeams() throws Exception;


    //경기목록
    public List listGames() throws Exception;

    //관리자메인-최근 회왼목록
    public List newUserList() throws  Exception;

    //관리자메인- 최근 팀 목록
    public List newTeamList() throws  Exception;

    //회원 상세보기
    public  List<MyPageInfoVO> getUserDetailById(String uID) throws Exception;

    //팀 상세보기
    public TeamInfoVO getTeamById(String tID) throws  Exception;
    public List<RecentGameVO> getTeamGameById(String tID) throws  Exception;

    //게임 상세보기
    public AdminGameListVO getGameDetilById(String gID) throws  Exception;
    public List<RecentGameVO> getGameResultById(String gID) throws Exception;
}
