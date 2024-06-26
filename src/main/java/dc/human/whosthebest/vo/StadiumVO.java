/*
PROJECT        : whosthebest
PROGRAM ID    :  StadiumDTO.java
PROGRAM NAME    : StadiumDTO
DESCRIPTION    : stadium table의 정보를 담기 위한 DTO/조회만을 위한 table로 생성자/업데이트자 정보 없음
AUTHOR        : 허진욱
CREATED DATE    : 2024.05.29.
HISTORY
======================================================
DATE     		NAME       DESCRIPTION
2024.05.29   	허진욱        init
*/

package dc.human.whosthebest.vo;

import org.springframework.stereotype.Component;

@Component("stadiumVO")
public class StadiumVO {
	private int sID;			//S_ID(경기장 ID)
	private String sName;		//S_NAME(경기장 명)
	private String sRegion;		//S_REGION(경기장 지역/광역자치단체 명 기준)
	private String sAddr;		//S_ADDR(경기장 주소)
	private String sOwner;		//S_OWNER(경기장 소유 기관명)
	private String sPhone;		//S_PHONE(경기장 관리자 번호)
	private int sNum;			//S_NUM(경기장 내 번호)

	public StadiumVO(int sID, String sName, String sRegion, String sAddr, String sOwner, String sPhone, int sNum) {
		this.sID = sID;
		this.sName = sName;
		this.sRegion = sRegion;
		this.sAddr = sAddr;
		this.sOwner = sOwner;
		this.sPhone = sPhone;
		this.sNum = sNum;
	}

	public StadiumVO() {

	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
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

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}


}
