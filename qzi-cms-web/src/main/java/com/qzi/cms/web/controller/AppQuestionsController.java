package com.qzi.cms.web.controller;

import com.qzi.cms.common.enums.RespCodeEnum;
import com.qzi.cms.common.po.SysAnswerPo;
import com.qzi.cms.common.po.SysClassesPo;
import com.qzi.cms.common.po.SysEquipmentFilePo;
import com.qzi.cms.common.po.SysQuestionsPo;
import com.qzi.cms.common.resp.Paging;
import com.qzi.cms.common.resp.RespBody;
import com.qzi.cms.common.util.LogUtils;
import com.qzi.cms.common.util.ToolUtils;
import com.qzi.cms.common.util.YBBeanUtils;
import com.qzi.cms.common.vo.SysQuestionsVo;
import com.qzi.cms.server.mapper.SysAnswerMapper;
import com.qzi.cms.server.mapper.SysClassesMapper;
import com.qzi.cms.server.mapper.SysQuestionsMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 文件管理
 * Created by Administrator on 2019/6/8.
 */


@RestController
@RequestMapping("/appQuestions")
public class AppQuestionsController {


	@Resource
	private SysQuestionsMapper sysQuestionsMapper;


	@Resource
	private SysClassesMapper sysClassesMapper;


	@Resource
	private SysAnswerMapper sysAnswerMapper;

	@GetMapping("/findAll")
	public RespBody findAll(SysQuestionsPo sysQuestionsPo){
		RespBody respBody = new RespBody();
		try {
			//保存返回数据

			List<SysQuestionsVo> list =  sysQuestionsMapper.appFindAll(sysQuestionsPo.getType(),sysQuestionsPo.getSolt());


			if("20".equals(sysQuestionsPo.getType())){
					list = sysQuestionsMapper.appFindAll2(sysQuestionsPo.getType(),sysQuestionsPo.getSolt());
			}


			//List<SysQuestionsVo> list1 = sysQuestionsMapper.appFindAll("30");






			for(SysQuestionsVo sysQuestionsPo1:list){
                sysQuestionsPo1.setAnswer(sysAnswerMapper.findList(sysQuestionsPo1.getId()));
            }

			respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找文件所有数据成功", list);
			//保存分页对象

		} catch (Exception ex) {
			respBody.add(RespCodeEnum.ERROR.getCode(), "查找文件所有设备数据失败");
			LogUtils.error("查找所有设备数据失败！",ex);
		}
		return respBody;
	}








}
