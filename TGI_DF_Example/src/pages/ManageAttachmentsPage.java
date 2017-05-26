package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import generic.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ManageAttachmentsPage extends BasePage {
	org.openqa.selenium.Dimension winSize;
	
	@AndroidFindBy(id="buttonStartStillCamera")
	private AndroidElement btnTakePicture;
	
	@AndroidFindBy(id="buttonStartFileAttachment")
	private AndroidElement btnAttachment;
	
	@AndroidFindBy(id="buttonStartGallaryPage")
	private AndroidElement btnGallery;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='5']//android.widget.TextView")
	private AndroidElement btnDownload;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']//android.widget.TextView[@text='SampleWithGeoTag.jpg']")
	private AndroidElement btnImage1;
	
	public ManageAttachmentsPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	public void tapOnAttachmentButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc='Form Attachments']")));
		clickOnElement(btnAttachment);
		
	}
	
	public void tapOnPictureButton() {
		clickOnElement(btnTakePicture);
		
	}
	
	public void takeAPicture(){
		winSize = driver.manage().window().getSize();
		
		int x = winSize.width / 2;
		int y = winSize.height / 2;
		int duration = 500;
		TouchAction tap = new TouchAction(driver);
		tap.press(x, y).waitAction(duration).release().perform();
		
	}

	public CreateRecordPage tapBackToCreateRecord() {
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		return new CreateRecordPage(driver);
		
	}
	
	public void  tapBack() {
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);	 

}
	
	public void selectAttachments(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@index='5']//android.widget.TextView")));
		clickOnElement(btnDownload);
		
		clickOnElement(btnImage1);
		
	}
	
}