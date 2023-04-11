package com.zhu.manage.controller;

import com.zhu.manage.domain.Factory;
import com.zhu.manage.service.FactoryService;
import com.zhu.manage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@RestController
@RequestMapping("/factory")
public class FactoryController {
    @Autowired
    private FactoryService factoryService;

    @GetMapping
    public Result getFactoryList() {
        List<Factory> factoryList = factoryService.getFactoryList();
        if (factoryList == null || factoryList.size() == 0)
            return Result.fail("未查到工厂");
        return Result.success(factoryList);
    }
}
