package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @Author WangBei
 * @Date 2021/6/17 17:21
 * @Description:
 */

@Mapper
public interface UserMapper {
    @Insert("insert into user(NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from USER where token = #{token}")        // #{}:在myBatis编译时将下面的形参放入sql语句，如果形参是类的类型，会直接放入，如果不是，需要加入注解@Param("")
    User findByToken(@Param("token") String token);
}
