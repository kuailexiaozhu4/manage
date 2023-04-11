package com.zhu.manage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhu.manage.domain.AppUser;
import com.zhu.manage.service.AppUserService;
import com.zhu.manage.utils.Md5Util;
import com.zhu.manage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@RestController
@RequestMapping("/appuser")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/{current}/{size}")
    public Result getUsers(@PathVariable int current, @PathVariable int size, AppUser appUser) {
        IPage<AppUser> page = appUserService.getPage(current, size, appUser);
        if (current > page.getPages()) {
            page = appUserService.getPage(1, size, appUser);
        }
        return Result.success(page);
    }

    @GetMapping()
    public Result getUserById(int id) {
        AppUser appUser = appUserService.getUserById(id);
        if (appUser == null) {
            return Result.fail();
        }
        return Result.success(appUser);
    }

    @DeleteMapping()
    public Result removeUser(int id) {
        AppUser appUser = appUserService.getUserById(id);
        if (appUser == null) {
            return Result.fail();
        } else {
            Boolean exist = appUserService.removeUserById(id);
        }
        return Result.success();
    }

    @PutMapping()
    public Result updateUser(@RequestBody AppUser appUser) {
        AppUser getAppUser = appUserService.getUserById(appUser.getId());
        if (getAppUser == null) {
            return Result.fail("用户不存在");
        }
        return appUserService.updateUser(appUser) == true ? Result.success("修改成功",null) : Result.fail("用户信息更新失败");
    }

    //    app
    @PostMapping()
    public Result login(@RequestBody AppUser appUser) {
        AppUser getUser = appUserService.getUserByPhone(appUser);

        if (getUser == null || !Md5Util.md5(appUser.getPassword()).equals(getUser.getPassword())) {
            return Result.fail("手机号或密码错误");
        }
        return Result.success(getUser);
    }

    @PostMapping("/add")
    public Result register(@RequestBody AppUser appUser) {
        AppUser getUser = appUserService.getUserByPhone(appUser);
        if (getUser != null) {
            return Result.fail("用户已存在");
        }
        return appUserService.addAppUser(appUser) == true ? Result.success() : Result.fail("注册失败");
    }
}
