package com.zhu.manage.controller;

import com.zhu.manage.domain.User;
import com.zhu.manage.service.UserService;
import com.zhu.manage.utils.Result;
import com.zhu.manage.utils.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public Result Login(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        User getUser = userService.getSysUser(user);
        if (getUser == null || !user.getPassword().equals(getUser.getPassword())) {
            return Result.fail("用户不存在或密码错误");
        }
        TokenFactory tokenFactory = new TokenFactory();
        String token = tokenFactory.generateToken(getUser);
        map.put("token", token);
        map.put("hospitalId", getUser.getHospitalId());
//        redisTemplate.opsForValue().set("user" + getUser.getId() + "::hospitalId", getUser.getHospitalId());
        return Result.success("登录成功", map);
    }

    @PostMapping("/register")
    public Result Register(@RequestBody User user) {
        User getuser = userService.getSysUser(user);
        if (getuser != null) {
            return Result.fail("用户已经存在");
        }
        Boolean flag = userService.addSysUser(user);
        if (!flag) {
            return Result.fail("注册失败");
        }
        return Result.success("注册成功", null);
    }
}
