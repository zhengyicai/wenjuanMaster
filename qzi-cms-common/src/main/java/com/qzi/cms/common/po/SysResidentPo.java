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
 * 用户信息表
 * @author qsy
 * @version v1.0
 * @date 2016年12月6日
 */
@Table(name="sys_resident")
public class SysResidentPo {
	
	/**
	 * 主键编号	
	 * */
	@Id
	private String id;
	private String name;
	private String phone;
	private String address;
	private String sex;
	private String age;
	private String cardNo;
	private String nation;
	private String height1;
	private String weight1;
	private String vocation;
	private String record;
	private String state;
	private Date createTime;
	private String remark;
	private String type;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getHeight1() {
		return height1;
	}

	public void setHeight1(String height1) {
		this.height1 = height1;
	}

	public String getWeight1() {
		return weight1;
	}

	public void setWeight1(String weight1) {
		this.weight1 = weight1;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
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
}
