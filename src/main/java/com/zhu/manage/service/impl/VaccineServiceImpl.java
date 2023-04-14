package com.zhu.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhu.manage.domain.Vaccine;
import com.zhu.manage.mapper.VaccineDao;
import com.zhu.manage.service.VaccineService;
import com.zhu.manage.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    private VaccineDao vaccineDao;

    @Override
    public Page getPage(Long current, Long size, Vaccine vaccine) {
        List<Vaccine> list = vaccineDao.getList((current - 1) * size, size, vaccine);
        Long total = vaccineDao.countVaccine(vaccine);
        Page page = new Page(total, size, current, list);
        return page;
    }

    @Override
    public Boolean saveVaccine(Vaccine vaccine) {
        return vaccineDao.insertVaccine(vaccine) == 1;
    }

    @Override
    public Boolean updateVaccine(Vaccine vaccine) {
        return vaccineDao.updateVaccine(vaccine) == 1;
    }

    @Override
    public Boolean deleteVaccineByIds(List<Integer> ids) {
        LambdaQueryWrapper<Vaccine> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(ids != null && ids.size() > 0, Vaccine::getId, ids);
        return vaccineDao.delete(wrapper) > 0;
    }
}
