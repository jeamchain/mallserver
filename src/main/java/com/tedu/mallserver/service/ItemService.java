package com.tedu.mallserver.service;

import com.tedu.mallserver.pojo.ItemDAO;
import com.tedu.mallserver.pojo.ItemInsertDTO;
import com.tedu.mallserver.pojo.ItemUpdateDTO;
import com.tedu.mallserver.pojo.ItemVO;

import java.util.List;

public interface ItemService {

    public boolean update(ItemUpdateDTO itemUpdateDTO);

    public boolean delete(Integer id);

    public List<ItemVO> selectAll();
    /**
     * 添加商品
     * @param itemInsertDTO
     * @return true 添加成功
     */
    public boolean insert(ItemInsertDTO itemInsertDTO);
    List<ItemDAO> selectByCategoryId(Integer categoryId);
    ItemDAO selectById(Integer id);
}
