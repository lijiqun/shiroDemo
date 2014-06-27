package cn.ssms.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
	author:lijiqun
	date:2014年6月21日 上午10:00:11 
 */
public class LogUtil {
	private static Logger sohoLogger = LoggerFactory.getLogger(LogUtil.class);

	public static Logger getSohoLogger() {
		return sohoLogger;
	}

	public static void setSohoLogger(Logger sohoLogger) {
		LogUtil.sohoLogger = sohoLogger;
	}
	
	
}
