package com.zhu.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhu.manage.domain.AppUser;
import com.zhu.manage.mapper.AppUserDao;
import com.zhu.manage.service.AppUserService;
import com.zhu.manage.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserDao appUserDao;

    public IPage<AppUser> getPage(int current, int size, AppUser appUser) {
        LambdaQueryWrapper<AppUser> wrapper = new LambdaQueryWrapper();
        wrapper.like(appUser.getName() != null && appUser.getName() != "", AppUser::getName, appUser.getName());
        wrapper.like(appUser.getPhone() != null && appUser.getPhone() != "", AppUser::getPhone, appUser.getPhone());
        IPage<AppUser> page = new Page<>(current, size);
        return appUserDao.selectPage(page, wrapper);
    }

    @Override
    public AppUser getUserById(int id) {
        return appUserDao.selectById(id);
    }

    @Override
    public Boolean removeUserById(int id) {
        return appUserDao.deleteById(id) == 1;
    }

    @Override
    public Boolean updateUser(AppUser appUser) {
        return appUserDao.updateById(appUser) == 1;
    }

    @Override
    public AppUser getUserByPhone(AppUser appUser) {
        LambdaQueryWrapper<AppUser> wrapper = new LambdaQueryWrapper();
        wrapper.eq(appUser.getPhone() != null && appUser.getPhone() != "", AppUser::getPhone, appUser.getPhone());
        return appUserDao.selectOne(wrapper);
    }

    @Override
    public Boolean addAppUser(AppUser appUser) {
        appUser.setCreateTime(new Date());
        String password = Md5Util.md5(appUser.getPassword());
        appUser.setPassword(password);
        int insert = appUserDao.insert(appUser);
        return insert == 1;
    }
}
