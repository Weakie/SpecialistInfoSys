package com.weakie.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 信息申请Bean
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年5月2日下午7:26:58
 */
public class ApplyInfo implements java.io.Serializable, Comparable<ApplyInfo>{
	private static SimpleDateFormat dateformatYear = new SimpleDateFormat("yyyy/MM/dd"); 
	private static SimpleDateFormat dateformatDate = new SimpleDateFormat("M月d日");
	private static SimpleDateFormat dateformatTime = new SimpleDateFormat("a hh:mm");

	private Date today = new Date();
	
	private static final long serialVersionUID = 1L;
	
	private int id;         //1000000
	private String userName;//专家用户名
	private String specName;//专家姓名
	private Date applyTime;
	private Date acceptTime;
	private Date disposeTime;
	private int status;
	private String staffID;
	private String comment;
	
	public ApplyInfo(){}
	
	/**
	 * insert  into DB
	 * @param userName
	 * @param specName
	 * @param applyTime
	 */
	public ApplyInfo(String userName, String specName, Date applyTime, String comment) {
		this.userName = userName;
		this.specName = specName;
		this.applyTime = applyTime;
		this.comment = comment;
	}
	
	public ApplyInfo(int id, String userName, String specName, Date applyTime,
			Date acceptTime, Date disposeTime, int status, String staffID) {
		super();
		this.id = id;
		this.userName = userName;
		this.specName = specName;
		this.applyTime = applyTime;
		this.acceptTime = acceptTime;
		this.disposeTime = disposeTime;
		this.status = status;
		this.staffID = staffID;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	@SuppressWarnings("deprecation")
	public String getApplyTimeString(){
		if(this.applyTime == null){
			return StringUtils.EMPTY;
		}
		if(applyTime.getYear()!=today.getYear()){
			return dateformatYear.format(applyTime);
		}else if(applyTime.getDate()!=today.getDate()){
			return dateformatDate.format(applyTime);
		}
		return dateformatTime.format(applyTime);
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	@SuppressWarnings("deprecation")
	public String getAcceptTimeString(){
		if(this.acceptTime == null){
			return StringUtils.EMPTY;
		}
		if(acceptTime.getYear()!=today.getYear()){
			return dateformatYear.format(acceptTime);
		}else if(acceptTime.getDate()!=today.getDate()){
			return dateformatDate.format(acceptTime);
		}
		return dateformatTime.format(acceptTime);
	}
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	@SuppressWarnings("deprecation")
	public String getDisposeTimeString(){
		if(this.disposeTime == null){
			return StringUtils.EMPTY;
		}
		if(disposeTime.getYear()!=today.getYear()){
			return dateformatYear.format(disposeTime);
		}else if(disposeTime.getDate()!=today.getDate()){
			return dateformatDate.format(disposeTime);
		}
		return dateformatTime.format(disposeTime);
	}
	public Date getDisposeTime() {
		return disposeTime;
	}
	public void setDisposeTime(Date disposeTime) {
		this.disposeTime = disposeTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
	@Override
	public int compareTo(ApplyInfo o) {
		//new 状态的在先
		/*if(this.status<o.status){
			return -1;
		}else if(this.status>o.status){
			return 1;
		}*/
		//然后按申请时间排序（id）
		if(this.id>o.id){
			return -1;
		}else if(this.id < o.id){
			return 1;
		}
		return 0;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ApplyInfo [id=" + id + ", userName=" + userName + ", specName="
				+ specName + ", applyTime=" + applyTime + ", acceptTime="
				+ acceptTime + ", disposeTime=" + disposeTime + ", status="
				+ status + ", staffID=" + staffID + ", comment=" + comment
				+ "]";
	}
}
