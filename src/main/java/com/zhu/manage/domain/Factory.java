package com.zhu.manage.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Data
public class Factory implements Serializable {
    private Integer id;
    private String factoryName;
    private String place;
    private String phone;
}
