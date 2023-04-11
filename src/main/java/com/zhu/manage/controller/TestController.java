package com.zhu.manage.controller;

import com.zhu.manage.domain.Vaccine;
import com.zhu.manage.mapper.VaccineDao;
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
@RequestMapping("/test")
public class TestController {
    @Autowired
    private VaccineDao vaccineDao;

    @GetMapping
    public String test() {
        Vaccine vaccine = new Vaccine();
        vaccine.setName("xx");
        List<Vaccine> list = vaccineDao.getList(0 * 8L, 8L, vaccine);
        Long aLong = vaccineDao.countVaccine(vaccine);
        System.out.println(list);
        System.out.println(aLong);
        return "你好";
    }
}
