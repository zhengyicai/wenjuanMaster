/* 
 * 文件名：BaseResourcePo.java  
 * 版权：Copyright 2016-2016 炎宝网络科技  All Rights Reserved by
 * 修改人：邱深友
 * 创建时间：2016年12月6日
 * 版本号：v1.0
*/
package com.qzi.cms.common.po;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 设备文件管理
 * @author qsy
 * @version v1.0
 * @date 2016年12月6日
 */
@Table(name="sys_answer")
public class SysAnswerPo {
	
	/**
	 * 主键编号	
	 * */
	@Id
	private String id;


	private String answer;

	private String state;
	private Date createTime;
	private String sort;


	private String remark;
	private String sysQuestionsId;


	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSysQuestionsId() {
		return sysQuestionsId;
	}

	public void setSysQuestionsId(String sysQuestionsId) {
		this.sysQuestionsId = sysQuestionsId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
