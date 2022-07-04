package com.tedu.mallserver.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

//database access Object
//对应category表
@TableName("category")
public class CategoryDAO {
    Integer id;//id列
    String name;//name列

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
}
