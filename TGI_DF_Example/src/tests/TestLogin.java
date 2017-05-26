package tests;

import java.util.Calendar;

import org.testng.annotations.Test;

import generic.BaseTest;
import pages.AuthorPage;
import pages.CreateRecordPage;
import pages.LoginPage;
import pages.MasterPage;


public class TestLogin extends BaseTest{
		
	private LoginPage loginPage;
	private AuthorPage authorPage;
	private CreateRecordPage createRecordPage;
	private MasterPage masterPage;
	
	
	@Test
	public void sendRecord() throws InterruptedException{
	
		loginPage = new LoginPage(driver);
		loginPage.validLogin("password12", "password12");
		

		loginPage.tapCreateAccount();
		
		authorPage = loginPage.type_Author_Organization("Jafeth Jaen", "Avantica Lib");
		
		Thread.sleep(5000); 
		
		createRecordPage = authorPage.tapOnCreateRecord();
		
		masterPage = createRecordPage.typeAFormTitleAndTapOnForm("QA Example");
		
		masterPage.typeOnNumberQuestions("80", "60", "40");
		masterPage.tapOnNext();
	
		masterPage.tapOnRadioQuestions();

		masterPage.tapOnNext();

		masterPage.tapOnTodaysDate();
		masterPage.scrollDown();
		masterPage.calendarScrollNextDay();
		Thread.sleep(3000);
		masterPage.scrollDown();
		Thread.sleep(5000);
		masterPage.tapOnNext();
		
		masterPage.typeOnTextQuestions("They are the same", "45%", "900");
		masterPage.tapOnNext();
	
		masterPage.tapOnNext();
		createRecordPage = masterPage.tapOnMainPage();
		createRecordPage.sendRecordToServer();
		Thread.sleep(5000);
		
		
		
		
		
	}
	
	}

