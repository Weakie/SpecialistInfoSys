package com.weakie.util.log;

import org.junit.Test;

public class LogUtilTest {

	@Test
	public void test() {
		LogUtil.info("info");
		LogUtil.info(new Exception("info"));
		LogUtil.error("error");
		LogUtil.error(new Exception("error"));
		
		LogUtil.debug("debug");
		LogUtil.debug(new Exception("debug"));
		LogUtil.warn("warn");
		LogUtil.warn(new Exception("warn"));
	}

}
