/* 
 * 文件名：BaseResourcePo.java  
 * 版权：Copyright 2016-2016 炎宝网络科技  All Rights Reserved by
 * 修改人：邱深友
 * 创建时间：2016年12月6日
 * 版本号：v1.0
*/
package com.qzi.cms.common.vo;

import com.qzi.cms.common.po.SysAnswerPo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 用户信息表
 * @author qsy
 * @version v1.0
 * @date 2016年12月6日
 */

public class SysResidentAnswerVo {
	
	/**
	 * 主键编号	
	 * */
	@Id
	private String id;


	private String name;


	private String message;
	private String type;

	private List<SysAnswerPo> answerList;

	private String remark;

	private String titleType;
	private String titleType1;

	private String userId;


	private String sysResidentId;

	private String classes;
	private String results;

	private String answerCount;
	private String state;
	private Date createTime;

	private String type1;
	private Date updateTime;

	private String phone;

	private String cardNo;

	private String loginName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSysResidentId() {
		return sysResidentId;
	}

	public void setSysResidentId(String sysResidentId) {
		this.sysResidentId = sysResidentId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getTitleType1() {
		return titleType1;
	}

	public void setTitleType1(String titleType1) {
		this.titleType1 = titleType1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SysAnswerPo> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<SysAnswerPo> answerList) {
		this.answerList = answerList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
