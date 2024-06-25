package dc.human.whosthebest.vo;

public class StadiumResInfoVO {
    private String sId;                  // 경기장 id
    private String sResDate;             // 경기장 예약 일시
    private int sResGameTime;            // 경기 시간
    private int sResNum;                 //경기장 번호
    private String sResCreatedId;        // 데이터 생성 ID
    private String sResUpdatedId;        // 데이터 업데이트 ID

    public StadiumResInfoVO(String sId, String sResDate, int sResGameTime, int sResNum, String sResCreatedId, String sResUpdatedId) {
        this.sId = sId;
        this.sResDate = sResDate;
        this.sResGameTime = sResGameTime;
        this.sResNum = sResNum;
        this.sResCreatedId = sResCreatedId;
        this.sResUpdatedId = sResUpdatedId;
    }

    public int getsResNum() {
        return sResNum;
    }

    public void setsResNum(int sResNum) {
        this.sResNum = sResNum;
    }

    public StadiumResInfoVO() {

    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsResDate() {
        return sResDate;
    }

    public void setsResDate(String sResDate) {
        this.sResDate = sResDate;
    }

    public int getsResGameTime() {
        return sResGameTime;
    }

    public void setsResGameTime(int sResGameTime) {
        this.sResGameTime = sResGameTime;
    }

    public String getsResCreatedId() {
        return sResCreatedId;
    }

    public void setsResCreatedId(String sResCreatedId) {
        this.sResCreatedId = sResCreatedId;
    }

    public String getsResUpdatedId() {
        return sResUpdatedId;
    }

    public void setsResUpdatedId(String sResUpdatedId) {
        this.sResUpdatedId = sResUpdatedId;
    }
}

