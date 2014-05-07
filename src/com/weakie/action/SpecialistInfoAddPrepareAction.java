package com.weakie.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.SpecialistInfoBean;
import com.weakie.service.SelectionService;
import com.weakie.service.SpecialistInfoService;
import com.weakie.util.log.LogUtil;

public class SpecialistInfoAddPrepareAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private String userName;
   
    //for prepare-add
    private Map<Integer,String> orgTypeMap;
    private Map<Integer,String> qualificationMap;
    private Map<Integer,String> titleMap;
    //update-add
    private Map<Integer,String> provinceMap;//��specinfo��Ϊnull,���ⲿ������Ϊ��Ӧ�ĵ�һ���������ڵĹ�����ѡ���µ�province
    private Map<Integer,String> cityMap;	//��specinfo��Ϊnull,���ⲿ������Ϊ��Ӧ�ĵ�һ���������ڵ�province�µĳ���
    private Map<Integer,String> majorClassMap;
    private Map<Integer,String> majorMap;	//��specinfo��Ϊnull,���ⲿ������Ϊ��Ӧרҵ������majorClass�µ�����רҵ
    //for prepare-update
    private SpecialistInfoBean specInfoBean;
    private int contactNum=1;
    private int workPosNum=1;
    private int majorClassId=0;
    
    private Map<Integer,Boolean> proAbroMap;//specInfoBean��citylist��provid���Ƿ���ڵ�ӳ��
    private Map<Integer,Integer> cityProMap;//specInfoBean��citylist��cityid��provid��ӳ��
    private Map<Integer,String> cityNameMap;//���ֺ�id��ӳ�䣺disabled��select����ʾ
    private Map<Integer,String> provNameMap;//���ֺ�id��ӳ�䣺disabled��select����ʾ
    
   
    //service
    private SpecialistInfoService specInfoService;
    private SelectionService selectService;
    /**
     * ����û���,�����û���׼������,�������ݿ��ж���ר����Ϣ(����еĻ���
     * @return
     * @throws Exception
     */
    public String executePrepare() {
    	LogUtil.debug("prepare action.");

    	this.orgTypeMap = this.selectService.getOrgType();
        this.qualificationMap = this.selectService.getQualification();
        this.titleMap = this.selectService.getTitle();
        
    	this.specInfoBean = this.specInfoService.getSpecialistInfoByUsername(userName);
    	if(specInfoBean!=null){
    		LogUtil.info("bean is not null: "+userName+", update info.");
    		this.contactNum = this.specInfoBean.getContactMap().size()==0? 1 : this.specInfoBean.getContactMap().size();
	    	this.workPosNum = this.specInfoBean.getWorkPositionId().size()==0? 1 : this.specInfoBean.getWorkPositionId().size();
	    	
	    	//
	    	if(specInfoBean.getWorkPositionId().size() != 0){
		    	this.cityProMap = this.selectService.getCityProvinceMap(this.specInfoBean.getWorkPositionId());		//���ݳ��л�ó���-ʡӳ��
		    	this.proAbroMap = this.selectService.getProvinceAbroadMap(new ArrayList<Integer>(this.cityProMap.values()));//����ʡ���ʡ-������ӳ��
		    	//��ȡ��Ӧ����
		    	this.cityNameMap = this.selectService.getCityNameMap(this.specInfoBean.getWorkPositionId());
		    	this.provNameMap = this.selectService.getProvNameMap(this.specInfoBean.getWorkPositionId());
		    	
		    	int cityId = 0;
		    	try{
		    		cityId = this.specInfoBean.getWorkPositionId().get(0);
		    	}catch(java.lang.NullPointerException e){
		    		LogUtil.error(e);
		    	}
		    	int firstProvinceId = this.cityProMap.get(cityId);
		    	LogUtil.debug("first cityid: " + cityId +" ,provinceid: "+firstProvinceId+" , "+this.provNameMap.get(firstProvinceId));
		    	//����ȡֵӦ����specialistInfoBean��ֵ�й�
		    	this.provinceMap = this.selectService.getProvince(this.proAbroMap.get(firstProvinceId));
		        this.cityMap = this.selectService.getCity(firstProvinceId);
	    	}else{
	    		LogUtil.info("work position id is not initialized");
		    	this.provinceMap = this.selectService.getProvince(false);
		    	//�������Ӧ����provinceMap��һ��ֵ��Ӧ�������й�
		    	int firstProvinceId = this.provinceMap.keySet().iterator().next();
		        this.cityMap = this.selectService.getCity(firstProvinceId);
	    	}
	    	
	    	//
	    	Object id = this.selectService.getMajorClassIdByMajorId(this.specInfoBean.getMajorId());	//����רҵ���רҵ����id
	    	if(id != null){
		    	this.majorClassId = (Integer)id;
		        this.majorClassMap = this.selectService.getMajorClass();
		        this.majorMap = this.selectService.getMajor(this.majorClassId);
	    	}else{
	    		LogUtil.info("major id is not initialized");
	    		this.majorClassMap = this.selectService.getMajorClass();
	 	        //�������Ӧ����majorClassMap��һ��ֵ��Ӧ�������й�
	 	        int firstMajorId = (this.majorClassMap.keySet().iterator().hasNext()?this.majorClassMap.keySet().iterator().next():2);
	 	        this.majorMap = this.selectService.getMajor(firstMajorId);
	    	}
    	}else{
    		LogUtil.info("bean is not initialized: "+userName+", add info.");
    		
    		//
	    	this.provinceMap = this.selectService.getProvince(false);
	    	//�������Ӧ����provinceMap��һ��ֵ��Ӧ�������й�
	    	int firstProvinceId = this.provinceMap.keySet().iterator().next();
	        this.cityMap = this.selectService.getCity(firstProvinceId);
	        LogUtil.debug("firstprovinceId: "+firstProvinceId);
	        //
	        this.majorClassMap = this.selectService.getMajorClass();
	        //�������Ӧ����majorClassMap��һ��ֵ��Ӧ�������й�
	        int firstMajorId = (this.majorClassMap.keySet().iterator().hasNext()?this.majorClassMap.keySet().iterator().next():2);
	        this.majorMap = this.selectService.getMajor(firstMajorId);
	        LogUtil.debug("firstMajorId: "+firstMajorId);
    	}
        return SUCCESS;
    }
    
	
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Map<Integer, String> getOrgTypeMap() {
		return orgTypeMap;
	}

	public Map<Integer, String> getProvinceMap() {
		return provinceMap;
	}

	public Map<Integer, String> getCityMap() {
		return cityMap;
	}

	public Map<Integer, String> getQualificationMap() {
		return qualificationMap;
	}

	public Map<Integer, String> getTitleMap() {
		return titleMap;
	}

	public Map<Integer, String> getMajorClassMap() {
		return majorClassMap;
	}

	public Map<Integer, String> getMajorMap() {
		return majorMap;
	}

	public SpecialistInfoBean getSpecInfoBean() {
		return specInfoBean;
	}

	public int getContactNum() {
		return contactNum;
	}

	public int getMajorClassId() {
		return majorClassId;
	}

	public int getWorkPosNum() {
		return workPosNum;
	}

	public Map<Integer, Boolean> getProAbroMap() {
		return proAbroMap;
	}

	public Map<Integer, Integer> getCityProMap() {
		return cityProMap;
	}

	public Map<Integer, String> getCityNameMap() {
		return cityNameMap;
	}

	public Map<Integer, String> getProvNameMap() {
		return provNameMap;
	}

	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}

	public void setSelectService(SelectionService selectService) {
		this.selectService = selectService;
	}

}