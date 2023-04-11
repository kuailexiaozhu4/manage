package com.zhu.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhu.manage.domain.Vaccine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Mapper
public interface VaccineDao extends BaseMapper<Vaccine> {
    /***
     * @param current  当前第几条  如果为 1 则表示第2条
     * @param size     每页几条
     * @param vaccine  条件查询参数
     * @return 返回疫苗集合
     */
    List<Vaccine> getList(Long current, Long size, Vaccine vaccine);

    Long countVaccine(Vaccine vaccine);

    Long updateVaccine(Vaccine vaccine);

    int insertVaccine(Vaccine vaccine);
}
