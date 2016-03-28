package com.zhangyongyi.mydemo.db;


import com.zhangyongyi.mydemo.entity.DaoSession;
import com.zhangyongyi.mydemo.entity.MessageEntity;
import com.zhangyongyi.mydemo.entity.UserEntity;

import java.util.List;

/**
 * Created by dllo on 16/1/17.
 * 操作数据库  增删查
 */
public class DaoHelper {


    private static DaoHelper helper;
    private static DaoSession daoSession;

    private DaoHelper() {

    }

    public static DaoHelper getInstance() {
        if (helper == null) {
            helper = new DaoHelper();
            daoSession = Dao.getDaoSession();
        }
        return helper;
    }

    //删除
    //NewestList
    public void deleteUserList() {
        daoSession.getUserEntityDao().deleteAll();
    }

    //添加
    public void addUserList(List<UserEntity> data) {
        deleteUserList();
        daoSession.getUserEntityDao().insertInTx(data);
    }

    //查询
    public List<UserEntity> seacherUserList() {
        return daoSession.getUserEntityDao().loadAll();
    }

    /**
     *
     */
    //删除
    //NewestList
    public void deleteMessageList() {
        daoSession.getMessageEntityDao().deleteAll();
    }

    //添加
    public void addMessageList(List<MessageEntity> data) {
        deleteMessageList();
        daoSession.getMessageEntityDao().insertInTx(data);
    }

    //查询
    public List<MessageEntity> seacherMessageList() {
        return daoSession.getMessageEntityDao().loadAll();
    }


}
