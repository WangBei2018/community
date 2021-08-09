package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author WangBei
 * @Date 2021/8/9 21:37
 * @Description:
 */
@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String profile() {

        return "profile";
    }
}
