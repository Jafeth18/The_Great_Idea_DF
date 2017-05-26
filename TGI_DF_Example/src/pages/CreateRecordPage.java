package pages;

import org.openqa.selenium.support.PageFactory;

import generic.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateRecordPage extends BasePage {

	@AndroidFindBy(id="formTitle")
	private AndroidElement txtFormTitle;
	
	@AndroidFindBy(id="title")
	private AndroidElement firstOption;
	
	@AndroidFindBy(id="syncButton")
	private AndroidElement btnSend;
	
	@AndroidFindBy(id="manageAttachmentsButton")
	private AndroidElement btnAttachment;
	
	
	public CreateRecordPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	public MasterPage typeAFormTitleAndTapOnForm(String txtTitle){
		typeOnElementos(txtFormTitle, txtTitle);
		clickOnElement(firstOption);
		
		return new MasterPage(driver);
		
		
	}
	
	public void sendRecordToServer (){
		
		clickOnElement(btnSend);
		
	}
public ManageAttachmentsPage tapOnAttachmentButton (){
		
		clickOnElement(btnAttachment);
		return new ManageAttachmentsPage(driver);
		
	}
	
}
