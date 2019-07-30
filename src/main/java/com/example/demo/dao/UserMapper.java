package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    // 1. 实现查询所有用户
    @Select("select * from user")
    List<User> findAllPage();

    // 2. 根据用户id查询用户
    @Select("select * from user where id = #{id}")
    User findByID(Integer id);

    // 3. 添加新用户
    //返回的Integer值是变化的行数，@Options()会填充到实体 person 中。
    @Insert("insert into user(id, name) values(#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer addUser(User user);

    // 4. 根据用户id删除用户
    @Delete("delete from user where id = #{id}")
    Integer deleteUser(Integer id);

    // 5. 根据用户id更新用户
    @Update("update user set id = #{id}, name = #{name} where id = #{id}")
    Integer updateUser(User user);
}
