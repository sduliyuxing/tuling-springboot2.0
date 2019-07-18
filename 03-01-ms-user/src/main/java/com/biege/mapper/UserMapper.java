package com.biege.mapper;

import com.biege.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户
     */
    @Select("SELECT * FROM t_user WHERE ID = #{id}")
    User findById(@Param("id") Integer id);

    /**
     * 新增用户
     */
    @Insert("INSERT INTO t_user(NAME, AGE, ADDRESS, PHONE) VALUES(#{name}, #{age}, #{address}, #{phone})")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("address") String address, @Param("phone") String phone);

}
