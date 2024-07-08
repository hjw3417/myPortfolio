/*
PROJECT        : whosthebest
PROGRAM ID    :  GameListVO.java
PROGRAM NAME    : gameList value object
DESCRIPTION    : game, team, stadium talble column을 조합하여
				 gameList.jsp에 전달하기 위한 값을 담은 객체
AUTHOR        : 허진욱
CREATED DATE    : 2024.06.21.
HISTORY
======================================================
*/


package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

@Component
public class GameListVO {
	//game table
	private int gID;					//G_ID(경기 아이디/sequence)
	private int gTeamID;				//G_TEAMID(경기 생성자 팀 ID)
	private String gTitle;				//G_TITLE(경기 제목)
	private String gTag;				//G_TAG(경기 검색용 tag)
	private String gCreatedDate;		//G_CREATEDATE(경기 생성 일시)
	private int gTime;					//G_TIME(경기 진행 시간)
	private int gMinMember;				//G_MINMEMBER(경기 시작 최소 인원)
	private String gResDate;			//G_RESDATE(경기장 예약 일자)
	private int gStatus;				//G_STATUS(경기 상태)
	private String tUserID;				//T_USERID(경기 생성자 user ID)
	private int sID;					//S_ID(경기장 ID)
	private int sNum;					//S_NUM(경기장 내 번호)

	//team table
	private String tName;				//T_NAME(팀 이름)
	private String tLogo;				//T_LOGO(팀 로고 파일 주소)
	//stadium table
	private String sName;				//S_NAME(경기장 명)
	private String sRegion;				//S_REGION(경기장 지역/광역자치단체 명 기준)
	private String sAddr;				//S_ADDR(경기장 주소)

	public GameListVO() {
	}

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

	public String gettUserID() {
		return tUserID;
	}

	public void settUserID(String tUserID) {
		this.tUserID = tUserID;
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

	public String gettLogo() {
		return tLogo;
	}

	public void settLogo(String tLogo) {
		this.tLogo = tLogo;
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
}
