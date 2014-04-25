package com.weakie.initialize;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import com.weakie.global.SpringBeanUtil;
import com.weakie.listener.SocketDispatcher;
import com.weakie.util.log.LogUtil;

public class Initialize {
	private static Initialize instance;
	private ExecutorService executor;
	private SocketDispatcher dispatcher;
	
	public Initialize(){};
	
	public static Initialize getInstance(){
		//get the object from spring framework, avoid get it twice.
		if(instance == null){
			synchronized(Initialize.class){
				if(instance == null){
					instance = (Initialize) SpringBeanUtil.getBeans("initialize");
				}
			}
		}
		return instance;
	}
	
	public void startup() throws IOException{
		this.dispatcher.initialize(10031);
		this.executor.execute(dispatcher);
		LogUtil.info("startup ");
	}
	
	public void shutdown() throws IOException{
		this.dispatcher.destroy();
		this.executor.shutdown();
		LogUtil.info("shutdown ");
	}
	
	public SocketDispatcher getDispatcher() {
		return dispatcher;
	}
	public void setDispatcher(SocketDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService excutor) {
		this.executor = excutor;
	}
	
}
