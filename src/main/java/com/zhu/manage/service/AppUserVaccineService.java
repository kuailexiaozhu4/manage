package com.zhu.manage.service;

import com.zhu.manage.utils.Page;

/**
 * @author zhuwulong
 * @date 2023年04月
 */
public interface AppUserVaccineService {
    Page getPage(Long current, Long size, String vaccineName, String appUserName, Integer hospitalId, Integer sign);
}
