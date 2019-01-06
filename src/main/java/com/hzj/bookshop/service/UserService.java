package com.hzj.bookshop.service;

import com.hzj.bookshop.bean.User;
import com.hzj.bookshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void register(User user) {
        String codeUrl = UUID.randomUUID().toString();
        //设置激活验证码
        user.setCode_url(codeUrl);
        //默认设置为未激活状态
        user.setActivated(0);
        userMapper.addUser(user);
    }


    public int login(User user) {
        return userMapper.getUserByPasswordAndAccount(user);
    }

    /**
     * 查找用户信息， 通过用户主键查找
     * @param userId
     * @return
     */
    public User getUserByUserId(int userId) {
        User result = new User();
        result = userMapper.getUserByUserId(userId);
        return result;
    }

    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
