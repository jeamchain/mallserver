package com.tedu.mallserver.pojo;
//控制层返给浏览器的对象

public class ServerResult {
    Integer state;  //状态码 0:成功
    String msg; //对状态码的描述
    Object date;    //返回的数据

    //有参的构造方法
    public ServerResult(Integer state, String msg, Object date) {
        this.state = state;
        this.msg = msg;
        this.date = date;
    }

    //get，set方法

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
