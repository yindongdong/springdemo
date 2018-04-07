package com.winter.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSONObject;

@Table(name = "t_user_info")
@Entity
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3848048205078560098L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;// 自增ID

	@Column(name = "create_time", updatable = false)
	private long createTime;// 记录创建时间

	@Column(name = "record_status")
	private int recordStatus;// 记录有效性，1为有效，0为无效

	@Column(name = "modify_time", updatable = false)
	private Date modifyTime;// 最近更新时间

	@Column(name = "user_account")
	private String userAccount;// 用户账号

	@Column(name = "user_name")
	private String userName;// 用户姓名

	@Column(name = "mobile")
	private String mobile;// 手机号码

	@Column(name = "status")
	private String status;// 用户状态

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public int getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
