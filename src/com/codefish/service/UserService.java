package com.codefish.service;/**
 * @author codefish
 * @date 9/20/2021
 * @apinote
 */

import com.codefish.domain.User;

import java.util.List;

/**
 * @author: codefish
 * @discription:
 */
public interface UserService {
    List<User> selectAll();
    Integer userAdd(User user);
}
