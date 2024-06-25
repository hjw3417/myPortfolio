package dc.human.whosthebest.vo;

public class StadiumResRawVO {
    private String sId;                  // 경기장 id
    private String sResDate;             // 경기장 예약 일시
    private int sResSTime;               // 경기 시작 시간
    private int sResETime;               // 경기 종료 시간
    private int sResNum;
    private String sResCreatedId;        // 데이터 생성 ID
    private String sResUpdatedId;        // 데이터 업데이트 ID

    public StadiumResRawVO() {
    }

    public StadiumResRawVO(String sId, String sResDate, int sResSTime, int sResETime, int sResNum, String sResCreatedId, String sResUpdatedId) {
        this.sId = sId;
        this.sResDate = sResDate;
        this.sResSTime = sResSTime;
        this.sResETime = sResETime;
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

    public int getsResSTime() {
        return sResSTime;
    }

    public void setsResSTime(int sResSTime) {
        this.sResSTime = sResSTime;
    }

    public int getsResETime() {
        return sResETime;
    }

    public void setsResETime(int sResETime) {
        this.sResETime = sResETime;
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
