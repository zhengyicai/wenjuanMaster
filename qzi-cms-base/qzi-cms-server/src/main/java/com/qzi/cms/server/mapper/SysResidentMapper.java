/* 
 * 文件名：SysParameterMapper.java  
 * 版权：Copyright 2016-2017 炎宝网络科技  All Rights Reserved by
 * 修改人：邱深友  
 * 创建时间：2017年6月15日
 * 版本号：v1.0
*/
package com.qzi.cms.server.mapper;

import com.qzi.cms.common.po.SysFileUrlPo;
import com.qzi.cms.common.po.SysResidentPo;
import com.qzi.cms.common.vo.SysFileUrlVo;
import com.qzi.cms.common.vo.SysResidentVo;
import com.qzi.cms.server.base.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 文件管理DAO
 * @author qsy
 * @version v1.0
 * @date 2017年6月15日
 */
public interface SysResidentMapper extends BaseMapper<SysResidentPo>{


	public List<SysResidentVo> findAll(@Param("model") SysResidentPo sysResidentPo, @Param("startRow") int startRow, @Param("pageSize") int pageSize);

	public long findCount(@Param("model") SysResidentPo sysResidentPo);


	@Select("select r.*,u.loginName from sys_resident r left join sys_user u on r.userId = u.id where r.phone=#{phone} or r.cardNo=#{phone} order by r.createTime desc")
	public SysResidentVo findPhone(@Param("phone") String  phone);



	@Select("select * from sys_resident where id=#{id}")
	public SysResidentPo findOne(@Param("id") String  id);













}
