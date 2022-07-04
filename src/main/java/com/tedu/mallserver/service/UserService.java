package com.tedu.mallserver.service;

import com.tedu.mallserver.pojo.UserDTO;
import com.tedu.mallserver.pojo.UserPasswordDTO;
import com.tedu.mallserver.pojo.UserVO;

public interface UserService {

    /**
     * 注册
     * @param userDTO
     * @return 用户编号
     */
    public Integer register(UserDTO userDTO);
    /**
     * 修改密码
     * @param userPasswordDTO
     * @return true修改成功,false修改失败
     */
    public boolean changePassword(UserPasswordDTO userPasswordDTO);
    /**
     * 登录
     * @param userDTO {name,password}
     * @return 用户编号
     */
    public Integer login(UserDTO userDTO);

    /**
     * 返回用户信息
     * @param id
     * @return
     */
    public UserVO getUserInfo(Integer id);
}
