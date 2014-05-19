package com.weakie.util;

import org.apache.commons.lang3.StringUtils;

import com.weakie.bean.SpecialistInfoBean;

/**
 * ��Ҫ������zpecialistInfoBean����ʾ���ֶμ��
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��5��19������11:24:51
 */
public class SpecInfoBeanUtil {

	private SpecialistInfoBean bean;
	private String[] searchWords;
	
	public SpecInfoBeanUtil(SpecialistInfoBean bean) {
		this.bean = bean;
	}
	public SpecInfoBeanUtil(SpecialistInfoBean bean,String[] searchWords) {
		this.bean = bean;
		this.searchWords = searchWords;
	}
	public String getUserName(){
		return bean.getUserName();
	}
	public String getName(){
		return bean.getName();
	}
	public String getInfoString(){
		return    "  <b>��������</b>��" + convertToHTML(bean.getName())
				+ "�� <b>���Ա�</b>��" + (bean.isSex()?"Ů":"��") 
				+ "�� <b>���������¡�</b>��" + convertToHTML(bean.getBirthday())
				+ "�� <b>�����䡿</b>��" + convertToHTML(bean.getEmail())
				+ "<br> <b>����ϵ��ʽ��</b>��" + convertToHTML(bean.getContact()) 
				
				+ "<br> <b>��������λ��</b>��" + convertToHTML(bean.getOrganization())
				+ "<br> <b>����λ��ַ��</b>��<a target=\"_blank\" href=\"" + bean.getWebsite()+"\">"+ convertToHTML(bean.getWebsite()) +"</a>"
				+ "<br> <b>��ְ��</b>��" + convertToHTML(bean.getRole())
				+ "�� <b>����λ���ʡ�</b>��" + convertToHTML(bean.getOrgType())
				+ "�� <b>�������ص㡿</b>��" + convertToHTML(bean.getWorkPosition())
				
				+ "<br> <b>������ְ��</b>��" + convertToHTML(bean.getPartTimeJob())
				
				+ "<br> <b>��ѧλ��ѧ����</b>��" + convertToHTML(bean.getDegree())
				+ "<b>������������</b>��" + convertToHTML(bean.getLanguage())
				+ "�� <b>����ҵԺУ��</b>��" + convertToHTML(bean.getSchool())
				+ "�� <b>����ҵʱ�䡿</b>��" + convertToHTML(bean.getWorkTime())
				+ "�� <b>��ְҵ�ʸ�</b>��" + convertToHTML(bean.getQualification())
				+ "�� <b>��ְ�ơ�</b>��" + convertToHTML(bean.getTitle())
				
				+ "<br> <b>��רҵ����</b>��" + convertToHTML(bean.getMajor()) 
				+ "<br> <b>�����о����������</b>��" + convertToHTML(bean.getExperience())
				+ "<br> <b>��������</b>��" + convertToHTML(bean.getOther());
	}
	
	private String convertToHTML(String source){
		if(this.searchWords==null){
			return source;
		}
		//replace
		for(String s:searchWords){
			if(StringUtils.contains(source, s)){
				return StringUtils.replace(source, s, "<font color=\"red\">"+s+"</font>");
			}
		}
		return source;
	}

}
