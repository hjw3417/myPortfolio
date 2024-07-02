package dc.human.whosthebest.main.service;

import java.util.List;

public interface MainService {
    public List<String> mainRanking(String tName) throws Exception;
    public List<String> mainGameList(String gTitle) throws Exception;
}
