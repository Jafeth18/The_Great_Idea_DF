package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AuthorPage extends BasePage{
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='org.benetech.secureapp.CECBJGGGJ.BEGBHJBBAFFEE:id/button']")
	private AndroidElement btnCreateRecord;
	
	public AuthorPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	public CreateRecordPage tapOnCreateRecord(){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id='org.benetech.secureapp.CECBJGGGJ.BEGBHJBBAFFEE:id/button']")));
		
		clickOnElement(btnCreateRecord);
		
		return new CreateRecordPage(driver);
	}

}
