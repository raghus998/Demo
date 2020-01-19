package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class Demo
{
	Logger log = LogManager.getLogger(Demo.class.getName());
	@Test
	public void testA()
	{
		log.info("Info log");
		log.fatal("Fatal log");
		log.debug("debug log");
		log.error("error log");
		log.warn("warn log");
		log.trace("trace log");
	}

}
