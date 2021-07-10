package life.majiang.community.DTO;

import life.majiang.community.model.User;
import lombok.Data;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;

/**
 * @Author WangBei
 * @Date 2021/7/8 17:34
 * @Description:
 */
@Data
// 包含了Question类中的变量以及user对象
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCountl;
    private Integer likeCount;
    private User user;
}
