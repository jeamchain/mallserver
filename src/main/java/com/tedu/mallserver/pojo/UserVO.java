package com.tedu.mallserver.pojo;
//用来在客户端上显示用户信息
public class UserVO {
    Integer id;
    String name;
    String city;
    //积分，等级

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
