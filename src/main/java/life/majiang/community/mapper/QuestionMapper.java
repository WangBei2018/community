package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author WangBei
 * @Date 2021/6/28 16:02
 * @Description:
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_creat,gmt_modified,creator) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator})")
    void create(Question question);
}
