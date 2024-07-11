package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamProfileVO {
    private int tID;
    private String tName;
    private String rankName;
    private String tRankScore;
    private int tMember;
    private String createdID;		//UPDATED_ID(생성자 ID/DB에서 생성)
    private String createdDate;		//CREATED_DATE(생성 날짜/DB에서 생성)
    private String updatedID;		//UPDATED_ID(업데이트 ID/DB에서 생성)
    private String updatedDate;		//UPDATED_DATE(업데이트 날짜/DB에서 생성)
    private GameRecordVO gameRecordVO;



    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String gettRankScore() {
        return tRankScore;
    }

    public void settRankScore(String tRankScore) {
        this.tRankScore = tRankScore;
    }

    public int gettMember() {
        return tMember;
    }

    public void settMember(int tMember) {
        this.tMember = tMember;
    }

    public String getCreatedID() {
        return createdID;
    }

    public void setCreatedID(String createdID) {
        this.createdID = createdID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedID() {
        return updatedID;
    }

    public void setUpdatedID(String updatedID) {
        this.updatedID = updatedID;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public GameRecordVO getGameRecordVO() {
        return gameRecordVO;
    }

    public void setGameRecordVO(GameRecordVO gameRecordVO) {
        this.gameRecordVO = gameRecordVO;
    }

}
