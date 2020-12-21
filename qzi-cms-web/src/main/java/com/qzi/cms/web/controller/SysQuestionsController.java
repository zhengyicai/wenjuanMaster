package com.qzi.cms.web.controller;

import com.qzi.cms.common.enums.RespCodeEnum;
import com.qzi.cms.common.po.*;
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
@RequestMapping("/sysQuestions")
public class SysQuestionsController {


	@Resource
	private SysQuestionsMapper sysQuestionsMapper;


	@Resource
	private SysClassesMapper sysClassesMapper;


	@Resource
	private SysAnswerMapper sysAnswerMapper;

	@GetMapping("/findAll")
	public RespBody findAll(Paging paging, SysQuestionsPo sysQuestionsPo){
		RespBody respBody = new RespBody();


		int startRow=0;int pageSize=0;
		if(null!=paging){
			startRow=(paging.getPageNumber()>0)?(paging.getPageNumber()-1)*paging.getPageSize():0;
			pageSize=paging.getPageSize();
		}else{
			pageSize=Integer.MAX_VALUE;
		}
		try {
			//保存返回数据

			List<SysQuestionsVo> list =  sysQuestionsMapper.findAll1(sysQuestionsPo,startRow,pageSize);


			for(SysQuestionsVo sysQuestionsPo1:list){
                sysQuestionsPo1.setAnswer(sysAnswerMapper.findList(sysQuestionsPo1.getId()));
            }

			respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找文件所有数据成功", list);
			//保存分页对象
			paging.setTotalCount(sysQuestionsMapper.findCount1(sysQuestionsPo));
			respBody.setPage(paging);
		} catch (Exception ex) {
			respBody.add(RespCodeEnum.ERROR.getCode(), "查找文件所有设备数据失败");
			LogUtils.error("查找所有设备数据失败！",ex);
		}
		return respBody;
	}



	@ResponseBody
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public RespBody addFile(@RequestBody SysQuestionsVo vo){
		RespBody respBody = new RespBody();

		SysQuestionsPo sysQuestionsPo = new SysQuestionsPo();

		String id = ToolUtils.getUUID();
		sysQuestionsPo.setId(id);
		sysQuestionsPo.setCreateTime(new Date());
		sysQuestionsPo.setState("10");
		sysQuestionsPo.setSort(vo.getSort());
		sysQuestionsPo.setTitle(vo.getTitle());
		sysQuestionsPo.setClassesId(vo.getClassesId());
		sysQuestionsPo.setClassesId2(vo.getClassesId2());
		sysQuestionsPo.setRemark(vo.getRemark());
		sysQuestionsPo.setType(vo.getType());
		sysQuestionsPo.setAnswer1("");
		sysQuestionsPo.setTitleType("");
		sysQuestionsPo.setTitleType1("");
		sysQuestionsPo.setSolt(vo.getSolt());


		//添加选项
		Integer sort = 0;
		for(SysAnswerPo sysAnswerPo:vo.getAnswer()){

			sort++;
			sysAnswerPo.setId(ToolUtils.getUUID());
			sysAnswerPo.setCreateTime(new Date());
			sysAnswerPo.setState("10");
			sysAnswerPo.setSysQuestionsId(id);
			sysAnswerPo.setSort(sort+"");
			sysAnswerPo.setRemark(sysAnswerPo.getRemark());

			sysAnswerMapper.insert(sysAnswerPo);

		}

		sysQuestionsMapper.insert(sysQuestionsPo);
		return  respBody;
	}


    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RespBody update(@RequestBody SysQuestionsVo vo){
        RespBody respBody = new RespBody();

        SysQuestionsPo sysQuestionsPo = new SysQuestionsPo();


        try {
            SysQuestionsPo po =   YBBeanUtils.copyProperties(vo, SysQuestionsPo.class);
            sysQuestionsMapper.updateByPrimaryKey(po);
        } catch (Exception e) {
            e.printStackTrace();
        }





        //添加选项
        Integer sort = 0;

        sysAnswerMapper.deleteQuestionId(vo.getId());

        for(SysAnswerPo sysAnswerPo:vo.getAnswer()){

            sort++;
            sysAnswerPo.setId(ToolUtils.getUUID());
            sysAnswerPo.setCreateTime(new Date());
            sysAnswerPo.setState("10");
            sysAnswerPo.setSysQuestionsId(vo.getId());
            sysAnswerPo.setSort(sort+"");
            sysAnswerPo.setRemark(sysAnswerPo.getRemark());

            sysAnswerMapper.insert(sysAnswerPo);

        }

        //sysQuestionsMapper.insert(sysQuestionsPo);
        return  respBody;
    }


    /**
     * 一级菜单
	 * @param sysEquipmentFilePo
     * @return
     */
	@GetMapping("/findLevelOne")
	public RespBody findLevelOne(SysEquipmentFilePo sysEquipmentFilePo){
		RespBody respBody = new RespBody();


		List<SysClassesPo> list =  sysClassesMapper.findLevelOne();
		respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找文件所有数据成功",list );

		return respBody;
	}


    /**
     * 二级菜单
	 * @param sysClassesPo
     * @return
     */

	@GetMapping("/findLevelTwo")
	public RespBody findLevelTwo(SysClassesPo sysClassesPo){
		RespBody respBody = new RespBody();


		List<SysClassesPo> list =  sysClassesMapper.findLevelTwo(sysClassesPo.getParentId());
		respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找文件所有数据成功",list );

		return respBody;
	}


	@GetMapping("/findAllSelect")
	public RespBody findAllSelect(SysEquipmentFilePo sysEquipmentFilePo){
		RespBody respBody = new RespBody();


		List<SysClassesPo> list =  sysClassesMapper.findList();
		respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找文件所有数据成功",list );

		return respBody;
	}


    @GetMapping("/findAllList")
    public RespBody findAllList(SysQuestionsVo SysQuestionsVo){
        RespBody respBody = new RespBody();




        List<SysQuestionsVo> list =  sysQuestionsMapper.findList();


        if(list!=null){

            for(SysQuestionsVo po:list){


                po.setAnswer( sysAnswerMapper.findList(po.getId()));




            }
        }

        respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找文件所有数据成功",list);

        return respBody;
    }







}
