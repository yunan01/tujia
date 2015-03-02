package com.tujia.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tujia.common.BaseController;
import com.tujia.common.vo.ResultVo;

@Controller
@RequestMapping("/org/manage")
public class OrgManageController extends BaseController{
	
	@RequestMapping(value = "/addOrganization", method = RequestMethod.POST)
    @ResponseBody
	public ResultVo addOrganization(){
		
		
		return this.success("hello organization manage system");
		//return "hello organization manage system";
	}

}
