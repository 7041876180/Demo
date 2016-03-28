package com.zhangyongyi.mydemo.entity;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.zhangyongyi.mydemo.entity.UserEntity;
import com.zhangyongyi.mydemo.entity.MessageEntity;

import com.zhangyongyi.mydemo.entity.UserEntityDao;
import com.zhangyongyi.mydemo.entity.MessageEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userEntityDaoConfig;
    private final DaoConfig messageEntityDaoConfig;

    private final UserEntityDao userEntityDao;
    private final MessageEntityDao messageEntityDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userEntityDaoConfig = daoConfigMap.get(UserEntityDao.class).clone();
        userEntityDaoConfig.initIdentityScope(type);

        messageEntityDaoConfig = daoConfigMap.get(MessageEntityDao.class).clone();
        messageEntityDaoConfig.initIdentityScope(type);

        userEntityDao = new UserEntityDao(userEntityDaoConfig, this);
        messageEntityDao = new MessageEntityDao(messageEntityDaoConfig, this);

        registerDao(UserEntity.class, userEntityDao);
        registerDao(MessageEntity.class, messageEntityDao);
    }
    
    public void clear() {
        userEntityDaoConfig.getIdentityScope().clear();
        messageEntityDaoConfig.getIdentityScope().clear();
    }

    public UserEntityDao getUserEntityDao() {
        return userEntityDao;
    }

    public MessageEntityDao getMessageEntityDao() {
        return messageEntityDao;
    }

}
