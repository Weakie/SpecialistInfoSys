package com.weakie.bean;

public class KeyValuePair {

	private Integer key;
	private Object value;
	
	public KeyValuePair() {
		super();
	}
	public KeyValuePair(Integer key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
