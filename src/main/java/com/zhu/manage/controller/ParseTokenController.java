package com.zhu.manage.controller;

import com.zhu.manage.utils.Result;
import com.zhu.manage.utils.TokenFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@RestController
@RequestMapping("/check")
public class ParseTokenController {
    @PostMapping
    public Result valid(@RequestBody String token, @RequestBody String phone) {
        if (token == null) {
            return Result.fail("未登录");
        }
        TokenFactory tokenFactory = new TokenFactory();
        boolean flag = tokenFactory.expiredToken(token);
        if (flag) {
            return Result.fail("身份认证已过期,请重新登录");
        }
        Integer hospitalId = tokenFactory.getHospitalIdByToken(token);
        return Result.success(hospitalId);
    }
}
