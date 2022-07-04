package com.tedu.mallserver.pojo;

//数据接收对象,用来接收浏览器发过来的数据
public class UserDTO {
    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
