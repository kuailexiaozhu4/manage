package com.zhu.manage.service;

import com.zhu.manage.domain.User;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
public interface UserService {

    User getSysUser(User user);

    Boolean addSysUser(User user);
}
