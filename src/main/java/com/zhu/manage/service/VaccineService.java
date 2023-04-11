package com.zhu.manage.service;

import com.zhu.manage.domain.Vaccine;
import com.zhu.manage.utils.Page;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
public interface VaccineService {
    Boolean saveVaccine(Vaccine vaccine);

    Boolean updateVaccine(Vaccine vaccine);

    Boolean deleteVaccineByIds(List<Integer> ids);

    Page getPage(Long current, Long size, Vaccine vaccine);

}
