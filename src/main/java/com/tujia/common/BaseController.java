package com.tujia.common;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tujia.common.constants.ResultCode;
import com.tujia.common.vo.ResultVo;




public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 
     * @Description: 返回封装,code=400
     * @param code
     * @param info
     * @return    设定文件 
     * @throws 异常说明
     */
    protected ResultVo warn(String info) {
        ResultVo vo = new ResultVo();
        vo.setCode(ResultCode.WARN.getCode());
        vo.setInfo(info);
        return vo;
    }

    /**
     * 
     * @Description: 返回封装，code=500
     * @param code
     * @param info
     * @return    设定文件 
     * @throws 异常说明
     */
    protected ResultVo error(String info) {
        ResultVo vo = new ResultVo();
        vo.setCode(ResultCode.ERROR.getCode());
        vo.setInfo(info);
        return vo;
    }
    
    /** 
     * 返回封装，code=500支持自定义res信息
     * @param info
     * @param res
     * @return
     */
    protected ResultVo error(String info, Object res) {
        ResultVo vo = new ResultVo();
        vo.setCode(ResultCode.ERROR.getCode());
        vo.setInfo(info);
        vo.setRes(res);
        return vo;
    }

    /**
     * @Description: 返回封装，code=0
     * @param info
     * @param res
     * @return    设定文件 
     * @throws 异常说明
     */
    protected ResultVo success(Object res) {
        return success(null, res);
    }
    /**
     * 
     * 返回封装，code=0
     * @return
     */
    protected ResultVo success() {
        return success(null, null);
    }

    /** 
     * 自定义提示信息方法
     * @param code 返回码{@link ResultCode}
     * @param info 页面提示信息
     * @param res 数据字段
     * @return
     */
    protected ResultVo message(ResultCode code, String info, Object res) {
        ResultVo vo = new ResultVo();
        vo.setCode(code.getCode());
        vo.setInfo(info);
        vo.setRes(res);
        return vo;
    }
    
    /**
     * @Description: 返回封装，code=0
     * @param info
     * @param res
     * @return    设定文件 
     * @throws 异常说明
     */
    protected ResultVo success(String info, Object res) {
        ResultVo vo = new ResultVo();
        vo.setCode(ResultCode.SUCC.getCode());
        if (info == null) {
            vo.setInfo("success");
        }
        vo.setRes(res);
        return vo;
    }

    

    /**
     * 
     * @Description: 判断请求是否为ajax
     * @param request
     * @return    设定文件 
     * @throws 异常说明
     */
    public boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    /**
     * @Description: 将date转换为unix时间戳 
     * @param date
     * @return    设定文件 
     * @throws 异常说明
     */
    protected long getUnixTimestamp(Date date) {
        if (date == null) {
            return 0L;
        }
        return date.getTime() / 1000;
    }

	
	protected String getJsonpSuccess(HttpServletRequest request,ResultVo resultVo){
		return getJsonpString(request, resultVo);
		 
	}
	
	protected String getJsonpError(HttpServletRequest request,ResultVo resultVo){
		return getJsonpString(request, resultVo);
	}
	
	protected String getJsonpString(HttpServletRequest request,ResultVo resultVo){
		 JSONObject resultJSON = JSONObject.fromObject(resultVo);
		 String jsonpCallback = request.getParameter("jsonpCallback");
		 return jsonpCallback+"("+resultJSON+")";
	}
	
}
