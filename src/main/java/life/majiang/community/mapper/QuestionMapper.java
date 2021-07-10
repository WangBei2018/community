package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/6/28 16:02
 * @Description:
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator})")
    void create(Question question);

    @Select("select * from question")
    List<Question> list();
}
