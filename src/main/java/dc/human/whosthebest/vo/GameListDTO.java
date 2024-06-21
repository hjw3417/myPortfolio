/*
PROJECT        : whosthebest
PROGRAM ID    :  GameListDTO.java
PROGRAM NAME    : gameListDTO
DESCRIPTION    : game, team, stadium talble colum을 조합하여 gameList.jsp에 전달하기 위한 객체
AUTHOR        : 허진욱
CREATED DATE    : 2024.05.29.
HISTORY
======================================================
DATE     		NAME       DESCRIPTION
2024.05.29.   	허진욱        init
*/


package dc.human.whosthebest.vo;

public class GameListDTO {
	//game table
	private int gID;					//G_ID(경기 아이디/sequence)
	private int gTeamID;				//G_TEAMID(팀 ID)
	private String gTitle;				//G_TITLE(경기 제목)
	private String gTag;				//G_TAG(경기 검색용 tag)
	private String gCreatedDate;		//G_CREATEDATE(경기 생성 일시)
	private int gTime;					//G_TIME(경기 진행 시간)
	private String gInfo;				//G_INFO(경기 관련 설명)
	private int gMinMember;				//G_MINMEMBER(경기 시작 최소 인원)
	private String gResTime;			//G_RESTIME(경기장 예약 시간)
	private String gResDate;			//G_RESDATE(경기장 예약 일자)
	private int gStatus;				//G_STATUS(경기 상태)
	private int tID;					//T_ID(경기 생성자 팀 ID)
	private int tAwayID;				//T_AWAYID(경기 상대 팀)
	private int sID;					//S_ID(경기장 ID)
	private int sNum;					//S_NUM(경기장 내 번호)
	private String uID;					//U_ID(경기 생성자 ID)
	
	//team table
	private String tName;				//T_NAME(팀 이름)
	private byte[] tLogo;				//T_LOGO(팀 로고/image 파일)
	private String tregion;				//T_REGION(팀 지역)
	private String tphone;				//T_PHONE(팀 연락처)
	private int tRankScore;				//RANKSCORE(팀 랭킹 점수)				
	private int tMinAge;				//T_MINAGE(팀 참여 최소 나이)
	private int tMaxAge;				//T_MAXAGE(팀 참여 최대 나이)
	private int tMaxMember;				//T_MAXMEMBER(팀 최대 인원)
	private int tMember;				//T_MEMBER(팀 멤버 ID)
	private String tInfo;				//T_INFO(팀 정보)
	
	//stadium table
	private String sName;				//S_NAME
	private String sRegion;				//S_REGION
	private String sAddr;				//S_ADDR
	private String sOwner;				//S_OWNER
	private String sPhone;				//S_PHONE
	
	
	
	
	public GameListDTO(int gID, int gTeamID, String gTitle, String gTag, String gCreatedDate, int gTime, String gInfo,
			int gMinMember, String gResTime, String gResDate, int gStatus, int tID, int tAwayID, int sID, int sNum,
			String uID, String tName, byte[] tLogo, String tregion, String tphone, int tRankScore, int tMinAge,
			int tMaxAge, int tMaxMember, int tMember, String tInfo, String sName, String sRegion, String sAddr,
			String sOwner, String sPhone) {
		this.gID = gID;
		this.gTeamID = gTeamID;
		this.gTitle = gTitle;
		this.gTag = gTag;
		this.gCreatedDate = gCreatedDate;
		this.gTime = gTime;
		this.gInfo = gInfo;
		this.gMinMember = gMinMember;
		this.gResTime = gResTime;
		this.gResDate = gResDate;
		this.gStatus = gStatus;
		this.tID = tID;
		this.tAwayID = tAwayID;
		this.sID = sID;
		this.sNum = sNum;
		this.uID = uID;
		this.tName = tName;
		this.tLogo = tLogo;
		this.tregion = tregion;
		this.tphone = tphone;
		this.tRankScore = tRankScore;
		this.tMinAge = tMinAge;
		this.tMaxAge = tMaxAge;
		this.tMaxMember = tMaxMember;
		this.tMember = tMember;
		this.tInfo = tInfo;
		this.sName = sName;
		this.sRegion = sRegion;
		this.sAddr = sAddr;
		this.sOwner = sOwner;
		this.sPhone = sPhone;
	}


	public String getuID() {
		return uID;
	}


	public void setuID(String uID) {
		this.uID = uID;
	}


	public GameListDTO() {}


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


	public String getgResTime() {
		return gResTime;
	}


	public void setgResTime(String gResTime) {
		this.gResTime = gResTime;
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


	public int gettID() {
		return tID;
	}


	public void settID(int tID) {
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


	public String gettName() {
		return tName;
	}


	public void settName(String tName) {
		this.tName = tName;
	}


	public byte[] gettLogo() {
		return tLogo;
	}


	public void settLogo(byte[] tLogo) {
		this.tLogo = tLogo;
	}


	public String getTregion() {
		return tregion;
	}


	public void setTregion(String tregion) {
		this.tregion = tregion;
	}


	public String getTphone() {
		return tphone;
	}


	public void setTphone(String tphone) {
		this.tphone = tphone;
	}


	public int gettRankScore() {
		return tRankScore;
	}


	public void settRankScore(int tRankScore) {
		this.tRankScore = tRankScore;
	}


	public int gettMinAge() {
		return tMinAge;
	}


	public void settMinAge(int tMinAge) {
		this.tMinAge = tMinAge;
	}


	public int gettMaxAge() {
		return tMaxAge;
	}


	public void settMaxAge(int tMaxAge) {
		this.tMaxAge = tMaxAge;
	}


	public int gettMaxMember() {
		return tMaxMember;
	}


	public void settMaxMember(int tMaxMember) {
		this.tMaxMember = tMaxMember;
	}


	public int gettMember() {
		return tMember;
	}


	public void settMember(int tMember) {
		this.tMember = tMember;
	}


	public String gettInfo() {
		return tInfo;
	}


	public void settInfo(String tInfo) {
		this.tInfo = tInfo;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getsRegion() {
		return sRegion;
	}


	public void setsRegion(String sRegion) {
		this.sRegion = sRegion;
	}


	public String getsAddr() {
		return sAddr;
	}


	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}


	public String getsOwner() {
		return sOwner;
	}


	public void setsOwner(String sOwner) {
		this.sOwner = sOwner;
	}


	public String getsPhone() {
		return sPhone;
	}


	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	
	
	
	
	
	
	
	
}
