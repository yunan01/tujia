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
     * @Description: ���ط�װ,code=400
     * @param code
     * @param info
     * @return    �趨�ļ� 
     * @throws �쳣˵��
     */
    protected ResultVo warn(String info) {
        ResultVo vo = new ResultVo();
        vo.setCode(ResultCode.WARN.getCode());
        vo.setInfo(info);
        return vo;
    }

    /**
     * 
     * @Description: ���ط�װ��code=500
     * @param code
     * @param info
     * @return    �趨�ļ� 
     * @throws �쳣˵��
     */
    protected ResultVo error(String info) {
        ResultVo vo = new ResultVo();
        vo.setCode(ResultCode.ERROR.getCode());
        vo.setInfo(info);
        return vo;
    }
    
    /** 
     * ���ط�װ��code=500֧���Զ���res��Ϣ
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
     * @Description: ���ط�װ��code=0
     * @param info
     * @param res
     * @return    �趨�ļ� 
     * @throws �쳣˵��
     */
    protected ResultVo success(Object res) {
        return success(null, res);
    }
    /**
     * 
     * ���ط�װ��code=0
     * @return
     */
    protected ResultVo success() {
        return success(null, null);
    }

    /** 
     * �Զ�����ʾ��Ϣ����
     * @param code ������{@link ResultCode}
     * @param info ҳ����ʾ��Ϣ
     * @param res �����ֶ�
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
     * @Description: ���ط�װ��code=0
     * @param info
     * @param res
     * @return    �趨�ļ� 
     * @throws �쳣˵��
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
     * @Description: �ж������Ƿ�Ϊajax
     * @param request
     * @return    �趨�ļ� 
     * @throws �쳣˵��
     */
    public boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    /**
     * @Description: ��dateת��Ϊunixʱ��� 
     * @param date
     * @return    �趨�ļ� 
     * @throws �쳣˵��
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
