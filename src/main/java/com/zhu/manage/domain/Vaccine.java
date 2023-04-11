package com.zhu.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine implements Serializable {
    private Integer id;
    private String name;
    //    疫苗类型
    private Integer typeId;
    private LocalDate createDate;
    private LocalDate expireDate;
    //    规格
    private String specification;
    //    工厂
    private Factory factoryId;
    //    药品成分
    private String ingredients;
    private Integer count;
    //    批准文号
    private String approvalNumber;
    //适合人群
    private Integer fit;
    //    医院id
    private Integer hospitalId;
}
