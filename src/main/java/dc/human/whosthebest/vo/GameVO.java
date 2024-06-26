/*
PROJECT        : whosthebest
PROGRAM ID    :  GameDTO.java
PROGRAM NAME    : gameDTO
DESCRIPTION    : game talble colum 객체
AUTHOR        : 허진욱
CREATED DATE    : 2024.05.29.
HISTORY
======================================================
DATE     		NAME       DESCRIPTION
2024.05.29.   	허진욱        init
*/

package dc.human.whosthebest.vo;

	public class GameVO {
		
		private int gID;               //G_ID(경기 아이디/sequence)
		private int gTeamID;		   //G_TEAMID(경기 생성자 팀 ID)
		private String gTitle;		   //G_TITLE(경기 제목)	
		private String gTag;		   //G_TAG(경기 검색용 tag)	
		private String gCreatedDate;   //G_CREATEDATE(경기 생성 일시)
		private int gTime;             //G_TIME(경기 진행 시간)
		private String gInfo;          //G_INFO(경기 관련 설명)
		private int gMinMember;        //G_MINMEMBER(경기 시작 최소 인원)
		private String gResDate;       //G_RESDATE(경기장 예약 일자)
		private int gStatus;           //G_STATUS(경기 상태)
		private String tID;            //T_ID(경기 생성자 user ID)
		private int tAwayID;           //T_AWAYID(경기 상대 팀) 
		private int sID;               //S_ID(경기장 ID)
		private int sNum;              //S_NUM(경기장 내 번호)
		private String createdID;      //CREATED_ID(생성자 ID/DB에서 생성)
		private String createdDate;    //CREATED_DATE(생성 날짜/DB에서 생성)  
		private String updateID;       //UPDATED_ID(업데이트 ID/DB에서 생성)
		private String updatedDate;    //UPDATED_DATE(업데이트 날짜/DB에서 생성)



		public GameVO() {}



		public int getgID() {
			return gID;
		}



		public void setgID(int gID) {
			this.gID = gID;
		}



		public int getgTeamID() {
			return gTeamID;
		}



		public void setgTeamID(int gTeamID) {
			this.gTeamID = gTeamID;
		}



		public String getgTitle() {
			return gTitle;
		}



		public void setgTitle(String gTitle) {
			this.gTitle = gTitle;
		}



		public String getgTag() {
			return gTag;
		}



		public void setgTag(String gTag) {
			this.gTag = gTag;
		}



		public String getgCreatedDate() {
			return gCreatedDate;
		}



		public void setgCreatedDate(String gCreatedDate) {
			this.gCreatedDate = gCreatedDate;
		}



		public int getgTime() {
			return gTime;
		}



		public void setgTime(int gTime) {
			this.gTime = gTime;
		}



		public String getgInfo() {
			return gInfo;
		}



		public void setgInfo(String gInfo) {
			this.gInfo = gInfo;
		}



		public int getgMinMember() {
			return gMinMember;
		}



		public void setgMinMember(int gMinMember) {
			this.gMinMember = gMinMember;
		}



		public String getgResDate() {
			return gResDate;
		}



		public void setgResDate(String gResDate) {
			this.gResDate = gResDate;
		}



		public int getgStatus() {
			return gStatus;
		}



		public void setgStatus(int gStatus) {
			this.gStatus = gStatus;
		}



		public String gettID() {
			return tID;
		}



		public void settID(String tID) {
			this.tID = tID;
		}



		public int gettAwayID() {
			return tAwayID;
		}



		public void settAwayID(int tAwayID) {
			this.tAwayID = tAwayID;
		}



		public int getsID() {
			return sID;
		}



		public void setsID(int sID) {
			this.sID = sID;
		}



		public int getsNum() {
			return sNum;
		}



		public void setsNum(int sNum) {
			this.sNum = sNum;
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



		public String getUpdateID() {
			return updateID;
		}



		public void setUpdateID(String updateID) {
			this.updateID = updateID;
		}



		public String getUpdatedDate() {
			return updatedDate;
		}



		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}

	}
