package dc.human.whosthebest.vo;

/*gameList.xml  처리 위한 VO라  DB에 생성 안합니다!!!!*/

import dc.human.whosthebest.paging.Criteria;
import org.springframework.stereotype.Component;

@Component("gameStadiumVO")
public class GameStadiumVO extends Criteria {
    private int gameId;
    private String gameTitle;
    private String gameResDate;
    private String stadiumName;
    private String gameStatus;

    // 생성자
    public GameStadiumVO (int gameId, String gameTitle, String gameResDate, String stadiumName ,String gameStatus) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.gameResDate = gameResDate;
        this.stadiumName = stadiumName;
        this.gameStatus = gameStatus;
    }

    public GameStadiumVO() {
        System.out.println("게임스타디움VO 성공");
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameResDate() {
        return gameResDate;
    }

    public void setGameResDate(String gameResDate) {
        this.gameResDate = gameResDate;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
}
