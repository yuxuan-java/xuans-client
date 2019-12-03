package club.yuxuan.yun.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @RequestMapping("/")
    public String aaa() {
        return "succcess";
    }
    
}
