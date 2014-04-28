package com.weakie.bean;

import java.util.List;
import java.util.Map;

public class SpecialistInfoBean {

	private String userName;//�������û���
	
	private String name;	//����
	private boolean sex;	//�Ա�true:woman;false:man
	private String birthday;//�������£�2000-02
	private String email;	//����
	private String contact;	//��ϵ�˼���ϵ��ʽ��John:18721992134;Kate:1990909201;
	private String photoPath;//��Ƭ
	
	private String organization;//������λ
	private String website;		//��λ��վ
	private String role;		//����ְ��
	
	private int orgTypeId;		//��λ���ʣ�add
	private String orgType;		//��λ���� ��show
	
	private List<Integer> workPositionId;	//�����ص�:add
	private String workPosition;//�����ص�:�㽭:����;�㽭:����:show
	
	private String partTimeJob;	//����ְ
	private String degree;		//���ѧλ��ѧ��
	private String language;	//��������
	private String school;		//��ҵԺУ
	private String workTime;	//��ҵʱ��
	
	private int qualificationId;//ִҵְ��add
	private String qualification;//ְҵ�ʸ�:show
	
	private int titleId;		//ְ�ƣ�add
	private String title;		//ְ�ƣ�show
	
	private int majorId;		//רҵ����add
	private String major;		//רҵ���򣺽���������������show
	
	private String experience;	//��Ŀ����
	private String other;		//����
	
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
	public void setContact(Map<String,String> contact){
		StringBuilder sb = new StringBuilder(50);
		for(String name:contact.keySet()){
			String method = contact.get(name);
			sb.append(name+":"+method+";");
		}
		this.setContact(sb.toString());
	}
	public String getPhotoPath() {
		return photoPath;
	}
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
				+ experience + ", other=" + other + "]";
	}
	
}
