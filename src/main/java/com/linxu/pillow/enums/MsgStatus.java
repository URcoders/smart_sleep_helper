package com.linxu.pillow.enums;

/**
 * @author linxu
 * @date 2019/4/14
 */
public enum MsgStatus {
    SUCCESS("success"),
    ERROR("error")
    ;
    private String msg;

    MsgStatus(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
