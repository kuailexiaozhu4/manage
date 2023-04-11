package com.zhu.manage.controller;

import com.zhu.manage.domain.VaccineType;
import com.zhu.manage.mapper.VaccineTypeDao;
import com.zhu.manage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年04月
 */
@RestController
@RequestMapping("/vaccineType")
public class VaccineTypeController {
    @Autowired
    private VaccineTypeDao vaccineTypeDao;

    @GetMapping
    public Result getAll() {
        List<VaccineType> list = vaccineTypeDao.selectList(null);
        return Result.success(list);
    }
}
