package com.tml.mouseDemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ESMapper {


    String queryOrderById(@Param("name") String name);
}
