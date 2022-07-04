package com.tedu.mallserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.mallserver.pojo.UserDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper //mybatis-plus框架会为接口创建实现类，再创建对象，对象放在spring容器中
public interface UserMapper extends BaseMapper<UserDAO> {
}
