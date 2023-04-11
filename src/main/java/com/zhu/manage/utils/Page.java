package com.zhu.manage.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Data
public class Page implements Serializable {
    private Long total;
    private Long size;
    private Long current;
    private Long pageNumber;
    private Object records;

    public Page(Long total, Long size, Long current, Object records) {
        this.total = total;
        this.size = size;
        this.current = current;
        this.records = records;
        this.pageNumber = total % size == 0 ? total / size : total / size + 1;
    }
}
