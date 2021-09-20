package com.codefish.controller;/**
 * @author codefish
 * @date 9/20/2021
 * @apinote
 */

import com.codefish.dao.UserDao;
import com.codefish.domain.User;
import com.codefish.service.UserService;
import com.codefish.service.impl.UserServiceImpl;
import com.codefish.util.ServiceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.xml.ws.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: codefish
 * @discription:
 */
public class Test {
    public static void main(String[] args) {
        //select 也需要走动态代理, 为了方便以后修改以及动态代理功能扩展;
        UserService userService1 = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList = userService1.selectAll();
        for (User userItem: userList) {
            System.out.println(userItem);
        }

        //用户添加(通过动态代理)
        User user = new User("zhangwuji", 34, "234234");
        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
        Integer result = userService.userAdd(user);
        System.out.println(result);
    }
}
