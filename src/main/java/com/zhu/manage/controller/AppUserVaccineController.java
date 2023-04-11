package com.zhu.manage.controller;

import com.zhu.manage.service.AppUserVaccineService;
import com.zhu.manage.utils.Page;
import com.zhu.manage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuwulong
 * @date 2023年04月
 */
@RestController
@RequestMapping("/appUserVaccine")
public class AppUserVaccineController {
    @Autowired
    private AppUserVaccineService appUserVaccineService;

    @GetMapping("/{current}/{size}")
    public Result getAppoints(@PathVariable Long current, @PathVariable Long size,
                              @RequestParam(required = false) String vaccineName,
                              @RequestParam(required = false) String appUserName,
                              @RequestParam(required = true) Integer hospitalId,
                              @RequestParam(required = true) Integer sign) {
        Page page = appUserVaccineService.getPage(current, size, vaccineName, appUserName, hospitalId, sign);
        if (current > page.getPageNumber()) {
            page = appUserVaccineService.getPage(1L, size, vaccineName, appUserName, hospitalId, sign);
        }
        return Result.success(page);

    }

}
