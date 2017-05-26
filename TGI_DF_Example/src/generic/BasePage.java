package generic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import util.ConfigurationManager;

public class BasePage {

	protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected static AppiumDriver staticDriver;


	public BasePage(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, ConfigurationManager.returnTimeOut());

	}

	protected boolean clickOnElement(AndroidElement androidElement){
		boolean result;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(androidElement));
			androidElement.click();
			result=true;
		} catch (Exception e){
			result=false;
		}
		return result;
	}

	protected boolean typeOnElementos(AndroidElement androidElement, String text){
		boolean result;
		try {
			TouchAction action = new TouchAction(driver);
			wait.until(ExpectedConditions.visibilityOf(androidElement));
			action.tap(androidElement).release().perform();
			
			driver.getKeyboard().pressKey(text);
			//driver.getKeyboard().sendKeys(text);
			driver.hideKeyboard();
			
			result=true;
		} catch (Exception e){
			result=false;
		}
		return result;
	}
	
	protected boolean typeOnElementosa(final AndroidElement androidElement, String text){
		try
		  {
		   wait.until(new ExpectedCondition<Boolean>()
		   {
		    public Boolean apply(WebDriver arg0)
		    {
		     return androidElement.isEnabled();
		    }
		   });
		   androidElement.clear();
		   androidElement.sendKeys(text);
		   return true;
		  }
		  catch (Exception e)
		  {
		   return false;
		  }
	}
	/////////////////////////////////////////////////////////////////////
	protected boolean adbType(String text)
	 {
	  try
	  {
		  String str = text;
		  str = str.replaceAll("\\s+", "%s" );
		  
	   return null != runProcess(true, "adb shell input text \"" + str + "\"") && hideKeyboard();
	   
	  }
	  catch (Exception e)
	  {
	   return false;
	  }
	 }
	
	private boolean hideKeyboard(){
		try{
			driver.hideKeyboard();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	 private static <T> T[] concat(T[] first, T[] second)
	 {
	  T[] result = Arrays.copyOf(first, first.length + second.length);
	  System.arraycopy(second, 0, result, first.length, second.length);
	  return result;
	 }

	 private static final String[] WIN_RUNTIME      = {"cmd.exe", "/C"};
	 private static final String[] OS_LINUX_RUNTIME = {"/bin/bash", "-l", "-c"};

	 public static List<String> runProcess(boolean isWin, String... command)
	 {
	  System.out.print("command to run: ");
	  for (String s : command)
	  {
	   System.out.print(s);
	  }
	  System.out.print("\n");
	  String[] allCommand = null;
	  try
	  {
	   if (isWin)
	   {
	    allCommand = concat(WIN_RUNTIME, command);
	   }
	   else
	   {
	    allCommand = concat(OS_LINUX_RUNTIME, command);
	   }
	   ProcessBuilder pb = new ProcessBuilder(allCommand);
	   pb.redirectErrorStream(true);
	   Process p = pb.start();
	   p.waitFor();
	   BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	   String _temp = null;
	   List<String> line = new ArrayList<String>();
	   while ((_temp = in.readLine()) != null)
	   {
	    System.out.println("temp line: " + _temp);
	    line.add(_temp);
	   }
	   System.out.println("result after command: " + line);
	   return line;
	  }
	  catch (Exception e)
	  {
	   e.printStackTrace();
	   return null;
	  }
	 }
	 

}
