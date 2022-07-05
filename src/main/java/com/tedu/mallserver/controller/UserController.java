package com.tedu.mallserver.controller;

import com.tedu.mallserver.pojo.ServerResult;
import com.tedu.mallserver.pojo.UserDTO;
import com.tedu.mallserver.pojo.UserPasswordDTO;
import com.tedu.mallserver.pojo.UserVO;
import com.tedu.mallserver.service.UserService;
import org.omg.CORBA.ServerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin    //告诉浏览器，允许别的网站访问我
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/changePassword")
    public ServerResult changePassword(UserPasswordDTO userPasswordDTO){
        boolean isSuccess = userService.changePassword(userPasswordDTO);
        if(isSuccess){
            return new ServerResult(0,"修改密码成功",null);
        }
        else{
            return new ServerResult(103,"修改密码失败",null);
        }
    }

    @RequestMapping("/user/getUserInfo")
    public ServerResult getUserInfo(Integer id){
        UserVO userVO = userService.getUserInfo(id);
        return new ServerResult(0,"查询成功",userVO);
    }

    @RequestMapping("/user/login")
    //http://localhost:9002/user/login?name=a&password=a
    public ServerResult login(UserDTO userDTO){
        Integer id = userService.login(userDTO);
        if(id >= 1){
            ServerResult serverResult = new ServerResult(0, "登录成功", id);
            return serverResult;
        }else{
            ServerResult serverResult = new ServerResult(101, "登录失败", null);
            return serverResult;
        }
    }
}
