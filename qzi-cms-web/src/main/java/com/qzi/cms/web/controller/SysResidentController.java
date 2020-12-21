package com.qzi.cms.web.controller;

import com.qzi.cms.common.annotation.SystemControllerLog;
import com.qzi.cms.common.enums.RespCodeEnum;
import com.qzi.cms.common.po.SysEquipmentFilePo;
import com.qzi.cms.common.po.SysEquipmentPo;
import com.qzi.cms.common.po.SysFileUrlPo;
import com.qzi.cms.common.po.SysResidentPo;
import com.qzi.cms.common.resp.Paging;
import com.qzi.cms.common.resp.RespBody;
import com.qzi.cms.common.util.LogUtils;
import com.qzi.cms.common.util.ToolUtils;
import com.qzi.cms.common.vo.SysFileUrlVo;
import com.qzi.cms.common.vo.SysParameterVo;
import com.qzi.cms.common.vo.SysResidentVo;
import com.qzi.cms.server.mapper.SysEquipmentFileMapper;
import com.qzi.cms.server.mapper.SysEquipmentMapper;
import com.qzi.cms.server.mapper.SysFileUrlMapper;
import com.qzi.cms.server.mapper.SysResidentMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 文件管理
 * Created by Administrator on 2019/6/8.
 */


@RestController
@RequestMapping("/sysResident")
public class SysResidentController {

       @Resource
       private SysResidentMapper sysResidentMapper;


        @GetMapping("/findAll")
    	public RespBody findAll(Paging paging, SysResidentPo sysResidentPo){
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

    		  List<SysResidentVo> list =  sysResidentMapper.findAll(sysResidentPo,startRow,pageSize);

    			respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找所有数据成功", list);
    			//保存分页对象
    			paging.setTotalCount(sysResidentMapper.findCount(sysResidentPo));
    			respBody.setPage(paging);
    		} catch (Exception ex) {
    			respBody.add(RespCodeEnum.ERROR.getCode(), "查找数据失败");
    			LogUtils.error("查找所有数据失败！",ex);
    		}
    		return respBody;
    	}


    @PostMapping("/add")
    @SystemControllerLog(description="新增")
    public RespBody add(@RequestBody SysResidentPo sysResidentPo){
        RespBody respBody = new RespBody();
        try {


            sysResidentPo.setId(ToolUtils.getUUID());
            sysResidentPo.setCreateTime(new Date());
            sysResidentPo.setState("10");
            sysResidentPo.setRemark("");
            sysResidentMapper.insert(sysResidentPo);
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
    public RespBody update(@RequestBody SysResidentPo sysResidentPo){
        RespBody respBody = new RespBody();
        try {

            sysResidentMapper.updateByPrimaryKey(sysResidentPo);
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
    public RespBody delete(@RequestBody SysResidentPo sysResidentPo){
        RespBody respBody = new RespBody();
        try {

            sysResidentMapper.delete(sysResidentPo);
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
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找所有患者数据成功", sysResidentMapper.findPhone(phone));
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "查找所有患者数据失败");
            LogUtils.error("查找所有住户数据失败！",ex);
        }
        return respBody;
    }


    @GetMapping("/findOne")
    public RespBody findOne(String id){
        RespBody respBody = new RespBody();
        try {
            //保存返回数据
            respBody.add(RespCodeEnum.SUCCESS.getCode(), "查找所有患者数据成功", sysResidentMapper.findOne(id));
        } catch (Exception ex) {
            respBody.add(RespCodeEnum.ERROR.getCode(), "查找所有患者数据失败");
            LogUtils.error("查找所有住户数据失败！",ex);
        }
        return respBody;
    }






}
