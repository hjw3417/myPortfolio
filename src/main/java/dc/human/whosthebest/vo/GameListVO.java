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

public class GameListVO {
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
	

	
}
