package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {
    public static void main(String[] args){
        Schema schema = new Schema(1000,"com.zhangyongyi.mydemo.entity");

        Entity userEntity = schema.addEntity("UserEntity");
        userEntity.addIntProperty("account");  //账号
        userEntity.addIntProperty("password"); //密码




        Entity messageEntity = schema.addEntity("MessageEntity");
        messageEntity.addIntProperty("name");  //关联
        messageEntity.addStringProperty("message"); //留言



        try {
            // 创建实体类.第二个参数填Android Module的路径
            new DaoGenerator().generateAll(schema, "./App/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
