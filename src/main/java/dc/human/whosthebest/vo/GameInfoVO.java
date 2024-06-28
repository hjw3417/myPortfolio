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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	private String tID;					//T_ID(경기 생성자 팀 ID)
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

	//gcommet table
	private String comwritename;		//u_id(user table 과 조인)
	private String gCommentContent;		//g_comment

	public GameInfoVO() {
	}
}
