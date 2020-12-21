/* 
 * 文件名：SysParameterMapper.java  
 * 版权：Copyright 2016-2017 炎宝网络科技  All Rights Reserved by
 * 修改人：邱深友  
 * 创建时间：2017年6月15日
 * 版本号：v1.0
*/
package com.qzi.cms.server.mapper;

import com.qzi.cms.common.po.SysClassesPo;
import com.qzi.cms.common.po.SysQuestionsPo;
import com.qzi.cms.common.vo.SysQuestionsVo;
import com.qzi.cms.server.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 设置file
 * @author qsy
 * @version v1.0
 * @date 2017年6月15日
 */
public interface SysQuestionsMapper extends BaseMapper<SysQuestionsPo>{







	public List<SysQuestionsVo> findAll1(@Param("model") SysQuestionsPo sysQuestionsPo, @Param("startRow") int startRow, @Param("pageSize") int pageSize);

	public long findCount1(@Param("model") SysQuestionsPo sysQuestionsPo);






	/**
	 *
	 * @return
	 */

	@Select("select * from sys_questions where state='10'  order by  CAST(sort AS SIGNED)")
	public List<SysQuestionsVo> findList();



	@Select("select * from sys_questions where id=#{id} limit 1")
	public SysQuestionsVo findone(@Param("id") String id);



	@Select("select * from sys_classes where state='10' and level='1'  order by  CAST(sort AS SIGNED)")
	public List<SysClassesPo> findLevelOne();


	@Select("select * from sys_classes where state='10' and level='1' and  parentId = #{parentId} order by  CAST(sort AS SIGNED)")
	public List<SysClassesPo> findLevelTwo(@Param("parentId") String parentId);



	@Select("select * from sys_questions where state='10' and (type=#{type} or type='30') and solt=#{solt} order by  CAST(sort AS SIGNED)")
	public List<SysQuestionsVo> appFindAll(@Param("type") String  type,@Param("solt") String  solt);


	@Select("select * from sys_questions where state='10' and type=#{type} and solt=#{solt} order by  CAST(sort AS SIGNED)")
	public List<SysQuestionsVo> appFindAll2(@Param("type") String  type,@Param("solt") String  solt);



}
