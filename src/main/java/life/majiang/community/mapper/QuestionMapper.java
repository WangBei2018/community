package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    @Select("select * from question limit #{offset}, #{size}")
    // #{}:在myBatis编译时将下面的形参放入sql语句，如果形参是类的类型，会直接放入，如果不是，需要加入注解@Param("")
    // limit:第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目。
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();
}
