package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginPage extends BasePage{
	
	WebDriverWait wait = new WebDriverWait(driver, 30);	
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='1']//android.widget.EditText")
	private AndroidElement txtPassword;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='2']//android.widget.EditText")
	private AndroidElement txtConfirmPass;
	
	@AndroidFindBy(xpath="//android.widget.Button") //create_account_button
	private AndroidElement btnCreateAccount;
	
	@AndroidFindBy(id="author_textfield")
	private AndroidElement txtAuthor;
	
	@AndroidFindBy(id="organization_textfield")
	private AndroidElement txtOrganization;
	
	@AndroidFindBy(id="save_button")
	private AndroidElement btnSave;
	
	
	public LoginPage (AppiumDriver driver){
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	public void validLogin (String pass1, String pass2) throws InterruptedException {
		typeOnElementos(txtPassword, pass1);
		typeOnElementos(txtConfirmPass, pass2);
		
	}
	
	public AuthorPage type_Author_Organization(String author, String organization){
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.LinearLayout[@class='android.widget.LinearLayout']//android.widget.Button")));
		typeOnElementos(txtAuthor, author);
		typeOnElementos(txtOrganization, organization);
		clickOnElement(btnSave);
		
		return new AuthorPage(driver);
	}
	
	public void tapCreateAccount (){
		clickOnElement(btnCreateAccount);
		
	}
	
}
