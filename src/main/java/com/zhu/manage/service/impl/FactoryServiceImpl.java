package com.zhu.manage.service.impl;

import com.zhu.manage.domain.Factory;
import com.zhu.manage.mapper.FactoryDao;
import com.zhu.manage.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Service
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    private FactoryDao factoryDao;

    public List<Factory> getFactoryList() {
        List<Factory> factories = factoryDao.selectList(null);
        return factories;
    }
}
