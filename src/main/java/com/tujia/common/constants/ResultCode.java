package com.tujia.common.constants;

public enum ResultCode {
    SUCC(0), SESSION_TIMEOUT(100), WARN(400), ERROR(500),DUPLICATE(600),SUSPECTED(700),IMPERFECT(800);
    private int code;

    private ResultCode(int code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

}
