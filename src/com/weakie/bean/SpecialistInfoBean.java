package com.weakie.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class SpecialistInfoBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	
	private String userName;//关联的用户名
	
	private String name;	//姓名
	private boolean sex;	//性别true:woman;false:man
	private String birthday;//出生年月：2000-02
	private String email;	//邮箱
	private String contact;	//联系人及联系方式：John:18721992134;Kate:1990909201;
	@Deprecated
	private String photoPath;//照片使用userName代替
	private String organization;//工作单位
	private String website;		//单位网站
	private String role;		//担任职务	
	private String partTimeJob;	//社会兼职
	private String degree;		//最高学位，学历
	private String language;	//外语能力
	private String school;		//毕业院校
	private String workTime;	//从业时间
	private String experience;	//项目经历
	private String other;		//其他
	
	private int qualificationId;//执业职格：add
	private String qualification;//职业资格;show
	
	private int titleId;		//职称：add
	private String title;		//职称;show
	
	private int majorId;		//专业方向：add
	private String major;		//专业方向：建筑:公共建筑;show
	
	private int orgTypeId;		//单位性质：add
	private String orgType;		//单位性质 ：show
	
	private List<Integer> workPositionId;	//工作地点:add
	private String workPosition;//工作地点:浙江:杭州;浙江:温州;show
	
	private int state;			//状态
	
	public SpecialistInfoBean(){};
	
	public SpecialistInfoBean(String userName, String name, boolean sex,
			String birthday, String email, String contact, String organization,
			String website, String role, String partTimeJob, String degree,
			String language, String school, String workTime, String experience,
			String other, int qualificationId, int titleId, int majorId,
			int orgTypeId, List<Integer> workPositionId, int state) {
		super();
		this.userName = userName;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.contact = contact;
		this.organization = organization;
		this.website = website;
		this.role = role;
		this.partTimeJob = partTimeJob;
		this.degree = degree;
		this.language = language;
		this.school = school;
		this.workTime = workTime;
		this.experience = experience;
		this.other = other;
		this.qualificationId = qualificationId;
		this.titleId = titleId;
		this.majorId = majorId;
		this.orgTypeId = orgTypeId;
		this.workPositionId = workPositionId;
		this.state = state;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * birthday-year
	 * @return
	 */
	public String getYear(){
		if(StringUtils.isNotEmpty(this.birthday)){
			return this.birthday.split("-")[0];
		}
		return StringUtils.EMPTY;
	}
	/**
	 * birthday-month
	 * @return
	 */
	public String getMonth(){
		if(StringUtils.isNotEmpty(this.birthday)){
			return this.birthday.split("-")[1];
		}
		return StringUtils.EMPTY;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Map<String,String> getContactMap(){
		if(StringUtils.isEmpty(contact)){
			return Collections.emptyMap();
		}
		String[] contactsArray = contact.split(";");
		Map<String,String> contactMap = new HashMap<String,String>(contactsArray.length);
		for(String contact:contactsArray){
			String splits[] = contact.split(":");
			contactMap.put(splits[0], splits[1]);
		}
		return contactMap;
	}
	public void setContact(Map<String,String> contact){
		StringBuilder sb = new StringBuilder(50);
		for(String name:contact.keySet()){
			String method = contact.get(name);
			sb.append(name+":"+method+";");
		}
		this.setContact(sb.toString());
	}
	@Deprecated
	public String getPhotoPath() {
		return photoPath;
	}
	@Deprecated
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getOrgTypeId() {
		return orgTypeId;
	}
	public void setOrgTypeId(int orgTypeId) {
		this.orgTypeId = orgTypeId;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public List<Integer> getWorkPositionId() {
		if(this.workPositionId==null){
			return Collections.emptyList();
		}
		return workPositionId;
	}
	public void setWorkPositionId(List<Integer> workPositionId) {
		this.workPositionId = workPositionId;
	}
	public String getWorkPosition() {
		return workPosition;
	}
	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}
	public String getPartTimeJob() {
		return partTimeJob;
	}
	public void setPartTimeJob(String partTimeJob) {
		this.partTimeJob = partTimeJob;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public int getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "SpecialistInfoBean [userName=" + userName + ", name=" + name
				+ ", sex=" + sex + ", birthday=" + birthday + ", email="
				+ email + ", contact=" + contact + ", photoPath=" + photoPath
				+ ", organization=" + organization + ", website=" + website
				+ ", role=" + role + ", orgTypeId=" + orgTypeId + ", orgType="
				+ orgType + ", workPositionId=" + workPositionId
				+ ", workPosition=" + workPosition + ", partTimeJob="
				+ partTimeJob + ", degree=" + degree + ", language=" + language
				+ ", school=" + school + ", workTime=" + workTime
				+ ", qualificationId=" + qualificationId + ", qualification="
				+ qualification + ", titleId=" + titleId + ", title=" + title
				+ ", majorId=" + majorId + ", major=" + major + ", experience="
				+ experience + ", other=" + other + ", state=" + state + "]";
	}
	
	public Map<String, Object> getMapValues() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username_in", this.userName);
		map.put("name_in", this.name);
		map.put("sex_in", this.sex);
		map.put("birthday_in", this.birthday);
		map.put("email_in", email);
		map.put("contact_in", this.contact);
		map.put("organization_in", this.organization);
		map.put("website_in", this.website);
		map.put("role_in", this.role);
		map.put("part_time_job_in", partTimeJob);
		map.put("degree_in", this.degree);
		map.put("language_in", this.language);
		map.put("school_in", this.school);
		map.put("work_time_in", this.workTime);
		map.put("experience_in", experience);
		map.put("other_in", this.other);
		
		map.put("org_type_id_in", this.orgTypeId);
		map.put("qualification_id_in", this.qualificationId);
		map.put("title_id_in", this.titleId);
		map.put("major_id_in", this.majorId);
		map.put("state_in", this.state);
		
		return map;
	}
}
