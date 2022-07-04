package com.tedu.mallserver.controller;

import com.tedu.mallserver.pojo.CategoryDAO;
import com.tedu.mallserver.pojo.ServerResult;
import com.tedu.mallserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//控制层
@RestController //springmvc框架会为类创建对象，对象放到spring容器中
public class CategoryController {
    //从spring容器中取业务层的对象
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/test")
    public ServerResult test(Integer number){
        int result = 10/number;
        ServerResult serverResult = new ServerResult(0, "成功", result);
        return serverResult;
    }

    //1、接收浏览器发来的请求
    @RequestMapping("/category/selectAll")
    //重启服务器
    //浏览器中输入http://localhost:9002/category/selectAll
    public ServerResult selectAll(){
        //2、调用业务层
        List<CategoryDAO> list = categoryService.selectAll();
        ServerResult serverResult = new ServerResult(0,"成功",list);
        //3、返回结果给浏览器
        return serverResult;
    }
}
