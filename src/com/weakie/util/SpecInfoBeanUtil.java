package com.weakie.util;

import org.apache.commons.lang3.StringUtils;

import com.weakie.bean.SpecialistInfoBean;

/**
 * 主要用来做zpecialistInfoBean的显示，字段检测
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年5月19日下午11:24:51
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
		return    "  <b>【姓名】</b>：" + convertToHTML(bean.getName())
				+ "， <b>【性别】</b>：" + (bean.isSex()?"女":"男") 
				+ "， <b>【出生年月】</b>：" + convertToHTML(bean.getBirthday())
				+ "， <b>【邮箱】</b>：" + convertToHTML(bean.getEmail())
				+ "<br> <b>【联系方式】</b>：" + convertToHTML(bean.getContact()) 
				
				+ "<br> <b>【工作单位】</b>：" + convertToHTML(bean.getOrganization())
				+ "<br> <b>【单位网址】</b>：<a target=\"_blank\" href=\"" + bean.getWebsite()+"\">"+ convertToHTML(bean.getWebsite()) +"</a>"
				+ "<br> <b>【职务】</b>：" + convertToHTML(bean.getRole())
				+ "， <b>【单位性质】</b>：" + convertToHTML(bean.getOrgType())
				+ "， <b>【工作地点】</b>：" + convertToHTML(bean.getWorkPosition())
				
				+ "<br> <b>【社会兼职】</b>：" + convertToHTML(bean.getPartTimeJob())
				
				+ "<br> <b>【学位、学历】</b>：" + convertToHTML(bean.getDegree())
				+ "<b>【外语能力】</b>：" + convertToHTML(bean.getLanguage())
				+ "， <b>【毕业院校】</b>：" + convertToHTML(bean.getSchool())
				+ "， <b>【从业时间】</b>：" + convertToHTML(bean.getWorkTime())
				+ "， <b>【职业资格】</b>：" + convertToHTML(bean.getQualification())
				+ "， <b>【职称】</b>：" + convertToHTML(bean.getTitle())
				
				+ "<br> <b>【专业方向】</b>：" + convertToHTML(bean.getMajor()) 
				+ "<br> <b>【科研经历获奖情况】</b>：" + convertToHTML(bean.getExperience())
				+ "<br> <b>【其他】</b>：" + convertToHTML(bean.getOther());
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
