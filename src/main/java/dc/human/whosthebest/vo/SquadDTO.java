package dc.human.whosthebest.vo;

public class SquadDTO {

	private int gID;
	private String tID;
	private String uID;
	private String createdID;
	private String createdDate;
	private String updatedID;
	private String updatedDate;
	
	
	public SquadDTO(int gID, String tID, String uID, String createdID, String createdDate, String updatedID,
			String updatedDate) {
		this.gID = gID;
		this.tID = tID;
		this.uID = uID;
		this.createdID = createdID;
		this.createdDate = createdDate;
		this.updatedID = updatedID;
		this.updatedDate = updatedDate;
	}
	
	public SquadDTO() {

	}

	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}

	public String gettID() {
		return tID;
	}

	public void settID(String tID) {
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
	
	
	
	
	
}
