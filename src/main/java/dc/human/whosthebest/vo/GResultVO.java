/*
PROJECT        : whosthebest
PROGRAM ID    :  GResultDTO.java
PROGRAM NAME    : GResultDTO
DESCRIPTION    : 경기 종료 후 결과 입력 값을 담기 위한 DTO, GResult table과 연동
AUTHOR        : 허진욱
CREATED DATE    : 2024.05.29.
HISTORY
======================================================
DATE     		NAME       DESCRIPTION
2024.05.29   	허진욱        init
*/

package dc.human.whosthebest.vo;

public class GResultVO {
	
	
	private int gID;				//G_ID(경기 ID)
	private int tHomeID;			//T_HOMEID(경기 생성자 팀 ID)
	private int tAwayID;			//T_AWAYID(경기 상대방 팀 ID)
	private int homeGoal;			//HOME_GOAL(생성자 측 골 수)
	private int awayGoal;			//AWAY_GOAL(상대 측 골 수)
	private String uID;				//U_ID(경기 생성자 ID)
	private String createdID;		//UPDATED_ID(생성자 ID/DB에서 생성)
	private String createdDate;		//CREATED_DATE(생성 날짜/DB에서 생성)  
	private String updatedID;		//UPDATED_ID(업데이트 ID/DB에서 생성)	
	private String updatedDate;		//UPDATED_DATE(업데이트 날짜/DB에서 생성)
	
	
	public GResultVO(int gID, int tHomeID, int tAwayID, int homeGoal, int awayGoal, String uID, String createdDate,
					 String updatedID, String updatedDate) {
		this.gID = gID;
		this.tHomeID = tHomeID;
		this.tAwayID = tAwayID;
		this.homeGoal = homeGoal;
		this.awayGoal = awayGoal;
		this.uID = uID;
		this.createdDate = createdDate;
		this.updatedID = updatedID;
		this.updatedDate = updatedDate;
	}
	
	
	public GResultVO() {

	}


	public int getgID() {
		return gID;
	}


	public void setgID(int gID) {
		this.gID = gID;
	}


	public int gettHomeID() {
		return tHomeID;
	}


	public void settHomeID(int tHomeID) {
		this.tHomeID = tHomeID;
	}


	public int gettAwayID() {
		return tAwayID;
	}


	public void settAwayID(int tAwayID) {
		this.tAwayID = tAwayID;
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


	public String getuID() {
		return uID;
	}


	public void setuID(String uID) {
		this.uID = uID;
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
