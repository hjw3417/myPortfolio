package dc.human.whosthebest.vo;

public class StadiumResInfoVO {
    private String sId;                  // 경기장 id
    private String sResDate;             // 경기장 예약 일시
    private int sResGameTime;            // 경기 시간
    private String sResCreatedId;        // 데이터 생성 ID
    private String sResCreatedDate;      // 데이터 생성 날짜
    private String sResUpdatedId;        // 데이터 업데이트 ID
    private String sResUpdatedDate;      // 데이터 업데이트 날짜

    // Getters and Setters
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

    public String getsResCreatedDate() {
        return sResCreatedDate;
    }

    public void setsResCreatedDate(String sResCreatedDate) {
        this.sResCreatedDate = sResCreatedDate;
    }

    public String getsResUpdatedId() {
        return sResUpdatedId;
    }

    public void setsResUpdatedId(String sResUpdatedId) {
        this.sResUpdatedId = sResUpdatedId;
    }

    public String getsResUpdatedDate() {
        return sResUpdatedDate;
    }

    public void setsResUpdatedDate(String sResUpdatedDate) {
        this.sResUpdatedDate = sResUpdatedDate;
    }

}
