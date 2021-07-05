package life.majiang.community.DTO;

import lombok.Data;

/**
 * @Author WangBei
 * @Date 2021/6/7 16:59
 */
@Data
public class GithubUser {
    private String name;
    private Long Id;
    private String bio;
    private String avatar_url;
}
