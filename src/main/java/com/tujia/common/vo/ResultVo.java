package com.tujia.common.vo;

import java.io.Serializable;

/**
 * ·µ»Ø½á¹ûvo
 * @author yunan01
 *
 */
public class ResultVo implements Serializable {

	private static final long serialVersionUID = -5517677343247394798L;
	private int code;
    private String info = "";
    private Object res = "";

    public ResultVo(Integer code, String info, Object object) {
		this.code = code;
		this.info = info;
		this.res = object;
	}
    public ResultVo(){
    	
    }
	/**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the res
     */
    public Object getRes() {
        return res;
    }

    /**
     * @param res the res to set
     */
    public void setRes(Object res) {
        this.res = res;
    }

}
