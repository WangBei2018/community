package life.majiang.community.model;

import lombok.Data;

/**
 * @Author WangBei
 * @Date 2021/6/17 17:30
 * @Description:
 */
@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarURL;
}
