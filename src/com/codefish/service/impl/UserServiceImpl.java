package com.codefish.service.impl;/**
 * @author codefish
 * @date 9/20/2021
 * @apinote
 */

import com.codefish.dao.UserDao;
import com.codefish.domain.User;
import com.codefish.service.UserService;
import com.codefish.util.SqlSessionUtil;

import java.util.List;

/**
 * @author: codefish
 * @discription:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public Integer userAdd(User user) {
        return userDao.userAdd(user);
    }
}
