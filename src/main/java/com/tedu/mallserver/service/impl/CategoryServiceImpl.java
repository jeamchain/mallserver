package com.tedu.mallserver.service.impl;

import com.tedu.mallserver.mapper.CategoryMapper;
import com.tedu.mallserver.pojo.CategoryDAO;
import com.tedu.mallserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层实现类
@Service    //框架为类创建对象，对象放在spring容器中
public class CategoryServiceImpl implements CategoryService {
    //从spring容器中取数据访问层对象
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryDAO> selectAll() {
        //参数null没有查询条件
        List<CategoryDAO> list = categoryMapper.selectList(null);
        return list;
    }
}
