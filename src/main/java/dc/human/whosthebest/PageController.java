package dc.human.whosthebest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/teamMake")
    public String teamMakePage() {
        return "teamMake";
    }
}
