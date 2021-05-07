package com.tml.mouseDemo.data.data2.mapper;

import com.tml.mouseDemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> listByName(@Param("userName") String userName);

    int updatePwd(@Param("pwd") String pwd, @Param("uid") Long uid);
}
