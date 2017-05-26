package pages;

import java.awt.Dimension;
import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import generic.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MasterPage extends BasePage{

	org.openqa.selenium.Dimension winSize;
	
	public MasterPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Number questions
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']//android.widget.EditText")
	private AndroidElement txtNCharacters;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='3']//android.widget.EditText")
	private AndroidElement txtNPeople;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='5']//android.widget.EditText")
	private AndroidElement txtAge;
	
	@AndroidFindBy(id="title")
	private AndroidElement msgRemoveResponse;
	
	@AndroidFindBy(id="button2")
	private AndroidElement btnCancel;
	
	//Radio questions
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='0']//android.widget.RadioButton")
	private AndroidElement rbFemale;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']//android.widget.RadioButton")
	private AndroidElement rbMale;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='2']//android.widget.RadioButton")
	private AndroidElement rbOther;
	
	//Date questions
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']//android.widget.Button") 
	private AndroidElement btnToday;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='android:id/pickers']") 
	private AndroidElement calendar;
	
	//List AndroidElement list 
	
	
	//Text questions
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']//android.widget.EditText")
	private AndroidElement txtComparison;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='3']//android.widget.EditText")
	private AndroidElement txtEspPeopleOnUSA;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='5']//android.widget.EditText")
	private AndroidElement txtCampaingsPerYear;
	
	
	//Label questions
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']//android.widget.TextView")
	private AndroidElement lblCompanySituation;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='3']//android.widget.TextView")
	private AndroidElement lblName_Case;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='5']//android.widget.TextView")
	private AndroidElement lblSecurityRequire;
	
	
	@AndroidFindBy(id="form_back_button")
	private AndroidElement btnBack;
	
	@AndroidFindBy(id="savebutton")
	private AndroidElement btnSave;
	
	@AndroidFindBy(id="form_forward_button")
	private AndroidElement btnNext;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	private AndroidElement btnBackToMain;
	
	
	public void typeOnNumberQuestions(String nCharacters, String nPeople, String age){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@index='1']")));
		//typeOnElementos(txtNCharacters, nCharacters);
		clickOnElement(txtNCharacters);
		adbType(nCharacters);
		//typeOnElementos(txtNPeople, nPeople);
		clickOnElement(txtNPeople);
		adbType(nPeople);
		
		//typeOnElementos(txtAge, age);
		clickOnElement(txtAge);
		adbType(age);
	}
	
	public void typeOnTextQuestions(String comparison, String espPeopleOnUsa, String campaignsPeryear){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView")));
		
		clickOnElement(txtComparison);
		adbType(comparison);
		clickOnElement(txtEspPeopleOnUSA);
		adbType(espPeopleOnUsa);
		clickOnElement(txtCampaingsPerYear);
		adbType(campaignsPeryear);
		
	}
	
	public void typeOnLabelQuestions(String nCharacters, String nPeople, String age){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView")));
		typeOnElementos(txtNCharacters, nCharacters);
		typeOnElementos(txtNPeople, nPeople);
		typeOnElementos(txtAge, age);
		
	}
	
	public void tapOnRadioQuestions(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView")));
		clickOnElement(rbMale);
		
	}
	
	public void tapOnTodaysDate(){
		clickOnElement(btnToday);
		
	}
	
	public void tapOnNext(){
		clickOnElement(btnNext);
		
	}
	
	public void tapOnSave(){
		clickOnElement(btnSave);
		
	}
	
	public CreateRecordPage tapOnMainPage(){
		clickOnElement(btnBackToMain);
		return new CreateRecordPage(driver);
		
	}
	
	public int getX (int x) {
	     return (int) ((winSize.width * x) / 100);
	}
	
	public int getY (int y) {
	     return (int) ((winSize.height * y) / 100);
	     
	}
	
	public void scrollDown(){
		
		winSize = driver.manage().window().getSize();
		
		int startX = getX(50); int endX = getX(50);
		int startY = getY(80); int endY = getY(13);
		
		
		driver.swipe(startX, startY, endX, endY, 3000);
		
		
	}
	
	public void calendarScrollNextDay(){
		int topY = calendar.getLocation().getY();
		int bottomY = topY - calendar.getSize().getHeight();
		int centerX = calendar.getLocation().getX() + (calendar.getSize().getWidth()/2);
		driver.swipe(centerX, bottomY, centerX, topY, 3000);
		
	}
	
	
}
