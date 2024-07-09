package dc.human.whosthebest.vo;

public class GameMemberListVO {
    private String uName;       //U_NAME
    private String uID;         //U_ID

    public GameMemberListVO() {
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }
}
