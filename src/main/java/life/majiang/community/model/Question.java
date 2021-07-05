package life.majiang.community.model;

import lombok.Data;

/**
 * @Author WangBei
 * @Date 2021/6/28 16:11
 * @Description:
 */
@Data
public class Question {
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
}
