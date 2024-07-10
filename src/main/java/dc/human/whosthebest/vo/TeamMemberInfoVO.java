package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

@Component
public class TeamMemberInfoVO {
	private int tID;
	private String uID;
	private int uStatus;
	private String uBday;
	private String uPhone;
	private int leader;
	private String createdID;
	private String createdDate;
	private String updatedID;
	private String updatedDate;


	public String getuBday() {
		return uBday;
	}

	public void setuBday(String uBday) {
		this.uBday = uBday;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
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
	public int getuStatus() {
		return uStatus;
	}
	public void setuStatus(int uStatus) {
		this.uStatus = uStatus;
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

	//leader 추가
	public int getLeader() {
		return leader;
	}

	public void setLeader(int leader) {
		this.leader = leader;
	}
	
	
}
