package com.zhu.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    private Integer id;
    private String name;
    //经纬度
    private Double lng;
    private Double lat;
}
