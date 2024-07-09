package dc.human.whosthebest.vo;

import java.util.List;

public class GameAwayTeamInfoVO {
    private String awayTeamName;
    private List<GameMemberListVO> awayTeamMemberList;
    private int tAwayID;
    private int nowPartiMemberNum;
    private boolean checkDuplicateSquadResult;//nowPartiMemberNum
    private boolean isAwayTeamExist;

    public GameAwayTeamInfoVO() {
    }

    public boolean getIsAwayTeamExist() {
        return isAwayTeamExist;
    }

    public void setIsAwayTeamExist(boolean isAwayTeamExist) {
        this.isAwayTeamExist = isAwayTeamExist;
    }

    public int gettAwayID() {
        return tAwayID;
    }

    public void settAwayID(int tAwayID) {
        this.tAwayID = tAwayID;
    }

    public boolean isCheckDuplicateSquadResult() {

        return checkDuplicateSquadResult;
    }

    public void setCheckDuplicateSquadResult(boolean checkDuplicateSquadResult) {
        this.checkDuplicateSquadResult = checkDuplicateSquadResult;
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
