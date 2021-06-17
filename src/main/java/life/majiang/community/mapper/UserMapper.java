package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author WangBei
 * @Date 2021/6/17 17:21
 * @Description:
 */

@Mapper
public interface UserMapper {
    @Insert("insert into user(NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
