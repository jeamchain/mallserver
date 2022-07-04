package com.tedu.mallserver.service;
//商品分类的业务层

import com.tedu.mallserver.pojo.CategoryDAO;

import java.util.List;

public interface CategoryService {
    public List<CategoryDAO> selectAll();
}
