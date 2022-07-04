package com.tedu.mallserver.controller;

import com.tedu.mallserver.pojo.*;
import com.tedu.mallserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //框架会自动为类创建对象
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/item/update")
    public ServerResult update(ItemUpdateDTO itemUpdateDTO){
        boolean isSuccess = itemService.update(itemUpdateDTO);
        if(isSuccess){
            return new ServerResult(0,"修改成功",null);
        }else{
            return new ServerResult(306,"修改失败",null);
        }
    }

    @RequestMapping("/item/delete")
    public ServerResult delete(Integer id){
        boolean isSuccess = itemService.delete(id);
        if(isSuccess){
            return new ServerResult(0,"删除成功",null);
        }else{
            return new ServerResult(305,"删除失败",null);
        }
    }

    @RequestMapping("/item/selectAll")
    public ServerResult selectAll(){
        List<ItemVO> voList = itemService.selectAll();
        return new ServerResult(0,"查询成功",voList);
    }

    @RequestMapping("/item/insert")
    public ServerResult insert(ItemInsertDTO dto){
        boolean isSuccess = itemService.insert(dto);
        if(isSuccess){
            return new ServerResult(0,"添加成功",null);
        }else{
            return new ServerResult(304,"添加失败",null);
        }
    }

    @RequestMapping("/item/selectById")
    //http://localhost:9002/doc.html
    public ServerResult selectById(Integer id){
        ItemDAO itemDAO = itemService.selectById(id);
        ServerResult serverResult = new ServerResult(0, "成功", itemDAO);
        return serverResult;
    }

    @RequestMapping("/item/selectByCategoryId")
    public ServerResult selectByCategoryId(Integer categoryId){
        List<ItemDAO> list = itemService.selectByCategoryId(categoryId);
        ServerResult serverResult = new ServerResult(0, "成功", list);
        return serverResult;
    }
}
