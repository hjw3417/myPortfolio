package dc.human.whosthebest.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SquadVO {

	private int gID;                    //G_ID(게임 아이디)
	private int tID;                    //T_ID(게임 참여자 team 아이디)
	private String uID;                 //U_ID(게임 참여자 아이디)
	private String createdID;			//CREATED_ID
	private String createdDate;			//CREATED_DATE
	private String updatedID;			//UPDATED_ID
	private String updatedDate;			//UPDATED_DATE

	
	public SquadVO() {

	}

}
