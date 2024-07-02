package dc.human.whosthebest.vo;

import java.util.List;

public class GameAwayTeamInfoVO {
    private String awayTeamName;
    private List<GameMemberListVO> awayTeamMemberList;
    private int nowPartiMemberNum;          //nowPartiMemberNum

    public GameAwayTeamInfoVO() {
    }

    public int getNowPartiMemberNum() {
        return nowPartiMemberNum;
    }

    public void setNowPartiMemberNum(int nowPartiMemberNum) {
        this.nowPartiMemberNum = nowPartiMemberNum;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public List<GameMemberListVO> getAwayTeamMemberList() {
        return awayTeamMemberList;
    }

    public void setAwayTeamMemberList(List<GameMemberListVO> awayTeamMemberList) {
        this.awayTeamMemberList = awayTeamMemberList;
    }
}
