package com.qzi.cms.common.vo;

import java.util.Date;
import java.util.List;

public class SysResidentAnswerVo1 {


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
    private List<SysResidentAnswerVo> answerList;

    public List<SysResidentAnswerVo> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<SysResidentAnswerVo> answerList) {
        this.answerList = answerList;
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
}
