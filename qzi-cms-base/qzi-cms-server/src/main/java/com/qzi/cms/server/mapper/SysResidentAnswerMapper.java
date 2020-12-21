/* 
 * 文件名：SysParameterMapper.java  
 * 版权：Copyright 2016-2017 炎宝网络科技  All Rights Reserved by
 * 修改人：邱深友  
 * 创建时间：2017年6月15日
 * 版本号：v1.0
*/
package com.qzi.cms.server.mapper;

import com.qzi.cms.common.po.SysResidentAnswerPo;
import com.qzi.cms.common.po.SysResidentPo;
import com.qzi.cms.common.vo.SysResidentAnswerVo;
import com.qzi.cms.common.vo.SysResidentAnswerVo1;
import com.qzi.cms.common.vo.SysResidentVo;
import com.qzi.cms.server.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 文件管理DAO
 * @author qsy
 * @version v1.0
 * @date 2017年6月15日
 */
public interface SysResidentAnswerMapper extends BaseMapper<SysResidentAnswerPo>{


	public List<SysResidentAnswerVo> findAll(@Param("model") SysResidentAnswerVo SysResidentAnswerVo, @Param("startRow") int startRow, @Param("pageSize") int pageSize);

	public long findCount(@Param("model") SysResidentAnswerVo SysResidentAnswerVo);


	@Select("select * from sys_resident_answer where phone=#{phone} or cardNo=#{phone} order by createTime desc")
	public SysResidentPo findPhone(@Param("phone") String phone);

	@Select("select * from sys_resident_answer where sysResidentId=#{sysResidentId} and type=#{type} and classes=#{classes}")
	public List<SysResidentAnswerVo1> findResidentId(@Param("sysResidentId") String sysResidentId, @Param("type") String type,@Param("classes") String classes);


    @Select("select * from sys_resident_answer where sysResidentId=#{sysResidentId} and type=#{type}")
    public List<SysResidentAnswerVo1> findResidentId1(@Param("sysResidentId") String sysResidentId, @Param("type") String type);


    @Select("select * from sys_resident_answer where sysResidentId=#{sysResidentId} and classes=#{classes} and state='10'")
	public List<SysResidentAnswerVo1> findResidentIdState(@Param("sysResidentId") String sysResidentId,@Param("classes") String classes);




	@Update("update sys_resident_answer set results =#{results},updateTime = now() where sysResidentId=#{sysResidentId} and type=#{type} and classes=#{classes}")
	public void updateAnswer(@Param("results") String results,@Param("sysResidentId") String sysResidentId,@Param("type") String type,@Param("classes") String classes);












}
