package dc.human.whosthebest.vo;

public class GameRecordVO {
    //G_RESULT TABLE
    private int gID;				//G_ID(경기 ID)
    private int tHomeID;			//T_HOMEID(경기 생성자 팀 ID)
    private int tAwayID;			//T_AWAYID(경기 상대방 팀 ID)
    private int homeGoal;			//HOME_GOAL(생성자 측 골 수)
    private int awayGoal;			//AWAY_GOAL(상대 측 골 수)
    private String uID;				//U_ID(경기 생성자 ID)
    private String createdID;		//UPDATED_ID(생성자 ID/DB에서 생성)
    private String createdDate;		//CREATED_DATE(생성 날짜/DB에서 생성)
    private String updatedID;		//UPDATED_ID(업데이트 ID/DB에서 생성)
    private String updatedDate;		//UPDATED_DATE(업데이트 날짜/DB에서 생성)

    private int totalMatchCount;
//    //homeGoal과 awayGoal의 차
//    private int isWinner(int homeGoal, int awayGoal) {
//        int isWinnerResult = homeGoal - awayGoal;
//    }


    public GameRecordVO() {}

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public int gettHomeID() {
        return tHomeID;
    }

    public void settHomeID(int tHomeID) {
        this.tHomeID = tHomeID;
    }

    public int gettAwayID() {
        return tAwayID;
    }

    public void settAwayID(int tAwayID) {
        this.tAwayID = tAwayID;
    }

    public int getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(int homeGoal) {
        this.homeGoal = homeGoal;
    }

    public int getAwayGoal() {
        return awayGoal;
    }

    public void setAwayGoal(int awayGoal) {
        this.awayGoal = awayGoal;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
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

    public int getTotalMatchCount() {
        return totalMatchCount;
    }

    public void setTotalMatchCount(int totalMatchCount) {
        this.totalMatchCount = totalMatchCount;
    }
}
