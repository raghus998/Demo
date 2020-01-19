package demoerror;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;



public class Demo 
{
	static Logger log = LogManager.getLogger(Demo.class.getName());
	@Test
	public void testA()
	{
		log.info("This is ingo log");
		log.error("Error log");
		log.fatal("fatal log");
		log.debug("debug log");
		log.warn("warn log");
		log.trace("trace log");
	}

}
