package com.weakie.constant;

public class ApplyConstant {

	public static final String APPLY_NEW="NEW";
	public static final String APPLY_OVERTIME="OVERTIME";
	public static final String APPLY_ACCEPTED="ACCEPT";
	public static final String APPLY_DISPOSED="DISPOSED";
	
	public static final int STATUS_ALL=0;//状态只用来查询所有的时候使用
	
	public static final int STATUS_NEW=1;//状态为以下几个,数据库中只有这些
	public static final int STATUS_OVERTIME=2;
	public static final int STATUS_ACCEPTED=3;
	public static final int STATUS_DISPOSED=4;
	
	public static final int PAGE_NUMS=50;
}
