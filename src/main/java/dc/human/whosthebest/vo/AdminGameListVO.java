package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

/*xml  처리 위한 VO라  DB에 생성 안합니다!!!!*/

@Component("adminGameListVO")
public class AdminGameListVO {

    private int gID;               //G_ID(경기 아이디/sequence)
    private int gTeamID;           //G_TEAMID(팀 ID)
    private String gTitle;           //G_TITLE(경기 제목)
    private int gTime;             //G_TIME(경기 진행 시간)
    private String gInfo;          //G_INFO(경기 관련 설명)
    private int gMinMember;        //G_MINMEMBER(경기 시작 최소 인원)
    private String gResTime;       //G_RESTIME(경기장 예약 시간)
    private String gResDate;       //G_RESDATE(경기장 예약 일자)
    private int gStatus;           //G_STATUS(경기 상태)
    private int tID;               //T_ID(경기 생성자 팀 ID)
    private int tAwayID;           //T_AWAYID(경기 상대 팀)
    private int sID;               //S_ID(경기장 ID)
    private int sNum;              //S_NUM(경기장 내 번호)

    private String tName;

    //private int gID;				//G_ID(경기 ID)
    private int tHomeID;            //T_HOMEID(경기 생성자 팀 ID)
    //private int tAwayID;			//T_AWAYID(경기 상대방 팀 ID)
    private int homeGoal;            //HOME_GOAL(생성자 측 골 수)
    private int awayGoal;            //AWAY_GOAL(상대 측 골 수)
    private String uID;                //U_ID(경기 생성자 ID)

    private String sName;		//S_NAME(경기장 명)

    public AdminGameListVO() {
    }


    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public int getgTeamID() {
        return gTeamID;
    }

    public void setgTeamID(int gTeamID) {
        this.gTeamID = gTeamID;
    }

    public String getgTitle() {
        return gTitle;
    }

    public void setgTitle(String gTitle) {
        this.gTitle = gTitle;
    }

    public int getgTime() {
        return gTime;
    }

    public void setgTime(int gTime) {
        this.gTime = gTime;
    }

    public String getgInfo() {
        return gInfo;
    }

    public void setgInfo(String gInfo) {
        this.gInfo = gInfo;
    }

    public int getgMinMember() {
        return gMinMember;
    }

    public void setgMinMember(int gMinMember) {
        this.gMinMember = gMinMember;
    }

    public String getgResTime() {
        return gResTime;
    }

    public void setgResTime(String gResTime) {
        this.gResTime = gResTime;
    }

    public String getgResDate() {
        return gResDate;
    }

    public void setgResDate(String gResDate) {
        this.gResDate = gResDate;
    }

    public int getgStatus() {
        return gStatus;
    }

    public void setgStatus(int gStatus) {
        this.gStatus = gStatus;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public int gettAwayID() {
        return tAwayID;
    }

    public void settAwayID(int tAwayID) {
        this.tAwayID = tAwayID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public int getsNum() {
        return sNum;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
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
}
