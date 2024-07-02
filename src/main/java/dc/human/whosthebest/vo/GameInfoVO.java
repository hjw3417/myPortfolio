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

import java.util.List;


public class GameInfoVO {
	//game table
	private int gID;					//G_ID(경기 아이디/sequence)
	private int gTeamID;				//G_TEAMID(팀 ID)
	private String gTitle;				//G_TITLE(경기 제목)
	private String gTag;				//G_TAG(경기 검색용 tag)
	private String gCreatedDate;		//G_CREATEDATE(경기 생성 일시)
	private int gTime;					//G_TIME(경기 진행 시간)
	private String gInfo;				//G_INFO(경기 관련 설명)
	private int gMinMember;				//G_MINMEMBER(경기 시작 최소 인원)
	private String gResDate;			//G_RESDATE(경기장 예약 일자)
	private int gStatus;				//G_STATUS(경기 상태)
	private String tUserID;				//T_USERID(경기 생성자 팀 ID)
	private int tAwayID;				//T_AWAYID(경기 상대 팀)
	private int sID;					//S_ID(경기장 ID)
	private int sNum;					//S_NUM(경기장 내 번호)

	//team table
	private String tName;				//T_NAME(팀 이름)
	private byte[] tLogo;				//T_LOGO(팀 로고/image 파일)

	//stadium table
	private String sName;				//S_NAME
	private String sRegion;				//S_REGION
	private String sAddr;				//S_ADDR
	private String sOwner;				//S_OWNER
	private String sPhone;				//S_PHONE

	//squad table
	private int gamePatiMemNum;			//alias gpm, select count(*) from squad groub by  g_id, u_id;

	//user table
	private String uID;					//u_id
	private String uName;				//U_ID

	//gcommet table
	private String comwritename;		//u_id(user table 과 조인)
	private String gCommentContent;		//g_comment

	//List<GameMemberListVO>
	private List<GameMemberListVO> gameMemberList;

	//List<GComments>
	private List<GCommentVO> gCommentsList;

	//List<teamVO>
	List<TeamInfoVO> myTeamList;

	//nowPartiMemberNum
	private int nowPartiMemberNum;

	private GameAwayTeamInfoVO gameAwayTeamInfoVO;

	public GameAwayTeamInfoVO getGameAwayTeamInfoVO() {
		return gameAwayTeamInfoVO;
	}

	public void setGameAwayTeamInfoVO(GameAwayTeamInfoVO gameAwayTeamInfoVO) {
		this.gameAwayTeamInfoVO = gameAwayTeamInfoVO;
	}

	public int getNowPartiMemberNum() {
		return nowPartiMemberNum;
	}

	public void setNowPartiMemberNum(int nowPartiMemberNum) {
		this.nowPartiMemberNum = nowPartiMemberNum;
	}

	public List<TeamInfoVO> getMyTeamList() {
		return myTeamList;
	}

	public void setMyTeamList(List<TeamInfoVO> myTeamList) {
		this.myTeamList = myTeamList;
	}

	public List<GCommentVO> getgCommentsList() {
		return gCommentsList;
	}

	public void setgCommentsList(List<GCommentVO> gCommentsList) {
		this.gCommentsList = gCommentsList;
	}

	public List<GameMemberListVO> getGameMemberList() {
		return gameMemberList;
	}

	public void setGameMemberList(List<GameMemberListVO> gameMemberList) {
		this.gameMemberList = gameMemberList;
	}

	public GameInfoVO() {
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
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

	public String gettUserID() {
		return tUserID;
	}

	public void settUserID(String tUserID) {
		this.tUserID = tUserID;
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

	public int getGamePatiMemNum() {
		return gamePatiMemNum;
	}

	public void setGamePatiMemNum(int gamePatiMemNum) {
		this.gamePatiMemNum = gamePatiMemNum;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getComwritename() {
		return comwritename;
	}

	public void setComwritename(String comwritename) {
		this.comwritename = comwritename;
	}

	public String getgCommentContent() {
		return gCommentContent;
	}

	public void setgCommentContent(String gCommentContent) {
		this.gCommentContent = gCommentContent;
	}
}
