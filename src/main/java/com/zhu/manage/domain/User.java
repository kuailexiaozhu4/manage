package com.zhu.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class User {
    private Integer id;
    private String name;
    private String phone;
    private String password;
    private Integer hospitalId;//所属医院id
    private String code;//医生编号
//    private boolean status;//是否被禁用
//    private boolean admin;//是否为管理员
}
