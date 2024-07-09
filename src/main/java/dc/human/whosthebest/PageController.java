package dc.human.whosthebest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String index() {
        return "user/login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "user/join";
    }

    @GetMapping("/findId")
    public String findId() {
        return "user/findID";
    }

    @GetMapping("/findPw")
    public String findPw(){
        return "user/findPW";
    }

    @GetMapping("/boardWrite")
    public String boardWrite(){
        return "main/boardWrite";
    }

}
