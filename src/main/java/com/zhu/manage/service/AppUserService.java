package com.zhu.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhu.manage.domain.AppUser;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
public interface AppUserService {
    IPage getPage(int current, int size, AppUser appUser);

    AppUser getUserById(int id);

    Boolean removeUserById(int id);

    Boolean updateUser(AppUser appUser);

    AppUser getUserByPhone(AppUser appUser);

    Boolean addAppUser(AppUser appUser);
}
