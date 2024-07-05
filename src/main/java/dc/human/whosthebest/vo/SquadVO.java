package dc.human.whosthebest.vo;

import lombok.Getter;
import lombok.Setter;

public class SquadVO {

	private int gID;                    //G_ID(게임 아이디)
	private int tID;                    //T_ID(게임 참여자 team 아이디)
	private String uID;                 //U_ID(게임 참여자 아이디)
	private String createdID;			//CREATED_ID
	private String updatedID;			//UPDATED_ID

	public SquadVO() {

	}

	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}

	public int gettID() {
		return tID;
	}

	public void settID(int tID) {
		this.tID = tID;
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

	public String getUpdatedID() {
		return updatedID;
	}

	public void setUpdatedID(String updatedID) {
		this.updatedID = updatedID;
	}
}
