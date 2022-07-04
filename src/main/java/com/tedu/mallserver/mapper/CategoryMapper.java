package com.tedu.mallserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.mallserver.pojo.CategoryDAO;
import org.apache.ibatis.annotations.Mapper;

//数据访问层
//操作category表
@Mapper //框架自动为接口生成实现类，再创建对象，对象放在spring容器中
public interface CategoryMapper extends BaseMapper<CategoryDAO> {
}
