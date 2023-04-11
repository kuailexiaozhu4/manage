package com.zhu.manage.utils;

/**
 * @author zhuwulong
 * @date 2023年04月
 */
public enum ResultCode {
    SUCCESS(1, "操作成功");
    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
