package dc.human.whosthebest.vo;

public class StadiumResInfoVO {
    private int gID;
    private String u_id;
    private String sID;                  // 경기장 id
    private String sResDate;             // 경기장 예약 일시
    private int gTime;            // 경기 시간
    private int sResNum;                 //경기장 번호
    private String sResCreatedID;        // 데이터 생성 ID
    private String sResUpdatedID;        // 데이터 업데이트 ID

    public StadiumResInfoVO(int gID, String u_id, String sID, String sResDate, int gTime, int sResNum, String sResCreatedID, String sResUpdatedID) {
        this.gID = gID;
        this.u_id = u_id;
        this.sID = sID;
        this.sResDate = sResDate;
        this.gTime = gTime;
        this.sResNum = sResNum;
        this.sResCreatedID = sResCreatedID;
        this.sResUpdatedID = sResUpdatedID;
    }

    public StadiumResInfoVO() {

    }

    public int getgTime() {
        return gTime;
    }

    public void setgTime(int gTime) {
        this.gTime = gTime;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public int getsResNum() {
        return sResNum;
    }

    public void setsResNum(int sResNum) {
        this.sResNum = sResNum;
    }


    public String getsResDate() {
        return sResDate;
    }

    public void setsResDate(String sResDate) {
        this.sResDate = sResDate;
    }


    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsResCreatedID() {
        return sResCreatedID;
    }

    public void setsResCreatedID(String sResCreatedID) {
        this.sResCreatedID = sResCreatedID;
    }

    public String getsResUpdatedID() {
        return sResUpdatedID;
    }

    public void setsResUpdatedID(String sResUpdatedID) {
        this.sResUpdatedID = sResUpdatedID;
    }
}

