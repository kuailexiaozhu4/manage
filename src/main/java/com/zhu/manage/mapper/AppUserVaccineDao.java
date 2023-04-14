package com.zhu.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhu.manage.domain.AppUserVaccine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年04月
 */
@Mapper
public interface AppUserVaccineDao extends BaseMapper<AppUserVaccine> {
    List<AppUserVaccine> getListByConditions(Long current, Long size, String vaccineName, String appUserName, Integer hospitalId, Integer sign);

    Long countList(String vaccineName, String appUserName, Integer hospitalId, Integer sign);
}
