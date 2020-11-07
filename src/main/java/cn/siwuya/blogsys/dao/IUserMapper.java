package cn.siwuya.blogsys.dao;

import cn.siwuya.blogsys.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author shi_dd
 * @date 2020/7/10 14:22
 */
@Mapper
public interface IUserMapper {
    @Select("select * from user_info where username = #{username} and password=#{password} ")
    UserEntity login(@Param("username") String username,@Param("password")  String password);
}
