package com.weakie.bean;

public class KeyValuePair implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Object key;
	private Object value;
	
	public KeyValuePair() {
		super();
	}
	public KeyValuePair(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
