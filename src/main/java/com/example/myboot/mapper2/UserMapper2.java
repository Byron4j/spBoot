package com.example.myboot.mapper2;

import com.example.myboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * created by BYRON.Y.Y at 2018/10/8 19:49
 */
public interface UserMapper2 {
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "regTime", column = "reg_time"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(userName,passWord) VALUES(#{userName}, #{passWord})")
    void insert(User user);

    @Update("UPDATE user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);




    /*
    非注解方式的SQL
     */

    List<User> selectByCnd(User record);

}
