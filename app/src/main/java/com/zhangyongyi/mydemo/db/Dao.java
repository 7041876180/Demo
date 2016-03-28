package com.zhangyongyi.mydemo.db;


import com.zhangyongyi.mydemo.BaseApplication;
import com.zhangyongyi.mydemo.entity.DaoMaster;
import com.zhangyongyi.mydemo.entity.DaoSession;

/**
 * Created by dllo on 16/1/17.
 * 数据库
 */
public class Dao {
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;


    public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {//静态方法只能访问静态变量(context)
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(BaseApplication.getContext(), "demo.db", null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null)
                getDaoMaster();
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

}
