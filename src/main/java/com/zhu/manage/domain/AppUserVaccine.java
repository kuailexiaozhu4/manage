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
public class AppUserVaccine {
    private Integer id;
    private AppUser appUser;
    private Vaccine vaccine;
    private Date appointDate;
    private Date infectDate;
    private Integer time;
    private Integer hospitalId;
    private Integer sign;
}
