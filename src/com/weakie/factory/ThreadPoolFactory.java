package com.weakie.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolFactory {

	//private static ThreadPoolFactory instance = new ThreadPoolFactory();
	
	//private ThreadPoolFactory(){}
	/*
	public static ThreadPoolFactory getInstance(int i){
		return instance;
	}
	*/
	
	public ExecutorService newFixedThreadPool(int poolSize){
		return Executors.newFixedThreadPool(poolSize);
	}
}
