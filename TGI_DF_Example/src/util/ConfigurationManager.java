package util;

import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class ConfigurationManager {
	
	private static final String EXECUTION_MODE_KEY="executionMode";
	private static final String BROWSER_KEY="browser";
	private static final String GRID_IP_KEY="GridHubIP";
	private static final String TIMEOUT_KEY="timeOut";
	private static final String TESTRAIL_MODE="testRailIntegrationMode";
	private static final String TESTRAIL_MODE_ON="ON";
	private static final String TESTRAIL_MODE_OFF="OFF";
	private static final String THREAD_SLEEP_ENABLED="sleepEnabled";
	private static final String THREAD_SLEEP_TIMEOUT="sleepTime";
	private static final String DRIVER_PATH="driverPath";
	
	public static XmlSuite suite;
	

	public static void createManager(ITestContext context){
		try {
			suite = context.getSuite().getXmlSuite();
		} catch (Exception e) {
		}
	}
	
	public static String returnExecutionMode(){
		return suite.getParameter(EXECUTION_MODE_KEY);
	}

	public static String returnBrowser(){
		return suite.getParameter(BROWSER_KEY);
	}

	public static String returnGridIP(){
		return suite.getParameter(GRID_IP_KEY);
	}
	
	public static long returnTimeOut(){
		String timeout=suite.getParameter(TIMEOUT_KEY);
		
		if (timeout != null){
			return Long.valueOf(timeout);	
		}
		return 0;
		
	}
	public static String returnConfigurationValue(String configurationKey){
		return suite.getParameter(configurationKey);
	}
	
	public static boolean getTestRailIntegrationMode(){
		boolean testrailMode=false;
		String mode = suite.getParameter(TESTRAIL_MODE).toLowerCase();
		
		if(mode.equals(TESTRAIL_MODE_ON)){
			testrailMode=true;
		}else if (mode.equals(TESTRAIL_MODE_OFF)){
			testrailMode=false;
		}
		return testrailMode;
	}
	
	public static boolean getSleepMode(){
		return Boolean.valueOf(suite.getParameter(THREAD_SLEEP_ENABLED));
	}
	
	public static long getTimeout(){
		long timeOut = Long.valueOf(suite.getParameter(THREAD_SLEEP_TIMEOUT));
		return timeOut;
	}
	
	public static String getDriverPath(){
		return suite.getParameter(DRIVER_PATH);
	}
}
