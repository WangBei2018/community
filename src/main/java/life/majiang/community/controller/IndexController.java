package life.majiang.community.controller;

/**
 * @Author WangBei
 * @Date 2021/6/7 15:58
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/hello")           // 输入时，访问下面的hello函数
    public String hello(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "index";             // 通过resources/index.html访问页面
    }
    @GetMapping("/")
    public String index(){return "index";}

}
