package life.majiang.community.Provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.DTO.AccessTokenDTO;
import life.majiang.community.DTO.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author WangBei
 * @Date 2021/6/7 16:02
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO)); // 将java类对象转换为String的JSON对象发送请求
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();


        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();      // 拿到当前String对象，是JSON格式
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class); // 将String的JSON格式对象转换成Java的类对象，不用自己手动解析String
            return githubUser;

        } catch (IOException e) {
        }
        return null;
    }
}
