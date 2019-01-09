package com.hzj.bookshop.control;


import com.hzj.bookshop.bean.User;
import com.hzj.bookshop.service.UserService;
import com.hzj.bookshop.utlis.EmailUtils;
import com.hzj.bookshop.utlis.GenerateLinkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        boolean flag = false;
        try {
            userService.register(user);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        String url = GenerateLinkUtils.generateActivateLink(user);
        EmailUtils.sendAccountActivateEmail(user.getUser_account(), "这是一封激活账号的邮件，复制链接到地址栏来激活他", "<p>点击</p><a target='_BLANK' href='"+ url +"'>" + "点击激活账号" + "</a>");
        return true;
    }

    @PostMapping("/login")
    public Integer login(@RequestBody User user) {
//        System.out.println(user);
        boolean flag = false;
        Integer userId = userService.login(user);
        if ( userId == null) {
            userId = 0;
        }
        return userId;
    }

    @GetMapping("/getUserByUserId")
    public User getUserByUserId(@RequestParam("user_id") int userId) {
        System.out.println(userId);
        User user = userService.getUserByUserId(userId);
        System.out.println(user);
        return user;
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestParam("user_id") Integer userId) {
        System.out.println(userId);
        userService.deleteUser(userId);

    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);

    }

}
