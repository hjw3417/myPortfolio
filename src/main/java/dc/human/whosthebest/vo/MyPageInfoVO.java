package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

@Component("myPageInfoVO")
//MyPage
public class MyPageInfoVO {

    //userInfVO
    private String uID;
    private String uName;
    private String uBday;
    private String uAddr1;
    private String uAddr2;
    private String uEmail;
    private String uPhone;
    private String uGender;
    private String uPW;
    private byte[] uPhoto;
    private String createdID;
    private String createdDate;
    private String updatedID;
    private String updatedDate;


    //teamInfoVO
    private int tID;
    private String tName;
    private byte[] tLogo;
    private String tRegion;
    private String tPhone;
    private int tRankScore;


    //squadVO
    private int gID;

    //gameStadiumVO
    private int gameId;
    private String gameTitle;
    private String gameResDate;
    private String stadiumName;
    private String gameStatus;

    //adminGameListVO

    private int gTeamID;           //G_TEAMID(팀 ID)
    private String gTitle;           //G_TITLE(경기 제목)
    private int gTime;             //G_TIME(경기 진행 시간)
    private String gInfo;          //G_INFO(경기 관련 설명)
    private int gMinMember;        //G_MINMEMBER(경기 시작 최소 인원)
    private String gResTime;       //G_RESTIME(경기장 예약 시간)
    private String gResDate;       //G_RESDATE(경기장 예약 일자)
    private int gStatus;           //G_STATUS(경기 상태)
    private int tAwayID;           //T_AWAYID(경기 상대 팀)
    private int sID;               //S_ID(경기장 ID)
    private int sNum;              //S_NUM(경기장 내 번호)
    private int tHomeID;            //T_HOMEID(경기 생성자 팀 ID)
    private int homeGoal;            //HOME_GOAL(생성자 측 골 수)
    private int awayGoal;            //AWAY_GOAL(상대 측 골 수)
    private String sName;


    public MyPageInfoVO(){}


    public String getuBday() {
        return uBday;
    }

    public void setuBday(String uBday) {
        this.uBday = uBday;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuAddr1() {
        return uAddr1;
    }

    public void setuAddr1(String uAddr1) {
        this.uAddr1 = uAddr1;
    }

    public String getuAddr2() {
        return uAddr2;
    }

    public void setuAddr2(String uAddr2) {
        this.uAddr2 = uAddr2;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuPW() {
        return uPW;
    }

    public void setuPW(String uPW) {
        this.uPW = uPW;
    }

    public byte[] getuPhoto() {
        return uPhoto;
    }

    public void setuPhoto(byte[] uPhoto) {
        this.uPhoto = uPhoto;
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

    public byte[] gettLogo() {
        return tLogo;
    }

    public void settLogo(byte[] tLogo) {
        this.tLogo = tLogo;
    }

    public String gettRegion() {
        return tRegion;
    }

    public void settRegion(String tRegion) {
        this.tRegion = tRegion;
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    public int gettRankScore() {
        return tRankScore;
    }

    public void settRankScore(int tRankScore) {
        this.tRankScore = tRankScore;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameResDate() {
        return gameResDate;
    }

    public void setGameResDate(String gameResDate) {
        this.gameResDate = gameResDate;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
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

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
