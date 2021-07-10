package life.majiang.community.controller;

/**
 * @Author WangBei
 * @Date 2021/6/7 15:58
 */

import life.majiang.community.DTO.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

// 检查登录状态
@Controller
public class IndexController {
//    @GetMapping("/hello")           // 输入时，访问下面的hello函数
//    public String hello(@RequestParam(name = "name") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";              // 通过resources/index.html访问页面
//    }


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")                // 访问首页
    // 循环查看所有cookie，找到coolie等于token的cookie，然后在数据库里面查询是否有这个cookie对应的用户，如果有，那么显示姓名;如果没有则显示登录
    // 实现持续换登录状态,获取user
    public String index(HttpServletRequest request,
                        Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                }
            }
        }
        List<QuestionDTO> questionList = questionService.list();    // 调用questionService中的list()方法，使用QuestionDTO类组装Question和User类
        model.addAttribute("question",questionList);
        return "index";
    }

}
