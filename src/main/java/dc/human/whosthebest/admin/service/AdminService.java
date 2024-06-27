package dc.human.whosthebest.admin.service;

import java.util.List;

public interface AdminService {

    //회원목록
    public List listUsers() throws Exception;

    //팀목록
    public List listTeams() throws Exception;


    //경기목록
    public List listGames() throws Exception;
}
