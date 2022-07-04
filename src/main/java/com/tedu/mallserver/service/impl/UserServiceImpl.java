package com.tedu.mallserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.mallserver.mapper.UserMapper;
import com.tedu.mallserver.pojo.UserDAO;
import com.tedu.mallserver.pojo.UserDTO;
import com.tedu.mallserver.pojo.UserPasswordDTO;
import com.tedu.mallserver.pojo.UserVO;
import com.tedu.mallserver.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //spring框架会为类创建对象，对象放在容器中
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer register(UserDTO userDTO) {
        //1、判断用户名是否存在
        //select * from user where name = ''
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",userDTO.getName());
        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        if(userDAO==null){  //用户名在数据库中不存在
            //2、保存到数据库
            UserDAO insertUserDAO = new UserDAO();
            insertUserDAO.setName(userDTO.getName());
            insertUserDAO.setPassword(userDTO.getPassword());
            int insertRow = userMapper.insert(insertUserDAO);
            if(insertRow==0){
                throw new RuntimeException("注册，保存数据失败");
            }else{
                //3、查询用户的编号
                //select * from user where name = '' and password = ''
                QueryWrapper selectQueryWrapper = new QueryWrapper();
                selectQueryWrapper.eq("name",userDTO.getName());
                selectQueryWrapper.eq("password",userDTO.getPassword());
                UserDAO selectUserDAO = userMapper.selectOne(selectQueryWrapper);
                return selectUserDAO.getId();
            }



        }


        throw new RuntimeException("注册时用户名已经存在");
    }

    @Override
    public boolean changePassword(UserPasswordDTO userPasswordDTO) {
        //update user set password='' where id=1 and password=oldPassword
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",userPasswordDTO.getId());
        queryWrapper.eq("password",userPasswordDTO.getOldPassword());

        UserDAO userDAO = new UserDAO();
        userDAO.setPassword(userPasswordDTO.getNewPassword());
        //userDAO中有好几项数据，执行下面操作时会进行判断，若列值为null，就不会更新name列
        int updateRow = userMapper.update(userDAO, queryWrapper);

        return updateRow >= 1;
    }

    @Override
    public Integer login(UserDTO userDTO) {
        //select ... where name = '' and password = ''
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",userDTO.getName());
        queryWrapper.eq("password",userDTO.getPassword());

        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        //判断登录是否成功
        if(userDAO != null){
            return userDAO.getId();
        }
        return -1;  //登录失败
    }

    @Override
    public UserVO getUserInfo(Integer id) {
        //select * from user where id = 1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);

        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        if(userDAO==null){
            throw new RuntimeException("没有查到用户信息");
        }

        UserVO userVO = new UserVO();
        //BeanUtils.copyProperties();   实际工作可用(将一个对象的内容拷贝到另一个对象中去)
        userVO.setId(id);
        userVO.setName(userDAO.getName());
        userVO.setCity(userDAO.getCity());
        return userVO;
    }
}
