package com.hzj.bookshop.mapper;

import com.hzj.bookshop.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    /**
     * 查询所有的
     * @return
     */
    List<User> selectAll();

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 删除用户
     * @param user_id
     */
    public void deleteUser(Integer user_id);

    //select * from department where id=#{id}
    @Insert("select * from user where user_id = #{user_id} and user_password = #{user_password}")
    public int findUser(User user);

    public int getUserByPasswordAndAccount(User user);

    /**
     * 查找用户信息， 通过用户主键查找
     * @param userId
     * @return
     */
    public User getUserByUserId(int userId);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);





}
