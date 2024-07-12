package dc.human.whosthebest.vo;

public class RankVO {
    private int rankID;
    private String rankName;
    private int minScore;
    private int maxScore;
    private String createdID;
    private String createdDate;
    private String updatedID;
    private String updatedDate;


    public int getRankID() {
        return rankID;
    }
    public void setRankID(int rankID) {
        this.rankID = rankID;
    }
    public String getRankName() {
        return rankName;
    }
    public void setRankName(String rankName) {
        this.rankName = rankName;
    }
    public int getMinScore() {
        return minScore;
    }
    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }
    public int getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
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

}