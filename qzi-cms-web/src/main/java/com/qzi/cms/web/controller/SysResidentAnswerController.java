package com.qzi.cms.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qzi.cms.common.annotation.SystemControllerLog;
import com.qzi.cms.common.enums.RespCodeEnum;
import com.qzi.cms.common.po.SysResidentAnswerPo;
import com.qzi.cms.common.po.SysResidentPo;
import com.qzi.cms.common.resp.Paging;
import com.qzi.cms.common.resp.RespBody;
import com.qzi.cms.common.util.LogUtils;
import com.qzi.cms.common.util.ToolUtils;
import com.qzi.cms.common.vo.SysQuestionsVo;
import com.qzi.cms.common.vo.SysResidentAnswerVo;
import com.qzi.cms.common.vo.SysResidentAnswerVo1;
import com.qzi.cms.common.vo.SysResidentVo;
import com.qzi.cms.server.mapper.SysAnswerMapper;
import com.qzi.cms.server.mapper.SysQuestionsMapper;
import com.qzi.cms.server.mapper.SysResidentAnswerMapper;
import com.qzi.cms.server.mapper.SysResidentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件管理
 * Created by Administrator on 2019/6/8.
 */


@RestController
@RequestMapping("/sysResidentAnswer")
public class SysResidentAnswerController {

       @Resource
       private SysResidentAnswerMapper sysResidentAnswerMapper;


    @Resource
    private SysQuestionsMapper sysQuestionsMapper;


       @Resource
       private SysAnswerMapper sysAnswerMapper;

        @GetMapping("/findAll")
    	public RespBody findAll(Paging paging, SysResidentAnswerVo sysResidentAnswerVo){
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

    		  List<SysResidentAnswerVo> list =  sysResidentAnswerMapper.findAll(sysResidentAnswerVo,startRow,pageSize);

    			respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找所有数据成功", list);
    			//保存分页对象
    			paging.setTotalCount(sysResidentAnswerMapper.findCount(sysResidentAnswerVo));
    			respBody.setPage(paging);
    		} catch (Exception ex) {
    			respBody.add(RespCodeEnum.ERROR.getCode(), "查找数据失败");
    			LogUtils.error("查找所有数据失败！",ex);
    		}
    		return respBody;
    	}


    @PostMapping("/add")
    @SystemControllerLog(description="新增")
    public RespBody add(@RequestBody SysResidentAnswerPo sysResidentAnswerPo){
        RespBody respBody = new RespBody();
        try {


            sysResidentAnswerPo.setId(ToolUtils.getUUID());
            sysResidentAnswerPo.setCreateTime(new Date());
            sysResidentAnswerPo.setState("10");
            sysResidentAnswerPo.setRemark("");
            sysResidentAnswerPo.setUpdateTime(new Date());
            sysResidentAnswerPo.setAnswerCount("");
            sysResidentAnswerMapper.insert(sysResidentAnswerPo);
            //  parameterService.add(parameterVo);
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "保存成功");
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "保存失败");
            LogUtils.error("保存失败！",ex);
        }
        return respBody;
    }


    @PostMapping("/update")
    @SystemControllerLog(description="修改")
    public RespBody update(@RequestBody SysResidentAnswerPo sysResidentAnswerPo){
        RespBody respBody = new RespBody();
        try {

            sysResidentAnswerMapper.updateByPrimaryKey(sysResidentAnswerPo);
            //  parameterService.add(parameterVo);
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "修改成功");
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "修改失败");
            LogUtils.error("修改失败！",ex);
        }
        return respBody;
    }




    @PostMapping("/delete")
    @SystemControllerLog(description="删除")
    public RespBody delete(@RequestBody SysResidentAnswerPo sysResidentAnswerPo){
        RespBody respBody = new RespBody();
        try {

            sysResidentAnswerMapper.delete(sysResidentAnswerPo);
            //  parameterService.add(parameterVo);
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "删除成功");
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "删除失败");
            LogUtils.error("删除失败！",ex);
        }
        return respBody;
    }



    @GetMapping("/phone")
    public RespBody phone(String phone){
        RespBody respBody = new RespBody();
        try {
            //保存返回数据
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找所有患者数据成功", sysResidentAnswerMapper.findPhone(phone));
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "查找所有患者数据失败");
            LogUtils.error("查找所有住户数据失败！",ex);
        }
        return respBody;
    }


    @GetMapping("/getAnswer")
    public RespBody phone(String residentId,String type,String classes){
        RespBody respBody = new RespBody();
        try {

            List<SysResidentAnswerVo1> list = new ArrayList<SysResidentAnswerVo1>();

            if("".equals(classes) || classes==null){
                list = sysResidentAnswerMapper.findResidentId1(residentId,type);
            }else{
                list =  sysResidentAnswerMapper.findResidentId(residentId,type,classes);

            }


            //  list =   sysResidentAnswerMapper.findResidentId(residentId,type,classes);


             if(list!=null){
                 for(int i=0;i<list.size();i++){

                     JSONArray jsonArray=JSONArray.parseArray(list.get(i).getResults());

                     List<SysResidentAnswerVo> list11 = new ArrayList<SysResidentAnswerVo>();
                     for(int j=0;j<jsonArray.size();j++){
                         JSONObject object= (JSONObject) jsonArray.get(j);
                         System.out.println(object.get("id"));
                         System.out.println(object.get("name"));
                         System.out.println(object.get("message"));
                         System.out.println(object.get("type"));
                         System.out.println(sysAnswerMapper.findList(object.get("id")+""));

                         SysResidentAnswerVo sysResidentAnswerVo = new SysResidentAnswerVo();

                         SysQuestionsVo sysQuestionsVo = new SysQuestionsVo();
                         if((object.get("id")+"").equals("")){
                             sysResidentAnswerVo.setTitleType("");
                             sysResidentAnswerVo.setTitleType1("");
                         }else{
                              sysQuestionsVo = sysQuestionsMapper.findone(object.get("id")+"");
                              if(sysQuestionsVo!=null){
                                  sysResidentAnswerVo.setTitleType(sysQuestionsVo.getTitleType());
                                  sysResidentAnswerVo.setTitleType1(sysQuestionsVo.getTitleType1());
                              }else{
                                  sysResidentAnswerVo.setTitleType("");
                                  sysResidentAnswerVo.setTitleType1("");
                              }


                         }

                         sysResidentAnswerVo.setId(object.get("id")+"");
                         sysResidentAnswerVo.setName(object.get("name")+"");
                         sysResidentAnswerVo.setType(object.get("type")+"");
                         sysResidentAnswerVo.setMessage(object.get("message")+"");
                         sysResidentAnswerVo.setAnswerList(sysAnswerMapper.findList(object.get("id")+""));
                         sysResidentAnswerVo.setRemark(object.get("remark")+"");

                       //  sysResidentAnswerVo.setTitleType(sysQuestionsVo.getTitleType());
                        // sysResidentAnswerVo.setTitleType1(sysQuestionsVo.getTitleType1());
                         list11.add(sysResidentAnswerVo);
                     }
                     list.get(i).setAnswerList(list11);

                      //List<Object> obj =  JSON.parseObject();



                 }
             }

            //保存返回数据
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找所有患者数据成功", list);
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "查找所有患者数据失败");
            LogUtils.error("查找所有住户数据失败！",ex);
        }
        return respBody;
    }



    @GetMapping("/getAnswerState")
    public RespBody getAnswerState(String residentId,String classes){
        RespBody respBody = new RespBody();
        try {
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找所有患者数据成功", sysResidentAnswerMapper.findResidentIdState(residentId,classes));
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "查找所有患者数据失败");
            LogUtils.error("查找所有住户数据失败！",ex);
        }

        return  respBody;



    }


    @PostMapping("/updateAnswer")
    @SystemControllerLog(description="新增")
    public RespBody updateAnswer(@RequestBody SysResidentAnswerPo sysResidentAnswerPo){
        RespBody respBody = new RespBody();
        try {

            sysResidentAnswerMapper.updateAnswer(sysResidentAnswerPo.getResults(),sysResidentAnswerPo.getSysResidentId(),sysResidentAnswerPo.getType(),sysResidentAnswerPo.getClasses());

           // sysResidentAnswerMapper.insert(sysResidentAnswerPo);
            //  parameterService.add(parameterVo);
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "修改成功");
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "修改失败");
            LogUtils.error("保存失败！",ex);
        }
        return respBody;
    }







}
