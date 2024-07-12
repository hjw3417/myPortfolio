package dc.human.whosthebest.vo;

/*xml  처리 위한 VO라  DB에 생성 안합니다!!!!*/

import org.springframework.stereotype.Component;

@Component("gameStadiumVO")
public class GameStadiumVO {
    private int gameId;
    private String gameTitle;
    private String gameResDate;
    private String stadiumName;
    private int gameStatus;

    // 생성자
    public GameStadiumVO (int gameId, String gameTitle, String gameResDate, String stadiumName ,int gameStatus) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.gameResDate = gameResDate;
        this.stadiumName = stadiumName;
        this.gameStatus = gameStatus;
    }

    public GameStadiumVO() {

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

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }
}
