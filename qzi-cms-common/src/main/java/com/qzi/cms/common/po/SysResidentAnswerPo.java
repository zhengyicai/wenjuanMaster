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
 * 用户问卷表
 * @author qsy
 * @version v1.0
 * @date 2016年12月6日
 */
@Table(name="sys_resident_answer")
public class SysResidentAnswerPo {
	
	/**
	 * 主键编号	
	 * */
	@Id
	private String id;
	private String sysResidentId;
	private String type;
	private String classes;
	private String results;

	private String answerCount;
	private String state;
	private Date createTime;
	private String remark;
	private String type1;
	private Date updateTime;

	private String phone;
	private String name;
	private String cardNo;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSysResidentId() {
		return sysResidentId;
	}

	public void setSysResidentId(String sysResidentId) {
		this.sysResidentId = sysResidentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(String answerCount) {
		this.answerCount = answerCount;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
