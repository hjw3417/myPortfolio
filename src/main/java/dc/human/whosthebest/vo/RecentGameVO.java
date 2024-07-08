package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

@Component("recentGameVO")
public class RecentGameVO {

    //team
    private int tID;
    private String tName;
    private String gResDate;
    private String myTeam;
    private String awayTeam;


    private int gID;				//G_ID(경기 ID)
    private int tHomeID;			//T_HOMEID(경기 생성자 팀 ID)
    private int tAwayID;			//T_AWAYID(경기 상대방 팀 ID)
    private int homeGoal;			//HOME_GOAL(생성자 측 골 수)
    private int awayGoal;			//AWAY_GOAL(상대 측 골 수)
    private String uID;				//U_ID(경기 생성자 ID)
    private String createdID;
    private int sID;			//S_ID(경기장 ID)
    private String sName;

    public RecentGameVO() {}

    public String getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(String myTeam) {
        this.myTeam = myTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getgResDate() {
        return gResDate;
    }

    public void setgResDate(String gResDate) {
        this.gResDate = gResDate;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getCreatedID() {
        return createdID;
    }

    public void setCreatedID(String createdID) {
        this.createdID = createdID;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public int getAwayGoal() {
        return awayGoal;
    }

    public void setAwayGoal(int awayGoal) {
        this.awayGoal = awayGoal;
    }

    public int getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(int homeGoal) {
        this.homeGoal = homeGoal;
    }

    public int gettAwayID() {
        return tAwayID;
    }

    public void settAwayID(int tAwayID) {
        this.tAwayID = tAwayID;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int gettHomeID() {
        return tHomeID;
    }

    public void settHomeID(int tHomeID) {
        this.tHomeID = tHomeID;
    }
}
