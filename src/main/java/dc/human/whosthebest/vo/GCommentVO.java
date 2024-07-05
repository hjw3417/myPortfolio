package dc.human.whosthebest.vo;

public class GCommentVO {
    //G_COMMENT TABLE
    private String uID;     //U_ID
    private int gID;        //G_ID
    private String gComment; //g_comment
    private String comCreatedID; //COM_CREATED_ID
    //USERS TALBLE
    private String uName;   //u_name

    public GCommentVO() {
    }

    public String getComCreatedID() {
        return comCreatedID;
    }

    public void setComCreatedID(String comCreatedID) {
        this.comCreatedID = comCreatedID;
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

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public String getgComment() {
        return gComment;
    }

    public void setgComment(String gComment) {
        this.gComment = gComment;
    }
}
