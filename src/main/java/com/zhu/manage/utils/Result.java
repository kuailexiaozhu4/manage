package com.zhu.manage.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Data
@NoArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result success(Object data) {
        return success("请求成功", data);
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(String msg) {
        return new Result(300, msg);
    }

    public static Result fail() {
        return fail("获取失败");
    }
}
