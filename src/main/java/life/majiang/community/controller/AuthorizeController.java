package life.majiang.community.controller;

import life.majiang.community.DTO.AccessTokenDTO;
import life.majiang.community.DTO.GithubUser;
import life.majiang.community.Provider.GithubProvider;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author WangBei
 * @Date 2021/6/7 15:55
 */

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")   // 在配置文件application.properties里面找到相应的值
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper UserMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);

        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {                       // github登录成功
            User user = new User();

            String token = UUID.randomUUID().toString();
            user.setToken(token);                    // 获取用户信息，生成token,将token放入用户对象里面，存入数据库，并且将token放入数据库中
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));          // github用户中的id是Long类型，User中的accountId是String类型，需要类型转换
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());

            UserMapper.insert(user);
            response.addCookie(new Cookie("token", token));


            return "redirect:/";
            // 登陆成功，写cookie和session
        } else {
            // 登录失败，重新登录
            return "redirect:/";
        }
    }

}
