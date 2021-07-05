package life.majiang.community.DTO;

import lombok.Data;

/**
 * @Author WangBei
 * @Date 2021/6/7 16:04
 * Descirption:  数据传输对象（DTO)(Data Transfer Object)
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
