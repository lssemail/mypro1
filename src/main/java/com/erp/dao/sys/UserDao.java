package com.erp.dao.sys;

import com.erp.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void insert(User user){
        sqlSessionTemplate.insert(UserDao.class.getName()+".insert",user);
    }

    public User select(User user){
        return sqlSessionTemplate.selectOne(UserDao.class.getName()+".select",user);
    }

}