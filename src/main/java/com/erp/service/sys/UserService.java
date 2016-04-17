package com.erp.service.sys;

import com.erp.dao.sys.UserDao;
import com.erp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shuai on 2016/4/16.
 */
@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public boolean select(User user){
      return  dao.select(user) !=null ?true:false;
    }
}
