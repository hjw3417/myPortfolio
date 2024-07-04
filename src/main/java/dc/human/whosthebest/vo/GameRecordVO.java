package dc.human.whosthebest.vo;

import java.util.List;

public class GameRecordVO {

    private int totalCount;
    private int winCount;
    private int loseCount;
    private int drawCount;
    private List<GameRecordInfoListVO> gameRecordInfoListVO;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    public List<GameRecordInfoListVO> getGameRecordInfoListVO() {
        return gameRecordInfoListVO;
    }

    public void setGameRecordInfoListVO(List<GameRecordInfoListVO> gameRecordInfoListVO) {
        this.gameRecordInfoListVO = gameRecordInfoListVO;
    }

    public GameRecordVO() {}
}
