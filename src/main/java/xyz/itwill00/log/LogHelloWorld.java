package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorld {
	private static final Logger logger= LoggerFactory.getLogger(LogHelloWorld.class);
	
	public String hello(String name) {
		logger.info("獣拙");
		String message= name+"還, ぞしぞしぞし";
		logger.info("魁");
		return message;
	}
}
