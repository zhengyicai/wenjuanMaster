/* 
 * 文件名：SysParameterMapper.java  
 * 版权：Copyright 2016-2017 炎宝网络科技  All Rights Reserved by
 * 修改人：邱深友  
 * 创建时间：2017年6月15日
 * 版本号：v1.0
*/
package com.qzi.cms.server.mapper;

import ch.qos.logback.classic.net.SyslogAppender;
import com.qzi.cms.common.po.SysAnswerPo;
import com.qzi.cms.common.po.SysClassesPo;
import com.qzi.cms.common.po.SysQuestionsPo;
import com.qzi.cms.common.vo.SysEquipmentFileVo;
import com.qzi.cms.server.base.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 设置file
 * @author qsy
 * @version v1.0
 * @date 2017年6月15日
 */
public interface SysAnswerMapper extends BaseMapper<SysAnswerPo>{



    @Select("select * from sys_answer where sysQuestionsId=#{sysQuestionsId} order by  CAST(sort AS SIGNED)")
    public List<SysAnswerPo> findList(@Param("sysQuestionsId") String sysQuestionsId);


    @Delete("delete from sys_answer where sysQuestionsId=#{sysQuestionsId} ")
    public void deleteQuestionId(@Param("sysQuestionsId") String sysQuestionsId);






}
