package com.zhu.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private Integer id;
    private String name;
    private String idCard;
    private String password;
    private String gender;
    private String address;
    private String phone;
    private String age;
    private Date createTime;
}
