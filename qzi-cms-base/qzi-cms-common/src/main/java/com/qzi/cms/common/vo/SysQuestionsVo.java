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
 * 设备文件管理
 * @author qsy
 * @version v1.0
 * @date 2016年12月6日
 */
public class SysQuestionsVo {
	
	/**
	 * 主键编号	
	 * */
	@Id
	private String id;


	private String title;

	private String state;
	private Date createTime;
	private String sort;


	private String remark;


	private String classesId;

	private String classesId2;

	private String type;

	private String answer1;


	private String titleType;


	private String titleType1;


	private String solt;

	public String getSolt() {
		return solt;
	}

	public void setSolt(String solt) {
		this.solt = solt;
	}

	public String getTitleType1() {
		return titleType1;
	}

	public void setTitleType1(String titleType1) {
		this.titleType1 = titleType1;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private List<SysAnswerPo> answer;


	public List<SysAnswerPo> getAnswer() {
		return answer;
	}

	public void setAnswer(List<SysAnswerPo> answer) {
		this.answer = answer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getClassesId() {
		return classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

	public String getClassesId2() {
		return classesId2;
	}

	public void setClassesId2(String classesId2) {
		this.classesId2 = classesId2;
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
