package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

@Component("teamDetailVO")
public class TeamDetailVO {

    private int tID;
    private String tName;
    private String gResDate;
    private String myTeam;
    private String awayTeam;


    private int gID;				//G_ID(경기 ID)
    private int tHomeID;			//T_HOMEID(경기 생성자 팀 ID)
    private int tAwayID;			//T_AWAYID(경기 상대방 팀 ID)
    private int homeGoal;			//HOME_GOAL(생성자 측 골 수)
    private int awayGoal;			//AWAY_GOAL(상대 측 골 수)
    private String uID;				//U_ID(경기 생성자 ID)
    private int sID;			//S_ID(경기장 ID)
    private String sName;


    private byte[] tLogo;
    private String tRegion;
    private String tPhone;
    private int tRankScore;
    private int tMinAge;
    private int tMaxAge;
    private int tMaxMember;
    private int tMember;
    private String tInfo;
    private String createdID;
    private String createdDate;

}
