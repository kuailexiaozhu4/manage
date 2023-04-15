package com.zhu.manage.service.impl;

import com.zhu.manage.domain.AppUserVaccine;
import com.zhu.manage.mapper.AppUserVaccineDao;
import com.zhu.manage.service.AppUserVaccineService;
import com.zhu.manage.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年04月
 */
@Service
public class AppUserVaccineServiceImpl implements AppUserVaccineService {
    @Autowired
    private AppUserVaccineDao appUserVaccineDao;

    public Page getPage(Long current, Long size, String vaccineName, String appUserName, Integer hospitalId, Integer sign) {
        List<AppUserVaccine> lists = appUserVaccineDao.getListByConditions((current - 1) * size, size, vaccineName, appUserName, hospitalId, sign);
        Long total = appUserVaccineDao.countList(vaccineName, appUserName, hospitalId, sign);
        Page page = new Page(total, current, size, lists);
        return page;
    }

    @Override
    public Boolean setSign(AppUserVaccine appUserVaccine) {
        int change = appUserVaccineDao.updateSign(appUserVaccine);
        return change > 0;
    }
}
