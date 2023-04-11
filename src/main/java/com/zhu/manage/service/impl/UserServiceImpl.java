package com.zhu.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhu.manage.domain.User;
import com.zhu.manage.mapper.UserDao;
import com.zhu.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getSysUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(user.getPhone() != null && user.getPhone() != "", User::getPhone, user.getPhone());
        return userDao.selectOne(wrapper);
    }

    @Override
    public Boolean addSysUser(User user) {
//        String pass=user.getPassword();
//        user.setPassword(Md5Util.md5(pass));
        return userDao.insert(user) == 1;
    }
}
