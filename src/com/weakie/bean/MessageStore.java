package com.weakie.bean;

public class MessageStore {
    
    private String message;
    
    public MessageStore(){}
    
    public MessageStore(String message) {
         
        this.message = message;
    }
 
    public String getMessage() {
 
        return message;
    }
 
    public void setMessage(String message) {
 
        this.message = message;
    }
 
}