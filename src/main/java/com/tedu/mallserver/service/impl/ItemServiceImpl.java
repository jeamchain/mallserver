package com.tedu.mallserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.mallserver.mapper.CategoryMapper;
import com.tedu.mallserver.mapper.ItemMapper;
import com.tedu.mallserver.pojo.*;
import com.tedu.mallserver.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public boolean update(ItemUpdateDTO itemUpdateDTO) {
        //update item set name = '' where id = 1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",itemUpdateDTO.getId());

        //新的数据放在DAO中
        ItemDAO itemDAO = new ItemDAO();
        BeanUtils.copyProperties(itemUpdateDTO,itemDAO);

        int updateRow = itemMapper.update(itemDAO,queryWrapper);
        return updateRow>=1?true:false;
    }

    @Override
    public boolean delete(Integer id) {
        //delete from item where id = 1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);

        int deleteRow = itemMapper.delete(queryWrapper);
        return deleteRow>=1?true:false;
    }

    @Override
    public List<ItemVO> selectAll() {
        //select * from item
        //1、查出表中所有商品
        List<ItemDAO> daoList = itemMapper.selectList(null);

        ArrayList<ItemVO> voList = new ArrayList<>();
        //2、遍历list<ItemDAO>
        for(ItemDAO itemDAO:daoList) {
            //根据商品的分类编号查询分类名称
            //select * from category where id=1
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id",itemDAO.getCategoryId());
            CategoryDAO categoryDAO = categoryMapper.selectOne(queryWrapper);

            //2.1、创建ItemVO
            ItemVO itemVO = new ItemVO();
            itemVO.setCategoryName(categoryDAO.getName());
            //2.2、把DAO中的值拷贝到itemVO中
            BeanUtils.copyProperties(itemDAO,itemVO);
            //2.3、把itemVO放到集合中
            voList.add(itemVO);
        }
        //3、返回一个itemVO集合（VOList）
        return voList;
    }

    @Override
    public boolean insert(ItemInsertDTO itemInsertDTO) {
        ItemDAO itemDAO = new ItemDAO();
        //把itemInsertDTO的属性的值拷贝到itemDTO中，要求itemDAO的属性名和itemInsertDTO的属性名必须一样
        BeanUtils.copyProperties(itemInsertDTO,itemDAO);
        int insertRow = itemMapper.insert(itemDAO);

        return insertRow>=1?true:false;
    }

    @Override
    public List<ItemDAO> selectByCategoryId(Integer categoryId) {
        //select * from item where category_id=1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id",categoryId);
        List list = itemMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public ItemDAO selectById(Integer id) {
        //... where id = 1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);

        ItemDAO itemDAO = itemMapper.selectOne(queryWrapper);
        return itemDAO;
    }
}
